

    import de.zalando.play.controllers.ArrayWrapper

    import de.zalando.play.controllers.PlayPathBindables


//noinspection ScalaStyle
package expanded {


    case class NewPet(name: String, tag: Option[String]) 
    case class Pet(name: String, tag: Option[String], id: Long) 
    case class Error(code: Int, message: String) 


    import play.api.libs.json._
    import play.api.libs.functional.syntax._
    import de.zalando.play.controllers.MissingDefaultReads
    object BodyReads extends MissingDefaultReads {
        implicit val NewPetReads: Reads[NewPet] = (
            (JsPath \ "name").read[String] and (JsPath \ "tag").read[Option[String]]
        )(NewPet.apply _)
    }

    import play.api.libs.json._
    import play.api.libs.functional.syntax._
    import de.zalando.play.controllers.MissingDefaultWrites
    object ResponseWrites extends MissingDefaultWrites {
    implicit val PetWrites: Writes[Pet] = new Writes[Pet] {
        def writes(ss: Pet) =
          Json.obj(
            "name" -> ss.name, 
            "tag" -> ss.tag, 
            "id" -> ss.id
          )
        }
    implicit val NewPetWrites: Writes[NewPet] = new Writes[NewPet] {
        def writes(ss: NewPet) =
          Json.obj(
            "name" -> ss.name, 
            "tag" -> ss.tag
          )
        }
    }
}

// should be defined after the package because of the https://issues.scala-lang.org/browse/SI-9922

//noinspection ScalaStyle
package object expanded {

    type PetsIdDeleteResponses204 = Null


import play.api.mvc.{QueryStringBindable, PathBindable}

    implicit val bindable_OptionIntQuery: QueryStringBindable[Option[Int]] = PlayPathBindables.createOptionQueryBindable[Int]
    implicit val bindable_ArrayWrapperStringQuery: QueryStringBindable[ArrayWrapper[String]] = PlayPathBindables.createArrayWrapperQueryBindable[String]("csv")
    implicit val bindable_OptionArrayWrapperQuery: QueryStringBindable[Option[ArrayWrapper]] = PlayPathBindables.createOptionQueryBindable[ArrayWrapper]

}