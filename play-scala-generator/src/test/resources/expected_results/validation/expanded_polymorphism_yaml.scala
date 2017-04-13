package expanded
import play.api.mvc.{Action, Controller}
import play.api.data.validation.Constraint
import de.zalando.play.controllers._
import PlayBodyParsing._
import PlayValidations._

import de.zalando.play.controllers.ArrayWrapper
// ----- constraints and wrapper validations -----
class PetsIdDeleteIdConstraints(override val instance: Long) extends ValidationBase[Long] {
    override def constraints: Seq[Constraint[Long]] =
        Seq()
}
class PetsIdDeleteIdValidator(instance: Long) extends RecursiveValidator {
    override val validators = Seq(new PetsIdDeleteIdConstraints(instance))
}
class PetsGetLimitOptConstraints(override val instance: Int) extends ValidationBase[Int] {
    override def constraints: Seq[Constraint[Int]] =
        Seq(max(10.toInt, false), min(1.toInt, false))
}
class PetsGetLimitOptValidator(instance: Int) extends RecursiveValidator {
    override val validators = Seq(new PetsGetLimitOptConstraints(instance))
}
class PetsIdGetIdConstraints(override val instance: Long) extends ValidationBase[Long] {
    override def constraints: Seq[Constraint[Long]] =
        Seq()
}
class PetsIdGetIdValidator(instance: Long) extends RecursiveValidator {
    override val validators = Seq(new PetsIdGetIdConstraints(instance))
}
class PetsGetTagsOptArrConstraints(override val instance: String) extends ValidationBase[String] {
    override def constraints: Seq[Constraint[String]] =
        Seq()
}
class PetsGetTagsOptArrValidator(instance: String) extends RecursiveValidator {
    override val validators = Seq(new PetsGetTagsOptArrConstraints(instance))
}
class NewPetNameConstraints(override val instance: String) extends ValidationBase[String] {
    override def constraints: Seq[Constraint[String]] =
        Seq()
}
class NewPetNameValidator(instance: String) extends RecursiveValidator {
    override val validators = Seq(new NewPetNameConstraints(instance))
}
class NewPetTagOptConstraints(override val instance: String) extends ValidationBase[String] {
    override def constraints: Seq[Constraint[String]] =
        Seq()
}
class NewPetTagOptValidator(instance: String) extends RecursiveValidator {
    override val validators = Seq(new NewPetTagOptConstraints(instance))
}
// ----- complex type validators -----
class NewPetValidator(instance: NewPet) extends RecursiveValidator {
    override val validators = Seq(
        new NewPetNameValidator(instance.name), 
        new NewPetTagValidator(instance.tag)
    )
}

// ----- option delegating validators -----
class PetsGetLimitValidator(instance: Option[Int]) extends RecursiveValidator {
    override val validators = instance.toSeq.map { new PetsGetLimitOptValidator(_) }
}
class PetsGetTagsValidator(instance: Option[ArrayWrapper[String]]) extends RecursiveValidator {
    override val validators = instance.toSeq.map { new PetsGetTagsOptValidator(_) }
}
class NewPetTagValidator(instance: Option[String]) extends RecursiveValidator {
    override val validators = instance.toSeq.map { new NewPetTagOptValidator(_) }
}
// ----- array delegating validators -----
class PetsGetTagsOptConstraints(override val instance: ArrayWrapper[String]) extends ValidationBase[ArrayWrapper[String]] {
    override def constraints: Seq[Constraint[ArrayWrapper[String]]] =
        Seq()
}
class PetsGetTagsOptValidator(instance: ArrayWrapper[String]) extends RecursiveValidator {
    override val validators = new PetsGetTagsOptConstraints(instance) +: instance.map { new PetsGetTagsOptArrValidator(_)}
}
// ----- catch all simple validators -----
// ----- composite validators -----
// ----- call validations -----
class PetsPostValidator(pet: NewPet) extends RecursiveValidator {
    override val validators = Seq(
        new NewPetValidator(pet)
    
    )
}
class PetsGetValidator(tags: Option[ArrayWrapper[String]], limit: Option[Int]) extends RecursiveValidator {
    override val validators = Seq(
        new PetsGetTagsValidator(tags), 
    
        new PetsGetLimitValidator(limit)
    
    )
}
class PetsIdDeleteValidator(id: Long) extends RecursiveValidator {
    override val validators = Seq(
        new PetsIdDeleteIdValidator(id)
    
    )
}
