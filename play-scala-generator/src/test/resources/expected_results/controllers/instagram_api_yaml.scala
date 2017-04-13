
import play.api.mvc.{Action,Controller}

import play.api.data.validation.Constraint

import play.api.inject.{ApplicationLifecycle,ConfigurationProvider}

import de.zalando.play.controllers._

import PlayBodyParsing._

import PlayValidations._

import scala.util._

import javax.inject._

import scala.math.BigInt

import scala.math.BigInt

import scala.math.BigDecimal


/**
 * This controller is re-generated after each change in the specification.
 * Please only place your hand-written code between appropriate comments in the body of the controller.
 */

package instagram.api.yaml {
    // ----- Start of unmanaged code area for package InstagramApiYaml
    
    // ----- End of unmanaged code area for package InstagramApiYaml
    class InstagramApiYaml @Inject() (
        // ----- Start of unmanaged code area for injections InstagramApiYaml

        // ----- End of unmanaged code area for injections InstagramApiYaml
        lifecycle: ApplicationLifecycle,
        config: ConfigurationProvider
    ) extends InstagramApiYamlBase {
        // ----- Start of unmanaged code area for constructor InstagramApiYaml

        // ----- End of unmanaged code area for constructor InstagramApiYaml
        val getmediaByMedia_idLikes = getmediaByMedia_idLikesAction { (media_id: BigInt) =>  
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getmediaByMedia_idLikes
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getmediaByMedia_idLikes
        }
        val postmediaByMedia_idLikes = postmediaByMedia_idLikesAction { (media_id: BigInt) =>  
            // ----- Start of unmanaged code area for action  InstagramApiYaml.postmediaByMedia_idLikes
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.postmediaByMedia_idLikes
        }
        val deletemediaByMedia_idLikes = deletemediaByMedia_idLikesAction { (media_id: BigInt) =>  
            // ----- Start of unmanaged code area for action  InstagramApiYaml.deletemediaByMedia_idLikes
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.deletemediaByMedia_idLikes
        }
        val getusersByUser_idFollows = getusersByUser_idFollowsAction { (user_id: BigDecimal) =>  
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getusersByUser_idFollows
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getusersByUser_idFollows
        }
        val getlocationsByLocation_id = getlocationsByLocation_idAction { (location_id: BigInt) =>  
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getlocationsByLocation_id
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getlocationsByLocation_id
        }
        val getusersSearch = getusersSearchAction { input: (String, Option[String]) =>
            val (q, count) = input
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getusersSearch
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getusersSearch
        }
        val getusersSelfMediaLiked = getusersSelfMediaLikedAction { input: (Option[BigInt], Option[BigInt]) =>
            val (count, max_like_id) = input
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getusersSelfMediaLiked
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getusersSelfMediaLiked
        }
        val gettagsByTag_name = gettagsByTag_nameAction { (tag_name: String) =>  
            // ----- Start of unmanaged code area for action  InstagramApiYaml.gettagsByTag_name
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.gettagsByTag_name
        }
        val gettagsSearch = gettagsSearchAction { (q: Option[String]) =>  
            // ----- Start of unmanaged code area for action  InstagramApiYaml.gettagsSearch
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.gettagsSearch
        }
        val getusersByUser_idFollowed_by = getusersByUser_idFollowed_byAction { (user_id: BigDecimal) =>  
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getusersByUser_idFollowed_by
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getusersByUser_idFollowed_by
        }
        val getmediaByMedia_idComments = getmediaByMedia_idCommentsAction { (media_id: BigInt) =>  
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getmediaByMedia_idComments
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getmediaByMedia_idComments
        }
        val postmediaByMedia_idComments = postmediaByMedia_idCommentsAction { input: (BigInt, Option[BigDecimal]) =>
            val (media_id, tEXT) = input
            // ----- Start of unmanaged code area for action  InstagramApiYaml.postmediaByMedia_idComments
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.postmediaByMedia_idComments
        }
        val deletemediaByMedia_idComments = deletemediaByMedia_idCommentsAction { (media_id: BigInt) =>  
            // ----- Start of unmanaged code area for action  InstagramApiYaml.deletemediaByMedia_idComments
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.deletemediaByMedia_idComments
        }
        val gettagsByTag_nameMediaRecent = gettagsByTag_nameMediaRecentAction { (tag_name: String) =>  
            // ----- Start of unmanaged code area for action  InstagramApiYaml.gettagsByTag_nameMediaRecent
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.gettagsByTag_nameMediaRecent
        }
        val postusersByUser_idRelationship = postusersByUser_idRelationshipAction { input: (BigDecimal, Option[UsersUser_idRelationshipPostActionOptionEnum]) =>
            val (user_id, action) = input
            // ----- Start of unmanaged code area for action  InstagramApiYaml.postusersByUser_idRelationship
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.postusersByUser_idRelationship
        }
        val getusersSelfFeed = getusersSelfFeedAction { input: (Option[BigInt], Option[BigInt], Option[BigInt]) =>
            val (count, max_id, min_id) = input
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getusersSelfFeed
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getusersSelfFeed
        }
        val getusersByUser_id = getusersByUser_idAction { (user_id: BigDecimal) =>  
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getusersByUser_id
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getusersByUser_id
        }
        val getmediaSearch = getmediaSearchAction { input: (Option[BigInt], BigInt, Option[BigDecimal], Option[BigInt], Option[BigDecimal]) =>
            val (mAX_TIMESTAMP, dISTANCE, lNG, mIN_TIMESTAMP, lAT) = input
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getmediaSearch
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getmediaSearch
        }
        val getgeographiesByGeo_idMediaRecent = getgeographiesByGeo_idMediaRecentAction { input: (BigInt, Option[BigInt], Option[BigInt]) =>
            val (geo_id, count, min_id) = input
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getgeographiesByGeo_idMediaRecent
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getgeographiesByGeo_idMediaRecent
        }
        val getmediaByShortcode = getmediaByShortcodeAction { (shortcode: String) =>  
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getmediaByShortcode
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getmediaByShortcode
        }
        val getlocationsSearch = getlocationsSearchAction { input: (Option[BigInt], Option[BigInt], Option[BigInt], Option[BigDecimal], Option[BigInt], Option[BigDecimal]) =>
            val (foursquare_v2_id, facebook_places_id, distance, lat, foursquare_id, lng) = input
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getlocationsSearch
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getlocationsSearch
        }
        val getusersSelfRequested_by = getusersSelfRequested_byAction {  _ =>  
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getusersSelfRequested_by
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getusersSelfRequested_by
        }
        val getmediaByMedia_id = getmediaByMedia_idAction { (media_id: BigInt) =>  
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getmediaByMedia_id
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getmediaByMedia_id
        }
        val getlocationsByLocation_idMediaRecent = getlocationsByLocation_idMediaRecentAction { input: (BigInt, Option[BigInt], Option[BigInt], Option[String], Option[String]) =>
            val (location_id, max_timestamp, min_timestamp, min_id, max_id) = input
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getlocationsByLocation_idMediaRecent
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getlocationsByLocation_idMediaRecent
        }
        val getusersByUser_idMediaRecent = getusersByUser_idMediaRecentAction { input: (BigDecimal, Option[BigInt], Option[String], Option[BigInt], Option[String], Option[BigInt]) =>
            val (user_id, max_timestamp, min_id, min_timestamp, max_id, count) = input
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getusersByUser_idMediaRecent
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getusersByUser_idMediaRecent
        }
        val getmediaPopular = getmediaPopularAction {  _ =>  
            // ----- Start of unmanaged code area for action  InstagramApiYaml.getmediaPopular
            NotImplementedYet
            // ----- End of unmanaged code area for action  InstagramApiYaml.getmediaPopular
        }
    
    }
}
