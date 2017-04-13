package string_formats


    import de.zalando.play.controllers.Base64String
    import Base64String._
    import de.zalando.play.controllers.BinaryString
    import BinaryString._
    import java.time.ZonedDateTime
    import java.util.UUID
    import java.time.LocalDate

    import de.zalando.play.controllers.PlayPathBindables


//noinspection ScalaStyle
package yaml {




}

// should be defined after the package because of the https://issues.scala-lang.org/browse/SI-9922

//noinspection ScalaStyle
package object yaml {

    type GetResponses200 = Null


import play.api.mvc.{QueryStringBindable, PathBindable}

    implicit val bindable_Base64StringQuery = PlayPathBindables.queryBindableBase64String
    implicit val bindable_DateTimeQuery = PlayPathBindables.queryBindableDateTime
    implicit val bindable_UUIDQuery = PlayPathBindables.queryBindableUUID
    implicit val bindable_LocalDateQuery = PlayPathBindables.queryBindableLocalDate
    implicit val bindable_OptionBase64StringQuery: QueryStringBindable[Option[Base64String]] = PlayPathBindables.createOptionQueryBindable[Base64String]
    implicit val bindable_OptionZonedDateTimeQuery: QueryStringBindable[Option[ZonedDateTime]] = PlayPathBindables.createOptionQueryBindable[ZonedDateTime]
    implicit val bindable_OptionUUIDQuery: QueryStringBindable[Option[UUID]] = PlayPathBindables.createOptionQueryBindable[UUID]
    implicit val bindable_OptionLocalDateQuery: QueryStringBindable[Option[LocalDate]] = PlayPathBindables.createOptionQueryBindable[LocalDate]

}