package de.zalando.apifirst

import de.zalando.apifirst.Application._
import de.zalando.apifirst.Domain._
import de.zalando.apifirst.naming.Reference

import scala.annotation.tailrec
import scala.language.reflectiveCalls

object TypeNormaliser {
  val flatten: (StrictModel) => StrictModel =
    ParameterDereferencer.apply _ andThen TypeDeduplicator.apply andThen TypeFlattener.apply andThen TypeDeduplicator.apply
}

object TypeDeduplicator extends TypeAnalyzer {

  private def equal(app: StrictModel) = (t1: Type, t2: Type) =>
    t1 == t2 ||
      ((notHierarchyRoot(t1, app) || notHierarchyRoot(t2, app)) && isSameTypeDef(t1)(t2) && isSameConstraints(t1)(t2))

  /**
   * Removes redundant type definitions changing pointing references
   *
   * @param app
   * @return
   */
  private[apifirst] def apply(app: StrictModel): StrictModel = {
    val types = app.typeDefs.values
    val duplicate = types.find { t => types.count(equal(app)(t, _)) > 1 }
    duplicate map replaceSingle(app) map apply getOrElse app
  }

  private def notHierarchyRoot(t: Type, app: StrictModel) = !app.discriminators.contains(t.name)

  private def replaceSingle(model: StrictModel): Type => StrictModel = tpe => {
    val duplicates = model.typeDefs.filter { d => equal(model)(tpe, d._2) }
    val duplicateNames = sortByDiscriminatorOrPathLength(model.discriminators, duplicates)
    val bestMatch :: refsToRemove = duplicateNames
    val typesToRewrite = model.typeDefs filterNot { t => refsToRemove.contains(t._1) }
    val callsWithCorrectRefs = model.calls map { c => replaceReferenceInCall(refsToRemove, bestMatch)(c) }
    val typesWithCorrectRefs = typesToRewrite map { (d: (Reference, Type)) =>
      replaceReferencesInTypes(refsToRemove, bestMatch)(d._1, d._2)
    }
    val newParams = model.params map replaceReferenceInParameter(refsToRemove, bestMatch)
    model.copy(typeDefs = typesWithCorrectRefs, params = newParams, calls = callsWithCorrectRefs)
  }

  private def replaceReferenceInCall(duplicateRefs: Seq[Reference], target: Reference): ApiCall => ApiCall = call => {
    val (resultTypesToReplace, resultTypesToHold) = call.resultTypes.results.partition { case (code, ref) => duplicateRefs.contains(ref.name) }
    val resultTypesReplacement = resultTypesToReplace map {
      case (code, ref) =>
        code -> ParameterRef(target)
    }
    val resultTypes = resultTypesToHold ++ resultTypesReplacement
    val default = call.resultTypes.default map { d =>
      if (duplicateRefs.contains(d.name)) ParameterRef(target) else d
    }
    call.copy(resultTypes = TypesResponseInfo(resultTypes, default))
  }

  private def replaceType(tpe: Type, duplicateRefs: Seq[Reference], target: Reference): Type = tpe match {
    case c: Container => replaceContainerType(c, duplicateRefs, target)
    case c: Composite => replaceCompositeType(c, duplicateRefs, target)
    case t: TypeDef => replaceTypeDefType(t, duplicateRefs, target)
    case n: TypeRef if duplicateRefs.contains(n.name) => TypeRef(target)
    case _ => tpe
  }

  private def replaceContainerType(c: Container, duplicateRefs: Seq[Reference], target: Reference): Type = c.tpe match {
    case r: TypeRef if duplicateRefs.contains(r.name) => c.withType(TypeRef(target))
    case r: Container if isRecursiveContainerType(r) => c.withType(replaceType(r, duplicateRefs, target))
    case o => c
  }

  private def replaceCompositeType(c: Composite, duplicateRefs: Seq[Reference], target: Reference) = {
    val newDescendants = c.descendants map {
      case d: TypeRef if duplicateRefs.contains(d.name) => TypeRef(target)
      case o => o
    }
    c.withTypes(newDescendants)
  }

  private def replaceTypeDefType(t: TypeDef, duplicateRefs: Seq[Reference], target: Reference) = {
    val newFields = t.fields.map {
      case f @ Field(_, tpe: TypeRef) if duplicateRefs.contains(tpe.name) => f.copy(tpe = TypeRef(target))
      case f @ Field(_, c: Container) if isRecursiveContainerType(c) && duplicateRefs.contains(getInnerContainerType(c).name) =>
        f.copy(tpe = replaceContainerType(c, duplicateRefs, target))
      case o => o
    }
    val newName = if (duplicateRefs.contains(t.name)) target else t.name
    t.copy(name = newName, fields = newFields)
  }

  private def getInnerContainerType(c: Container): Type = c.tpe match {
    case inner: Container if isRecursiveContainerType(inner) => getInnerContainerType(inner)
    case inner => inner
  }

  private def replaceReferencesInTypes(duplicateRefs: Seq[Reference], target: Reference): (Reference, Type) => (Reference, Type) = { (ref, tpe) =>
    ref -> replaceType(tpe, duplicateRefs, target)
  }

