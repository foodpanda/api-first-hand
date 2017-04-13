package de.zalando.model
import de.zalando.apifirst.Application._
import de.zalando.apifirst.Domain._
import de.zalando.apifirst.ParameterPlace
import de.zalando.apifirst.naming._
import de.zalando.apifirst.Hypermedia._
import de.zalando.apifirst.Http._
import de.zalando.apifirst.Security
import java.net.URL
import Security._ 
//noinspection ScalaStyle
object instagram_api_yaml extends WithModel {
 
 def types = Map[Reference, Type](
	Reference("⌿definitions⌿User") → 
		TypeDef(Reference("⌿definitions⌿User"), 
			Seq(
					Field(Reference("⌿definitions⌿User⌿website"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿User⌿profile_picture"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿User⌿username"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿User⌿full_name"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿User⌿bio"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿User⌿id"), Opt(BInt(TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿User⌿counts"), Opt(TypeRef(Reference("⌿definitions⌿User⌿counts⌿Option⌿counts")), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 7"), List())),
	Reference("⌿definitions⌿Image") → 
		TypeDef(Reference("⌿definitions⌿Image"), 
			Seq(
					Field(Reference("⌿definitions⌿Image⌿width"), Opt(BInt(TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Image⌿height"), Opt(BInt(TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Image⌿url"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 3"), List())),
	Reference("⌿definitions⌿Tag") → 
		TypeDef(Reference("⌿definitions⌿Tag"), 
			Seq(
					Field(Reference("⌿definitions⌿Tag⌿media_count"), Opt(BInt(TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Tag⌿name"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 2"), List())),
	Reference("⌿definitions⌿Comment") → 
		TypeDef(Reference("⌿definitions⌿Comment"), 
			Seq(
					Field(Reference("⌿definitions⌿Comment⌿id"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Comment⌿created_time"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Comment⌿text"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Comment⌿from"), Opt(TypeRef(Reference("⌿definitions⌿MiniProfile")), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 4"), List())),
	Reference("⌿definitions⌿Media") → 
		TypeDef(Reference("⌿definitions⌿Media"), 
			Seq(
					Field(Reference("⌿definitions⌿Media⌿created_time"), Opt(BInt(TypeMeta(Some("Epoc time (ms)"), List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Media⌿filter"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Media⌿id"), Opt(BInt(TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Media⌿type"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Media⌿location"), Opt(TypeRef(Reference("⌿definitions⌿Location")), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Media⌿comments:"), Opt(TypeRef(Reference("⌿definitions⌿Media⌿comments:⌿Option⌿comments:")), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Media⌿tags"), Opt(ArrResult(TypeRef(Reference("⌿definitions⌿Tag")), TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Media⌿users_in_photo"), Opt(ArrResult(TypeRef(Reference("⌿definitions⌿MiniProfile")), TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Media⌿likes"), Opt(TypeRef(Reference("⌿definitions⌿Media⌿likes⌿Option⌿likes")), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Media⌿videos"), Opt(TypeRef(Reference("⌿definitions⌿Media⌿videos⌿Option⌿videos")), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Media⌿images"), Opt(TypeRef(Reference("⌿definitions⌿Media⌿images⌿Option⌿images")), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Media⌿user"), Opt(TypeRef(Reference("⌿definitions⌿MiniProfile")), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 12"), List())),
	Reference("⌿definitions⌿Like") → 
		TypeDef(Reference("⌿definitions⌿Like"), 
			Seq(
					Field(Reference("⌿definitions⌿Like⌿first_name"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Like⌿id"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Like⌿last_name"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Like⌿type"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Like⌿user_name"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 5"), List())),
	Reference("⌿definitions⌿Location") → 
		TypeDef(Reference("⌿definitions⌿Location"), 
			Seq(
					Field(Reference("⌿definitions⌿Location⌿id"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Location⌿name"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Location⌿latitude"), Opt(BDcml(TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Location⌿longitude"), Opt(BDcml(TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 4"), List())),
	Reference("⌿definitions⌿MiniProfile") → 
		TypeDef(Reference("⌿definitions⌿MiniProfile"), 
			Seq(
					Field(Reference("⌿definitions⌿MiniProfile⌿user_name"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿MiniProfile⌿full_name"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿MiniProfile⌿id"), Opt(BInt(TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿MiniProfile⌿profile_picture"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 4"), List())),
	Reference("⌿parameters⌿user-id-param⌿user-id") → 
		BDcml(TypeMeta(None, List())),
	Reference("⌿parameters⌿tag-name⌿tag-name") → 
		Str(None, TypeMeta(None, List())),
	Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count") → 
		Opt(BInt(TypeMeta(None, List())), TypeMeta(None, List())),
	Reference("⌿paths⌿/locations/{location-id}⌿⌿location-id") → 
		BInt(TypeMeta(None, List())),
	Reference("⌿paths⌿/locations/search⌿get⌿lng") → 
		Opt(BDcml(TypeMeta(None, List())), TypeMeta(None, List())),
	Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿max_id") → 
		Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List())),
	Reference("⌿paths⌿/users/{user-id}/relationship⌿post⌿action") → 
		Opt(TypeRef(Reference("⌿paths⌿/users/{user-id}/relationship⌿post⌿action⌿Option⌿Enum")), TypeMeta(None, List())),
	Reference("⌿paths⌿/media/search⌿get⌿DISTANCE") → 
		BInt(TypeMeta(None, List("""max(BigInt("5000"), false)"""))),
	Reference("⌿definitions⌿User⌿counts⌿Option⌿counts") → 
		TypeDef(Reference("⌿definitions⌿User⌿counts"), 
			Seq(
					Field(Reference("⌿definitions⌿User⌿counts⌿media"), Opt(BInt(TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿User⌿counts⌿follows"), Opt(BInt(TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿User⌿counts⌿follwed_by"), Opt(BInt(TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 3"), List())),
	Reference("⌿paths⌿/users/self/feed⌿get⌿responses⌿200") → 
		TypeDef(Reference("⌿paths⌿/users/self/feed⌿get⌿responses⌿200"), 
			Seq(
					Field(Reference("⌿paths⌿/users/self/feed⌿get⌿responses⌿200⌿data"), Opt(ArrResult(TypeRef(Reference("⌿definitions⌿Media")), TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 1"), List())),
	Reference("⌿paths⌿/media/{media-id}/comments⌿delete⌿responses⌿200") → 
		TypeDef(Reference("⌿paths⌿/media/{media-id}/comments⌿delete⌿responses⌿200"), 
			Seq(
					Field(Reference("⌿paths⌿/media/{media-id}/comments⌿delete⌿responses⌿200⌿data"), Opt(Str(None, TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿paths⌿/media/{media-id}/comments⌿delete⌿responses⌿200⌿meta"), Opt(TypeRef(Reference("⌿paths⌿/media/{media-id}/comments⌿delete⌿responses⌿200⌿meta⌿Option⌿meta")), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 2"), List())),
	Reference("⌿paths⌿/users/{user-id}/follows⌿get⌿responses⌿200") → 
		TypeDef(Reference("⌿paths⌿/users/{user-id}/follows⌿get⌿responses⌿200"), 
			Seq(
					Field(Reference("⌿paths⌿/users/{user-id}/follows⌿get⌿responses⌿200⌿data"), Opt(ArrResult(TypeRef(Reference("⌿definitions⌿MiniProfile")), TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 1"), List())),
	Reference("⌿paths⌿/tags/{tag-name}/media/recent⌿get⌿responses⌿200") → 
		TypeDef(Reference("⌿paths⌿/tags/{tag-name}/media/recent⌿get⌿responses⌿200"), 
			Seq(
					Field(Reference("⌿paths⌿/tags/{tag-name}/media/recent⌿get⌿responses⌿200⌿data"), Opt(ArrResult(TypeRef(Reference("⌿definitions⌿Tag")), TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 1"), List())),
	Reference("⌿paths⌿/users/self/requested-by⌿get⌿responses⌿200") → 
		TypeDef(Reference("⌿paths⌿/users/self/requested-by⌿get⌿responses⌿200"), 
			Seq(
					Field(Reference("⌿paths⌿/users/self/requested-by⌿get⌿responses⌿200⌿meta"), Opt(TypeRef(Reference("⌿paths⌿/tags/search⌿get⌿responses⌿200⌿meta⌿Option⌿meta")), TypeMeta(None, List()))),
					Field(Reference("⌿paths⌿/users/self/requested-by⌿get⌿responses⌿200⌿data"), Opt(ArrResult(TypeRef(Reference("⌿definitions⌿MiniProfile")), TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 2"), List())),
	Reference("⌿paths⌿/locations/{location-id}⌿get⌿responses⌿200") → 
		TypeDef(Reference("⌿paths⌿/locations/{location-id}⌿get⌿responses⌿200"), 
			Seq(
					Field(Reference("⌿paths⌿/locations/{location-id}⌿get⌿responses⌿200⌿data"), Opt(TypeRef(Reference("⌿definitions⌿Location")), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 1"), List())),
	Reference("⌿paths⌿/media/{media-id}/likes⌿get⌿responses⌿200") → 
		TypeDef(Reference("⌿paths⌿/media/{media-id}/likes⌿get⌿responses⌿200"), 
			Seq(
					Field(Reference("⌿paths⌿/media/{media-id}/likes⌿get⌿responses⌿200⌿meta"), Opt(TypeRef(Reference("⌿paths⌿/media/{media-id}/comments⌿delete⌿responses⌿200⌿meta⌿Option⌿meta")), TypeMeta(None, List()))),
					Field(Reference("⌿paths⌿/media/{media-id}/likes⌿get⌿responses⌿200⌿data"), Opt(ArrResult(TypeRef(Reference("⌿definitions⌿Like")), TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 2"), List())),
	Reference("⌿paths⌿/media/search⌿get⌿responses⌿200") → 
		TypeDef(Reference("⌿paths⌿/media/search⌿get⌿responses⌿200"), 
			Seq(
					Field(Reference("⌿paths⌿/media/search⌿get⌿responses⌿200⌿data"), Opt(ArrResult(TypeRef(Reference("⌿paths⌿/media/search⌿get⌿responses⌿200⌿data⌿Option⌿Seq⌿data")), TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 1"), List())),
	Reference("⌿paths⌿/tags/search⌿get⌿responses⌿200") → 
		TypeDef(Reference("⌿paths⌿/tags/search⌿get⌿responses⌿200"), 
			Seq(
					Field(Reference("⌿paths⌿/tags/search⌿get⌿responses⌿200⌿meta"), Opt(TypeRef(Reference("⌿paths⌿/tags/search⌿get⌿responses⌿200⌿meta⌿Option⌿meta")), TypeMeta(None, List()))),
					Field(Reference("⌿paths⌿/tags/search⌿get⌿responses⌿200⌿data"), Opt(ArrResult(TypeRef(Reference("⌿definitions⌿Tag")), TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 2"), List())),
	Reference("⌿paths⌿/users/{user-id}⌿get⌿responses⌿200") → 
		TypeDef(Reference("⌿paths⌿/users/{user-id}⌿get⌿responses⌿200"), 
			Seq(
					Field(Reference("⌿paths⌿/users/{user-id}⌿get⌿responses⌿200⌿data"), Opt(TypeRef(Reference("⌿definitions⌿User")), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 1"), List())),
	Reference("⌿paths⌿/media/{media-id}/comments⌿get⌿responses⌿200") → 
		TypeDef(Reference("⌿paths⌿/media/{media-id}/comments⌿get⌿responses⌿200"), 
			Seq(
					Field(Reference("⌿paths⌿/media/{media-id}/comments⌿get⌿responses⌿200⌿meta"), Opt(TypeRef(Reference("⌿paths⌿/media/{media-id}/comments⌿delete⌿responses⌿200⌿meta⌿Option⌿meta")), TypeMeta(None, List()))),
					Field(Reference("⌿paths⌿/media/{media-id}/comments⌿get⌿responses⌿200⌿data"), Opt(ArrResult(TypeRef(Reference("⌿definitions⌿Comment")), TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 2"), List())),
	Reference("⌿definitions⌿Media⌿likes⌿Option⌿likes") → 
		TypeDef(Reference("⌿definitions⌿Media⌿likes"), 
			Seq(
					Field(Reference("⌿definitions⌿Media⌿likes⌿count"), Opt(BInt(TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Media⌿likes⌿data"), Opt(ArrResult(TypeRef(Reference("⌿definitions⌿MiniProfile")), TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 2"), List())),
	Reference("⌿definitions⌿Media⌿comments:⌿Option⌿comments:") → 
		TypeDef(Reference("⌿definitions⌿Media⌿comments:"), 
			Seq(
					Field(Reference("⌿definitions⌿Media⌿comments:⌿count"), Opt(BInt(TypeMeta(None, List())), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Media⌿comments:⌿data"), Opt(ArrResult(TypeRef(Reference("⌿definitions⌿Comment")), TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 2"), List())),
	Reference("⌿paths⌿/geographies/{geo-id}/media/recent⌿get⌿responses⌿200") → 
		Null(TypeMeta(None, List())),
	Reference("⌿definitions⌿Media⌿videos⌿Option⌿videos") → 
		TypeDef(Reference("⌿definitions⌿Media⌿videos"), 
			Seq(
					Field(Reference("⌿definitions⌿Media⌿videos⌿low_resolution"), Opt(TypeRef(Reference("⌿definitions⌿Image")), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Media⌿videos⌿standard_resolution"), Opt(TypeRef(Reference("⌿definitions⌿Image")), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 2"), List())),
	Reference("⌿definitions⌿Media⌿images⌿Option⌿images") → 
		TypeDef(Reference("⌿definitions⌿Media⌿images"), 
			Seq(
					Field(Reference("⌿definitions⌿Media⌿images⌿low_resolution"), Opt(TypeRef(Reference("⌿definitions⌿Image")), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Media⌿images⌿thumbnail"), Opt(TypeRef(Reference("⌿definitions⌿Image")), TypeMeta(None, List()))),
					Field(Reference("⌿definitions⌿Media⌿images⌿standard_resolution"), Opt(TypeRef(Reference("⌿definitions⌿Image")), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 3"), List())),
	Reference("⌿paths⌿/locations/search⌿get⌿responses⌿200") → 
		TypeDef(Reference("⌿paths⌿/locations/search⌿get⌿responses⌿200"), 
			Seq(
					Field(Reference("⌿paths⌿/locations/search⌿get⌿responses⌿200⌿data"), Opt(ArrResult(TypeRef(Reference("⌿definitions⌿Location")), TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 1"), List())),
	Reference("⌿paths⌿/users/{user-id}/relationship⌿post⌿action⌿Option⌿Enum") → 
					EnumTrait(Str(None, TypeMeta(None, List("""enum("approve,unblock,block,unfollow,follow")"""))), TypeMeta(None, List("""enum("approve,unblock,block,unfollow,follow")""")), 
				Set(
					EnumObject(Str(None, TypeMeta(None, List("""enum("approve,unblock,block,unfollow,follow")"""))), "follow", TypeMeta(Some("follow"), List())),
					EnumObject(Str(None, TypeMeta(None, List("""enum("approve,unblock,block,unfollow,follow")"""))), "unblock", TypeMeta(Some("unblock"), List())),
					EnumObject(Str(None, TypeMeta(None, List("""enum("approve,unblock,block,unfollow,follow")"""))), "approve", TypeMeta(Some("approve"), List())),
					EnumObject(Str(None, TypeMeta(None, List("""enum("approve,unblock,block,unfollow,follow")"""))), "unfollow", TypeMeta(Some("unfollow"), List())),
					EnumObject(Str(None, TypeMeta(None, List("""enum("approve,unblock,block,unfollow,follow")"""))), "block", TypeMeta(Some("block"), List()))

				)),
	Reference("⌿paths⌿/users/{user-id}/relationship⌿post⌿action⌿Option⌿Enum⌿unblock") → 
					EnumObject(Str(None, TypeMeta(None, List("""enum("approve,unblock,block,unfollow,follow")"""))), "unblock", TypeMeta(Some("unblock"), List())),
	Reference("⌿paths⌿/users/{user-id}/relationship⌿post⌿action⌿Option⌿Enum⌿approve") → 
					EnumObject(Str(None, TypeMeta(None, List("""enum("approve,unblock,block,unfollow,follow")"""))), "approve", TypeMeta(Some("approve"), List())),
	Reference("⌿paths⌿/users/{user-id}/relationship⌿post⌿action⌿Option⌿Enum⌿follow") → 
					EnumObject(Str(None, TypeMeta(None, List("""enum("approve,unblock,block,unfollow,follow")"""))), "follow", TypeMeta(Some("follow"), List())),
	Reference("⌿paths⌿/users/{user-id}/relationship⌿post⌿action⌿Option⌿Enum⌿block") → 
					EnumObject(Str(None, TypeMeta(None, List("""enum("approve,unblock,block,unfollow,follow")"""))), "block", TypeMeta(Some("block"), List())),
	Reference("⌿paths⌿/users/{user-id}/relationship⌿post⌿action⌿Option⌿Enum⌿unfollow") → 
					EnumObject(Str(None, TypeMeta(None, List("""enum("approve,unblock,block,unfollow,follow")"""))), "unfollow", TypeMeta(Some("unfollow"), List())),
	Reference("⌿paths⌿/tags/search⌿get⌿responses⌿200⌿meta⌿Option⌿meta") → 
		TypeDef(Reference("⌿paths⌿/tags/search⌿get⌿responses⌿200⌿meta"), 
			Seq(
					Field(Reference("⌿paths⌿/tags/search⌿get⌿responses⌿200⌿meta⌿code"), Opt(BInt(TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 1"), List())),
	Reference("⌿paths⌿/media/{media-id}/comments⌿delete⌿responses⌿200⌿meta⌿Option⌿meta") → 
		TypeDef(Reference("⌿paths⌿/media/{media-id}/comments⌿delete⌿responses⌿200⌿meta"), 
			Seq(
					Field(Reference("⌿paths⌿/media/{media-id}/comments⌿delete⌿responses⌿200⌿meta⌿code"), Opt(BDcml(TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 1"), List())),
	Reference("⌿paths⌿/media/search⌿get⌿responses⌿200⌿data⌿Option⌿Seq⌿data") → 
					AllOf(Reference("⌿paths⌿/media/search⌿get⌿responses⌿200⌿data⌿data"), TypeMeta(Some("Schemas: 2"), List()),  Seq(
			TypeRef(Reference("⌿definitions⌿Media")),
			TypeRef(Reference("⌿paths⌿/media/search⌿get⌿responses⌿200⌿data⌿Option⌿Seq⌿data⌿AllOf1"))) , None),
	Reference("⌿paths⌿/media/search⌿get⌿responses⌿200⌿data⌿Option⌿Seq⌿data⌿AllOf1") → 
		TypeDef(Reference("⌿paths⌿/media/search⌿get⌿responses⌿200⌿data"), 
			Seq(
					Field(Reference("⌿paths⌿/media/search⌿get⌿responses⌿200⌿data⌿distance"), Opt(BDcml(TypeMeta(None, List())), TypeMeta(None, List())))
			), TypeMeta(Some("Named types: 1"), List()))
) 
 
 def parameters = Map[ParameterRef, Parameter](
	ParameterRef(	Reference("⌿paths⌿/locations/{location-id}/media/recent⌿get⌿min_timestamp")) → Parameter("min_timestamp", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/media/{media-id}/likes⌿delete⌿media-id")) → Parameter("media-id", BInt(TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/locations/{location-id}⌿get⌿location-id")) → Parameter("location-id", BInt(TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/media/search⌿get⌿MAX_TIMESTAMP")) → Parameter("MAX_TIMESTAMP", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/media/{media-id}/likes⌿post⌿media-id")) → Parameter("media-id", BInt(TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/users/{user-id}/relationship⌿post⌿action")) → Parameter("action", TypeRef(Reference("⌿paths⌿/users/{user-id}/relationship⌿post⌿action")), None, None, ".+", encode = false, ParameterPlace.withName("body")),
	ParameterRef(	Reference("⌿paths⌿/users/{user-id}⌿get⌿user-id")) → Parameter("user-id", BDcml(TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/users/{user-id}/followed-by⌿get⌿user-id")) → Parameter("user-id", BDcml(TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/users/self/feed⌿get⌿count")) → Parameter("count", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/users/self/feed⌿get⌿min_id")) → Parameter("min_id", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/locations/{location-id}/media/recent⌿get⌿max_timestamp")) → Parameter("max_timestamp", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/locations/search⌿get⌿foursquare_v2_id")) → Parameter("foursquare_v2_id", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿max_timestamp")) → Parameter("max_timestamp", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿min_id")) → Parameter("min_id", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿max_id")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/tags/{tag-name}⌿get⌿tag-name")) → Parameter("tag-name", Str(None, TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/media/search⌿get⌿DISTANCE")) → Parameter("DISTANCE", BInt(TypeMeta(None, List("""max(BigInt("5000"), false)"""))), None, Some("1000"), ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/tags/{tag-name}/media/recent⌿get⌿tag-name")) → Parameter("tag-name", Str(None, TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿min_timestamp")) → Parameter("min_timestamp", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/media/{media-id}/comments⌿post⌿TEXT")) → Parameter("TEXT", TypeRef(Reference("⌿paths⌿/locations/search⌿get⌿lng")), None, None, ".+", encode = false, ParameterPlace.withName("body")),
	ParameterRef(	Reference("⌿paths⌿/users/{user-id}/follows⌿get⌿user-id")) → Parameter("user-id", BDcml(TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/locations/{location-id}/media/recent⌿get⌿location-id")) → Parameter("location-id", BInt(TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/users/self/feed⌿get⌿max_id")) → Parameter("max_id", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/users/self/media/liked⌿get⌿count")) → Parameter("count", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/media/search⌿get⌿LNG")) → Parameter("LNG", TypeRef(Reference("⌿paths⌿/locations/search⌿get⌿lng")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/geographies/{geo-id}/media/recent⌿get⌿min_id")) → Parameter("min_id", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/locations/search⌿get⌿facebook_places_id")) → Parameter("facebook_places_id", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/media/{media-id}/comments⌿post⌿media-id")) → Parameter("media-id", BInt(TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/media/{media-id}⌿get⌿media-id")) → Parameter("media-id", BInt(TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/users/self/media/liked⌿get⌿max_like_id")) → Parameter("max_like_id", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/media/search⌿get⌿MIN_TIMESTAMP")) → Parameter("MIN_TIMESTAMP", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/locations/search⌿get⌿distance")) → Parameter("distance", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/users/search⌿get⌿count")) → Parameter("count", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿max_id")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/locations/{location-id}/media/recent⌿get⌿max_id")) → Parameter("max_id", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿max_id")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/media/search⌿get⌿LAT")) → Parameter("LAT", TypeRef(Reference("⌿paths⌿/locations/search⌿get⌿lng")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/locations/search⌿get⌿lat")) → Parameter("lat", TypeRef(Reference("⌿paths⌿/locations/search⌿get⌿lng")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/locations/search⌿get⌿foursquare_id")) → Parameter("foursquare_id", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/locations/{location-id}/media/recent⌿get⌿min_id")) → Parameter("min_id", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿max_id")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/tags/search⌿get⌿q")) → Parameter("q", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿max_id")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿max_id")) → Parameter("max_id", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿max_id")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/media/{media-id}/likes⌿get⌿media-id")) → Parameter("media-id", BInt(TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/users/{user-id}/relationship⌿post⌿user-id")) → Parameter("user-id", BDcml(TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/media/{media-id}/comments⌿delete⌿media-id")) → Parameter("media-id", BInt(TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/media/{media-id}/comments⌿get⌿media-id")) → Parameter("media-id", BInt(TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/users/search⌿get⌿q")) → Parameter("q", Str(None, TypeMeta(None, List())), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/media/{shortcode}⌿get⌿shortcode")) → Parameter("shortcode", Str(None, TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")) → Parameter("count", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/geographies/{geo-id}/media/recent⌿get⌿count")) → Parameter("count", TypeRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/locations/search⌿get⌿lng")) → Parameter("lng", TypeRef(Reference("⌿paths⌿/locations/search⌿get⌿lng")), None, None, ".+", encode = true, ParameterPlace.withName("query")),
	ParameterRef(	Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿user-id")) → Parameter("user-id", BDcml(TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path")),
	ParameterRef(	Reference("⌿paths⌿/geographies/{geo-id}/media/recent⌿get⌿geo-id")) → Parameter("geo-id", BInt(TypeMeta(None, List())), None, None, "[^/]+", encode = true, ParameterPlace.withName("path"))
) 
 def basePath: String = "/v1" 
 def discriminators: DiscriminatorLookupTable = Map[Reference, Reference](
	)
 def securityDefinitions: SecurityDefinitionsTable = Map[String, Security.Definition](
	"oauth" -> OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )),
	"key" -> ApiKey(None, "access_token", ParameterPlace.withName("query"))
)
def stateTransitions: StateTransitionsTable = Map[State, Map[State, TransitionProperties]]()
def calls: Seq[ApiCall] = Seq(
	ApiCall(GET, Path(Reference("⌿media⌿{media-id}⌿likes")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getmediaByMedia_idLikes",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/media/{media-id}/likes⌿get⌿media-id"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/media/{media-id}/likes⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(POST, Path(Reference("⌿media⌿{media-id}⌿likes")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"postmediaByMedia_idLikes",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/media/{media-id}/likes⌿post⌿media-id"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/media/{media-id}/comments⌿delete⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("comments"))
		)), 
	ApiCall(DELETE, Path(Reference("⌿media⌿{media-id}⌿likes")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"deletemediaByMedia_idLikes",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/media/{media-id}/likes⌿delete⌿media-id"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/media/{media-id}/comments⌿delete⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿users⌿{user-id}⌿follows")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getusersByUser_idFollows",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/users/{user-id}/follows⌿get⌿user-id"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/users/{user-id}/follows⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿locations⌿{location-id}")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getlocationsByLocation_id",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/locations/{location-id}⌿get⌿location-id"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/locations/{location-id}⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿users⌿search")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getusersSearch",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/users/search⌿get⌿q")),
				ParameterRef(Reference("⌿paths⌿/users/search⌿get⌿count"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/users/{user-id}/follows⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿users⌿self⌿media⌿liked")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getusersSelfMediaLiked",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/users/self/media/liked⌿get⌿count")),
				ParameterRef(Reference("⌿paths⌿/users/self/media/liked⌿get⌿max_like_id"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/users/self/feed⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿tags⌿{tag-name}")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"gettagsByTag_name",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/tags/{tag-name}⌿get⌿tag-name"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿definitions⌿Tag"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿tags⌿search")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"gettagsSearch",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/tags/search⌿get⌿q"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/tags/search⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿users⌿{user-id}⌿followed-by")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getusersByUser_idFollowed_by",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/users/{user-id}/followed-by⌿get⌿user-id"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/users/{user-id}/follows⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿media⌿{media-id}⌿comments")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getmediaByMedia_idComments",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/media/{media-id}/comments⌿get⌿media-id"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/media/{media-id}/comments⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(POST, Path(Reference("⌿media⌿{media-id}⌿comments")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"postmediaByMedia_idComments",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/media/{media-id}/comments⌿post⌿media-id")),
				ParameterRef(Reference("⌿paths⌿/media/{media-id}/comments⌿post⌿TEXT"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/media/{media-id}/comments⌿delete⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("comments"))
		)), 
	ApiCall(DELETE, Path(Reference("⌿media⌿{media-id}⌿comments")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"deletemediaByMedia_idComments",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/media/{media-id}/comments⌿delete⌿media-id"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/media/{media-id}/comments⌿delete⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿tags⌿{tag-name}⌿media⌿recent")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"gettagsByTag_nameMediaRecent",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/tags/{tag-name}/media/recent⌿get⌿tag-name"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/tags/{tag-name}/media/recent⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(POST, Path(Reference("⌿users⌿{user-id}⌿relationship")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"postusersByUser_idRelationship",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/users/{user-id}/relationship⌿post⌿user-id")),
				ParameterRef(Reference("⌿paths⌿/users/{user-id}/relationship⌿post⌿action"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/users/{user-id}/follows⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("relationships"))
		)), 
	ApiCall(GET, Path(Reference("⌿users⌿self⌿feed")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getusersSelfFeed",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/users/self/feed⌿get⌿count")),
				ParameterRef(Reference("⌿paths⌿/users/self/feed⌿get⌿max_id")),
				ParameterRef(Reference("⌿paths⌿/users/self/feed⌿get⌿min_id"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/users/self/feed⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿users⌿{user-id}")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getusersByUser_id",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/users/{user-id}⌿get⌿user-id"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/users/{user-id}⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query"))),
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic"))
		)), 
	ApiCall(GET, Path(Reference("⌿media⌿search")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getmediaSearch",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/media/search⌿get⌿MAX_TIMESTAMP")),
				ParameterRef(Reference("⌿paths⌿/media/search⌿get⌿DISTANCE")),
				ParameterRef(Reference("⌿paths⌿/media/search⌿get⌿LNG")),
				ParameterRef(Reference("⌿paths⌿/media/search⌿get⌿MIN_TIMESTAMP")),
				ParameterRef(Reference("⌿paths⌿/media/search⌿get⌿LAT"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/media/search⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿geographies⌿{geo-id}⌿media⌿recent")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getgeographiesByGeo_idMediaRecent",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/geographies/{geo-id}/media/recent⌿get⌿geo-id")),
				ParameterRef(Reference("⌿paths⌿/geographies/{geo-id}/media/recent⌿get⌿count")),
				ParameterRef(Reference("⌿paths⌿/geographies/{geo-id}/media/recent⌿get⌿min_id"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/geographies/{geo-id}/media/recent⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿media⌿{shortcode}")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getmediaByShortcode",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/media/{shortcode}⌿get⌿shortcode"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿definitions⌿Media"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿locations⌿search")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getlocationsSearch",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/locations/search⌿get⌿foursquare_v2_id")),
				ParameterRef(Reference("⌿paths⌿/locations/search⌿get⌿facebook_places_id")),
				ParameterRef(Reference("⌿paths⌿/locations/search⌿get⌿distance")),
				ParameterRef(Reference("⌿paths⌿/locations/search⌿get⌿lat")),
				ParameterRef(Reference("⌿paths⌿/locations/search⌿get⌿foursquare_id")),
				ParameterRef(Reference("⌿paths⌿/locations/search⌿get⌿lng"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/locations/search⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿users⌿self⌿requested-by")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getusersSelfRequested_by",parameters = 
			Seq(

				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/users/self/requested-by⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿media⌿{media-id}")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getmediaByMedia_id",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/media/{media-id}⌿get⌿media-id"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿definitions⌿Media"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿locations⌿{location-id}⌿media⌿recent")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getlocationsByLocation_idMediaRecent",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/locations/{location-id}/media/recent⌿get⌿location-id")),
				ParameterRef(Reference("⌿paths⌿/locations/{location-id}/media/recent⌿get⌿max_timestamp")),
				ParameterRef(Reference("⌿paths⌿/locations/{location-id}/media/recent⌿get⌿min_timestamp")),
				ParameterRef(Reference("⌿paths⌿/locations/{location-id}/media/recent⌿get⌿min_id")),
				ParameterRef(Reference("⌿paths⌿/locations/{location-id}/media/recent⌿get⌿max_id"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/users/self/feed⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿users⌿{user-id}⌿media⌿recent")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getusersByUser_idMediaRecent",parameters = 
			Seq(
				ParameterRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿user-id")),
				ParameterRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿max_timestamp")),
				ParameterRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿min_id")),
				ParameterRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿min_timestamp")),
				ParameterRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿max_id")),
				ParameterRef(Reference("⌿paths⌿/users/{user-id}/media/recent⌿get⌿count"))
				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/users/self/feed⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)), 
	ApiCall(GET, Path(Reference("⌿media⌿popular")),
		HandlerCall(
			"instagram.api.yaml",
			"InstagramApiYaml",
			instantiate = false,
			"getmediaPopular",parameters = 
			Seq(

				)
			),
		Set(MimeType("application/json")),
		Set(MimeType("application/json")),
		Map.empty[String, Seq[Class[Exception]]],
		TypesResponseInfo(
			Map[Int, ParameterRef](
			200 -> ParameterRef(Reference("⌿paths⌿/users/self/feed⌿get⌿responses⌿200"))
		), None),
		StateResponseInfo(
				Map[Int, State](
					200 -> Self
			), None),
		Set(
			OAuth2Constraint("oauth", OAuth2Definition(None, Some(new URL("https://instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=token")), Map[String, String]( "basic" -> "to read any and all data related to a user (e.g. following/followed-by  lists, photos, etc.) (granted by default) " ,  "comments" -> "to create or delete comments on a user’s behalf" ,  "relationships" -> "to follow and unfollow users on a user’s behalf" ,  "likes" -> "to like and unlike items on a user’s behalf" )), Set("basic", "comments", "relationships", "likes")),
			ApiKeyConstraint("key", ApiKey(None, "access_token", ParameterPlace.withName("query")))
		)))

def packageName: Option[String] = Some("instagram.api.yaml")

def model = new StrictModel(calls, types, parameters, discriminators, basePath, packageName, stateTransitions, securityDefinitions)
    
} 