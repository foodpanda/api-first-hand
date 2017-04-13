package instagram.api


    import scala.math.BigInt
    import scala.math.BigDecimal

    import de.zalando.play.controllers.PlayPathBindables


//noinspection ScalaStyle
package yaml {


    case class UserCountsOptionCounts(media: Option[BigInt], follows: Option[BigInt], follwed_by: Option[BigInt]) 
    case class UsersSelfFeedGetResponses200(data: Option[Seq[Media]]) 
    case class MediaSearchGetResponses200DataOptionSeqData(created_time: Option[BigInt], filter: Option[String], id: Option[BigInt], `type`: Option[String], location: Option[Location], comments_esc: Option[MediaComments_OptionComments_esc], tags: Option[Seq[Tag]], users_in_photo: Option[Seq[MiniProfile]], likes: Option[MediaLikesOptionLikes], videos: Option[MediaVideosOptionVideos], images: Option[MediaImagesOptionImages], user: Option[MiniProfile], distance: Option[BigDecimal]) 
    case class TagsSearchGetResponses200MetaOptionMeta(code: Option[BigInt]) 
    case class MediaMedia_idCommentsDeleteResponses200(data: Option[String], meta: Option[MediaMedia_idCommentsDeleteResponses200MetaOptionMeta]) 
    case class UsersUser_idFollowsGetResponses200(data: Option[Seq[MiniProfile]]) 
    case class User(website: Option[String], profile_picture: Option[String], username: Option[String], full_name: Option[String], bio: Option[String], id: Option[BigInt], counts: Option[UserCountsOptionCounts]) 
    case class TagsTag_nameMediaRecentGetResponses200(data: Option[Seq[Tag]]) 
    case class Image(width: Option[BigInt], height: Option[BigInt], url: Option[String]) 
    case class UsersSelfRequested_byGetResponses200(meta: Option[TagsSearchGetResponses200MetaOptionMeta], data: Option[Seq[MiniProfile]]) 
    case class MediaMedia_idCommentsDeleteResponses200MetaOptionMeta(code: Option[BigDecimal]) 
    case class Tag(media_count: Option[BigInt], name: Option[String]) 
    case class LocationsLocation_idGetResponses200(data: Option[Location]) 
    case class Comment(id: Option[String], created_time: Option[String], text: Option[String], from: Option[MiniProfile]) 
    case class Media(created_time: Option[BigInt], filter: Option[String], id: Option[BigInt], `type`: Option[String], location: Option[Location], comments_esc: Option[MediaComments_OptionComments_esc], tags: Option[Seq[Tag]], users_in_photo: Option[Seq[MiniProfile]], likes: Option[MediaLikesOptionLikes], videos: Option[MediaVideosOptionVideos], images: Option[MediaImagesOptionImages], user: Option[MiniProfile]) 
    case class MediaMedia_idLikesGetResponses200(meta: Option[MediaMedia_idCommentsDeleteResponses200MetaOptionMeta], data: Option[Seq[Like]]) 
    case class MediaSearchGetResponses200(data: Option[Seq[MediaSearchGetResponses200DataOptionSeqData]]) 
    case class TagsSearchGetResponses200(meta: Option[TagsSearchGetResponses200MetaOptionMeta], data: Option[Seq[Tag]]) 
    case class Like(first_name: Option[String], id: Option[String], last_name: Option[String], `type`: Option[String], user_name: Option[String]) 
    case class UsersUser_idGetResponses200(data: Option[User]) 
    case class MediaMedia_idCommentsGetResponses200(meta: Option[MediaMedia_idCommentsDeleteResponses200MetaOptionMeta], data: Option[Seq[Comment]]) 
    case class MediaLikesOptionLikes(count: Option[BigInt], data: Option[Seq[MiniProfile]]) 
    case class Location(id: Option[String], name: Option[String], latitude: Option[BigDecimal], longitude: Option[BigDecimal]) 
    case class MediaComments_OptionComments_esc(count: Option[BigInt], data: Option[Seq[Comment]]) 
    case class MiniProfile(user_name: Option[String], full_name: Option[String], id: Option[BigInt], profile_picture: Option[String]) 
    case class MediaVideosOptionVideos(low_resolution: Option[Image], standard_resolution: Option[Image]) 
    case class MediaImagesOptionImages(low_resolution: Option[Image], thumbnail: Option[Image], standard_resolution: Option[Image]) 
    case class LocationsSearchGetResponses200(data: Option[Seq[Location]]) 

    case class UsersUser_idRelationshipPostActionOptionEnum(override val value: String) extends AnyVal with de.zalando.play.controllers.StringAnyVal

    import play.api.libs.json._
    import play.api.libs.functional.syntax._
    import de.zalando.play.controllers.MissingDefaultWrites
    object ResponseWrites extends MissingDefaultWrites {
    implicit val UsersSelfRequested_byGetResponses200Writes: Writes[UsersSelfRequested_byGetResponses200] = new Writes[UsersSelfRequested_byGetResponses200] {
        def writes(ss: UsersSelfRequested_byGetResponses200) =
          Json.obj(
            "meta" -> ss.meta, 
            "data" -> ss.data
          )
        }
    implicit val LocationsSearchGetResponses200Writes: Writes[LocationsSearchGetResponses200] = new Writes[LocationsSearchGetResponses200] {
        def writes(ss: LocationsSearchGetResponses200) =
          Json.obj(
            "data" -> ss.data
          )
        }
    implicit val MediaSearchGetResponses200Writes: Writes[MediaSearchGetResponses200] = new Writes[MediaSearchGetResponses200] {
        def writes(ss: MediaSearchGetResponses200) =
          Json.obj(
            "data" -> ss.data
          )
        }
    implicit val UserWrites: Writes[User] = new Writes[User] {
        def writes(ss: User) =
          Json.obj(
            "website" -> ss.website, 
            "profile_picture" -> ss.profile_picture, 
            "username" -> ss.username, 
            "full_name" -> ss.full_name, 
            "bio" -> ss.bio, 
            "id" -> ss.id, 
            "counts" -> ss.counts
          )
        }
    implicit val UsersUser_idGetResponses200Writes: Writes[UsersUser_idGetResponses200] = new Writes[UsersUser_idGetResponses200] {
        def writes(ss: UsersUser_idGetResponses200) =
          Json.obj(
            "data" -> ss.data
          )
        }
    implicit val TagsTag_nameMediaRecentGetResponses200Writes: Writes[TagsTag_nameMediaRecentGetResponses200] = new Writes[TagsTag_nameMediaRecentGetResponses200] {
        def writes(ss: TagsTag_nameMediaRecentGetResponses200) =
          Json.obj(
            "data" -> ss.data
          )
        }
    implicit val MediaMedia_idCommentsGetResponses200Writes: Writes[MediaMedia_idCommentsGetResponses200] = new Writes[MediaMedia_idCommentsGetResponses200] {
        def writes(ss: MediaMedia_idCommentsGetResponses200) =
          Json.obj(
            "meta" -> ss.meta, 
            "data" -> ss.data
          )
        }
    implicit val TagsSearchGetResponses200Writes: Writes[TagsSearchGetResponses200] = new Writes[TagsSearchGetResponses200] {
        def writes(ss: TagsSearchGetResponses200) =
          Json.obj(
            "meta" -> ss.meta, 
            "data" -> ss.data
          )
        }
    implicit val ImageWrites: Writes[Image] = new Writes[Image] {
        def writes(ss: Image) =
          Json.obj(
            "width" -> ss.width, 
            "height" -> ss.height, 
            "url" -> ss.url
          )
        }
    implicit val TagWrites: Writes[Tag] = new Writes[Tag] {
        def writes(ss: Tag) =
          Json.obj(
            "media_count" -> ss.media_count, 
            "name" -> ss.name
          )
        }
    implicit val CommentWrites: Writes[Comment] = new Writes[Comment] {
        def writes(ss: Comment) =
          Json.obj(
            "id" -> ss.id, 
            "created_time" -> ss.created_time, 
            "text" -> ss.text, 
            "from" -> ss.from
          )
        }
    implicit val MediaWrites: Writes[Media] = new Writes[Media] {
        def writes(ss: Media) =
          Json.obj(
            "created_time" -> ss.created_time, 
            "filter" -> ss.filter, 
            "id" -> ss.id, 
            "`type`" -> ss.`type`, 
            "location" -> ss.location, 
            "comments_esc" -> ss.comments_esc, 
            "tags" -> ss.tags, 
            "users_in_photo" -> ss.users_in_photo, 
            "likes" -> ss.likes, 
            "videos" -> ss.videos, 
            "images" -> ss.images, 
            "user" -> ss.user
          )
        }
    implicit val UsersSelfFeedGetResponses200Writes: Writes[UsersSelfFeedGetResponses200] = new Writes[UsersSelfFeedGetResponses200] {
        def writes(ss: UsersSelfFeedGetResponses200) =
          Json.obj(
            "data" -> ss.data
          )
        }
    implicit val LocationWrites: Writes[Location] = new Writes[Location] {
        def writes(ss: Location) =
          Json.obj(
            "id" -> ss.id, 
            "name" -> ss.name, 
            "latitude" -> ss.latitude, 
            "longitude" -> ss.longitude
          )
        }
    implicit val LocationsLocation_idGetResponses200Writes: Writes[LocationsLocation_idGetResponses200] = new Writes[LocationsLocation_idGetResponses200] {
        def writes(ss: LocationsLocation_idGetResponses200) =
          Json.obj(
            "data" -> ss.data
          )
        }
    implicit val MiniProfileWrites: Writes[MiniProfile] = new Writes[MiniProfile] {
        def writes(ss: MiniProfile) =
          Json.obj(
            "user_name" -> ss.user_name, 
            "full_name" -> ss.full_name, 
            "id" -> ss.id, 
            "profile_picture" -> ss.profile_picture
          )
        }
    implicit val UsersUser_idFollowsGetResponses200Writes: Writes[UsersUser_idFollowsGetResponses200] = new Writes[UsersUser_idFollowsGetResponses200] {
        def writes(ss: UsersUser_idFollowsGetResponses200) =
          Json.obj(
            "data" -> ss.data
          )
        }
    implicit val MediaMedia_idCommentsDeleteResponses200Writes: Writes[MediaMedia_idCommentsDeleteResponses200] = new Writes[MediaMedia_idCommentsDeleteResponses200] {
        def writes(ss: MediaMedia_idCommentsDeleteResponses200) =
          Json.obj(
            "data" -> ss.data, 
            "meta" -> ss.meta
          )
        }
    implicit val LikeWrites: Writes[Like] = new Writes[Like] {
        def writes(ss: Like) =
          Json.obj(
            "first_name" -> ss.first_name, 
            "id" -> ss.id, 
            "last_name" -> ss.last_name, 
            "`type`" -> ss.`type`, 
            "user_name" -> ss.user_name
          )
        }
    implicit val MediaMedia_idLikesGetResponses200Writes: Writes[MediaMedia_idLikesGetResponses200] = new Writes[MediaMedia_idLikesGetResponses200] {
        def writes(ss: MediaMedia_idLikesGetResponses200) =
          Json.obj(
            "meta" -> ss.meta, 
            "data" -> ss.data
          )
        }
    }
}

