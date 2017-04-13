package additional_properties_yaml

import org.scalacheck.Gen
import org.scalacheck.Arbitrary
import play.api.libs.json.scalacheck.JsValueGenerators
import Arbitrary._
import scala.collection.immutable.Map
import scala.math.BigInt

object Generators extends JsValueGenerators {
    

    
    def createKeyedArraysAdditionalPropertiesGenerator = _generate(KeyedArraysAdditionalPropertiesGenerator)
    

    
    def KeyedArraysAdditionalPropertiesGenerator: Gen[Map[String, Seq]] = _genMap[String,Seq](arbitrary[String], Gen.containerOf[List,BigInt](arbitrary[BigInt]))
    

    def createKeyedArraysGenerator = _generate(KeyedArraysGenerator)


    def KeyedArraysGenerator = for {
        additionalProperties <- KeyedArraysAdditionalPropertiesGenerator
    } yield KeyedArrays(additionalProperties)

    def _generate[T](gen: Gen[T]) = (count: Int) => for (i <- 1 to count) yield gen.sample

    
    def _genMap[K,V](keyGen: Gen[K], valGen: Gen[V]): Gen[Map[K,V]] = for {
        keys <- Gen.containerOf[List,K](keyGen)
        values <- Gen.containerOfN[List,V](keys.size, valGen)
    } yield keys.zip(values).toMap
    
    
    
    

}