  private def replaceReferenceInParameter(duplicateRefs: Seq[Reference], target: Reference): ((ParameterRef, Parameter)) => (ParameterRef, Parameter) = {
    case (r: ParameterRef, p: Parameter) if duplicateRefs.contains(p.typeName.name) =>
      r -> p.copy(typeName = TypeRef(target))
    case o => o
  }

  private def sortByDiscriminatorOrPathLength(
    discriminators: DiscriminatorLookupTable,
    duplicates: TypeLookupTable
  ): List[Reference] =
    duplicates.toSeq.sortBy { p =>
      val factor =
        if (discriminators.keySet.contains(p._2.name)) 1
        else if (p._1.isResponsePath) 100000
        else 100
      p._1.tokens.size * factor
    }.map(_._1).toList

}

/**
 * Flattens types by recursively replacing nested type definitions with references
 *
 * This implementation relies on {@ParameterDereferencer} to extract all non-primitive types from parameter definitions
 *
 * Because of that, the {@ParameterDereferencer} MUST be applied before using `TypeFlattener`,
 * otherwise results will be inconsistent parameter definitions
 *
 * @author  slasch
 * @since   11.11.2015.
 */
object TypeFlattener extends TypeAnalyzer {

  private[apifirst] def apply(app: StrictModel): StrictModel = {
    val flatTypeDefs = flatten0(app.typeDefs)
    app.copy(typeDefs = flatTypeDefs)
  }

  private def flatten0(typeDefs: TypeLookupTable): TypeLookupTable = {
    val flatTypeDefs = typeDefs flatMap { case (ref, tpe) => extractComplexType(ref, tpe) }
    if (flatTypeDefs == typeDefs)
      flatTypeDefs
    else
      flatten0(flatTypeDefs)
  }

  private def extractComplexType(ref: Reference, typeDef: Type): Seq[(Reference, Type)] = typeDef match {
    case t: TypeDef if complexFields(t).nonEmpty =>
      val (changedFields, extractedTypes) = complexFields(t).map(createTypeFromField(t)).unzip
      val newFields = t.fields.filterNot(complexField) ++ changedFields
      val newTypeDef = t.copy(fields = newFields)
      (ref -> newTypeDef) +: extractedTypes
    case t: TypeDef if containerFieldsWithComplexType(t).nonEmpty =>
      val (changedFields, extractedTypes) = containerFieldsWithComplexType(t).map(createRecursiveTypeFromContainerField(t)).unzip
      val newFields = t.fields.filterNot(containerFieldWithComplexType) ++ changedFields
      val newTypeDef = t.copy(fields = newFields)
      (ref -> newTypeDef) +: extractedTypes
    case t: EnumTrait =>
      val leafTypes = t.leaves.map { l => ref / l.fieldValue -> l }
      (ref -> t) +: leafTypes.toSeq
    case c: Container if isRecursiveContainerType(c) && isRecursiveComplexType(c) =>
      val (newType, newRef, extractedType) = createRecursiveTypeFromContainer(ref, c)
      Seq(ref -> newType, newRef -> extractedType)
    case c: Container if !isRecursiveContainerType(c) && isComplexType(c.tpe) =>
      val newRef = ref / c.getClass.getSimpleName
      Seq(ref -> c.withType(TypeRef(newRef)), newRef -> c.tpe)
    case c: Composite =>
      val (complexDescendants, simpleDescendants) = c.descendants.partition(isComplexType)
      val (changedTypes, extractedTypes) = complexDescendants.zipWithIndex
        .map(flattenType(c.getClass.getSimpleName, ref)).unzip
      val newTypes = simpleDescendants ++ changedTypes
      val newTypeDef = c.withTypes(newTypes)
      (ref -> newTypeDef) +: extractedTypes
    case _ => Seq(ref -> typeDef)
  }

  private def complexFields(typeDef: TypeDef): Seq[Field] = typeDef.fields filter complexField

  private def complexField: (Field) => Boolean = f => isComplexType(f.tpe)

  private def containerFieldsWithComplexType(typeDef: TypeDef): Seq[Field] = typeDef.fields filter containerFieldWithComplexType

  private def containerFieldWithComplexType: (Field) => Boolean = f => isRecursiveContainerType(f.tpe) && isRecursiveComplexType(f.tpe)

  private def createTypeFromField(t: TypeDef): (Field) => (Field, (Reference, Type)) = field => {
    val newReference = TypeRef(t.name / field.name.simple)

    val extractedType = field.tpe
    (field.copy(tpe = newReference), newReference.name -> extractedType)
  }

  private def createRecursiveTypeFromContainerField(t: Type): (Field) => (Field, (Reference, Type)) = field => {
    val reference = t.name / field.name.simple

    val (newType, newReference, extractedType) = createRecursiveTypeFromContainer(reference, field.tpe)

    (field.copy(tpe = newType), newReference -> extractedType)
  }