// should be defined after the package because of the https://issues.scala-lang.org/browse/SI-9922

//noinspection ScalaStyle
package object yaml {

    type GeographiesGeo_idMediaRecentGetResponses200 = Null

    object UsersUser_idRelationshipPostActionOptionEnum {
        
        val Unfollow = new UsersUser_idRelationshipPostActionOptionEnum("unfollow")
        val Approve = new UsersUser_idRelationshipPostActionOptionEnum("approve")
        val Block = new UsersUser_idRelationshipPostActionOptionEnum("block")
        val Unblock = new UsersUser_idRelationshipPostActionOptionEnum("unblock")
        val Follow = new UsersUser_idRelationshipPostActionOptionEnum("follow")

        implicit def stringToUsersUser_idRelationshipPostActionOptionEnum: String => UsersUser_idRelationshipPostActionOptionEnum = {
            case "unfollow" => Unfollow
            case "approve" => Approve
            case "block" => Block
            case "unblock" => Unblock
            case "follow" => Follow
            case other =>
                throw new IllegalArgumentException("Couldn't parse parameter " + other)
        }
    }

import play.api.mvc.{QueryStringBindable, PathBindable}

    implicit val bindable_BigIntQuery = PlayPathBindables.queryBindableBigInt
    implicit val bindable_BigDecimalPath = PlayPathBindables.pathBindableBigDecimal
    implicit val bindable_BigIntPath = PlayPathBindables.pathBindableBigInt
    implicit val bindable_BigDecimalQuery = PlayPathBindables.queryBindableBigDecimal
    implicit val bindable_OptionStringQuery: QueryStringBindable[Option[String]] = PlayPathBindables.createOptionQueryBindable[String]
    implicit val bindable_OptionBigIntQuery: QueryStringBindable[Option[BigInt]] = PlayPathBindables.createOptionQueryBindable[BigInt]
    implicit val bindable_OptionBigDecimalQuery: QueryStringBindable[Option[BigDecimal]] = PlayPathBindables.createOptionQueryBindable[BigDecimal]

}