  private def createRecursiveTypeFromContainer(ref: Reference, t: Type): (Type, Reference, Type) = {
    val newReference = ref / t.name.simple

    t match {
      case c: Container if isRecursiveContainerType(c) =>
        val result = createRecursiveTypeFromContainer(newReference, c.tpe)
        result.copy(c.withType(result._1))

      case t =>
        (TypeRef(newReference), newReference, t)
    }
  }

  private def flattenType: (String, Reference) => ((Type, Int)) => (Type, (Reference, Type)) = (name, ref) => pair => {
    val (typeDef, index) = pair
    val newReference = TypeRef(ref / (name + index))
    (newReference, newReference.name -> typeDef)
  }

}

object ParameterDereferencer extends TypeAnalyzer {
  /**
   * Converts inline type definitions into type references
   * @param app
   * @return
   */
  @tailrec
  private[apifirst] def apply(app: StrictModel): StrictModel = {
    var result = app
    result.params foreach {
      case (name: ParameterRef, definition: Expr) =>
        definition.typeName match {
          case tpe if isComplexTypeParam(tpe) =>
            val newName = name.name / "ref"
            val newReference = TypeRef(newName)
            val tps = app.typeDefs + (newName -> tpe)
            val newParams = app.params.updated(name, definition.copy(typeName = newReference))
            result = result.copy(typeDefs = tps, params = newParams)
          case _ =>
        }
    }
    if (result == app) result else apply(result)
  }
}

trait TypeAnalyzer {
  def isComplexType(t: Type): Boolean = t match {
    case _: TypeDef | _: Composite => true
    case t: Container => !isRecursiveContainerType(t)
    case _ => false
  }

  def isComplexTypeParam(t: Type): Boolean = t match {
    case _: TypeDef | _: Composite | _: Container => true
    case _ => false
  }

  def isRecursiveComplexType(t: Type): Boolean = t match {
    case c: Container if isRecursiveContainerType(c) => isRecursiveComplexType(c.tpe)
    case tpe => isComplexType(tpe)
  }

  def isRecursiveContainerType(t: Type): Boolean =
    t.isInstanceOf[Arr] || t.isInstanceOf[ArrResult] || t.isInstanceOf[Opt]

  def isSameConstraints(one: Type)(two: Type): Boolean = (one, two) match {
    case (c1: Container, c2: Container) if c1.getClass == c2.getClass =>
      isSameConstraints(c1.tpe)(c2.tpe)
    case (c1: Composite, c2: Composite) if c1.getClass == c2.getClass && c1.descendants.size == c2.descendants.size =>
      c1.descendants.zip(c2.descendants).map(d => isSameConstraints(d._1)(d._2)).forall(_ == true)
    case (t1: TypeDef, t2: TypeDef) if t1.fields.size == t2.fields.size =>
      t1.fields.zip(t2.fields).map(f => isSameConstraints(f._1.tpe)(f._2.tpe)).forall(_ == true)
    case (t1: ProvidedType, t2: ProvidedType) if t1.getClass == t2.getClass =>
      isSamePrimitiveConstraints(t1)(t2)
    case (r1: TypeRef, r2: TypeRef) =>
      r1.meta == r2.meta
    case _ => false
  }

  def isSamePrimitiveConstraints(one: Type)(two: Type): Boolean =
    one.meta.constraints.size == two.meta.constraints.size &&
      one.meta.constraints.intersect(two.meta.constraints).size == one.meta.constraints.size

  def isSameTypeDef(one: Type)(two: Type): Boolean = (one, two) match {
    case (c1: EnumObject, c2: EnumObject) if c1.tpe == c2.tpe =>
      c1 == c2 || c1.fieldValue == c2.fieldValue
    case (c1: EnumTrait, c2: EnumTrait) if c1.tpe == c2.tpe =>
      c1 == c2 || c1.leaves.map(_.fieldValue) == c2.leaves.map(_.fieldValue)
    case (c1: Container, c2: Container) if c1.getClass == c2.getClass =>
      c1 == c2 || isSameTypeDef(c1.tpe)(c2.tpe)
    case (c1: Composite, c2: Composite) if c1.getClass == c2.getClass && c1.descendants.size == c2.descendants.size =>
      c1 == c2 || sameDescendants(c1, c2)
    case (t1: TypeDef, t2: TypeDef) if t1.fields.size == t2.fields.size =>
      t1 == t2 || sameFields(t1, t2)
    case (t1: ProvidedType, t2: ProvidedType) if t1.getClass == t2.getClass =>
      t1 == t2 || sameNames(t1, t2)
    case (r1: TypeRef, r2: TypeRef) =>
      r1.name == r2.name
    case _ => false
  }

  def sameFields(t1: TypeDef, t2: TypeDef): Boolean = {
    t1.fields.forall { field =>
      t2.fields.exists { e => isSameTypeDef(field.tpe)(e.tpe) & sameNames(field, e) }
    }
  }

  type hasSimpleName = { def name: { def simple: String } }

  def sameNames(p: hasSimpleName, e: hasSimpleName): Boolean =
    p.name.simple == e.name.simple

  def sameDescendants(c1: Composite, c2: Composite): Boolean =
    c1.root == c2.root &&
      c1.descendants.forall(p => c2.descendants.exists(isSameTypeDef(p)))

}
