package basic_polymorphism.yaml

import scala.language.existentials
import play.api.mvc._
import play.api.http._
import play.api.libs.json._
import de.zalando.play.controllers._
import Results.Status
import PlayBodyParsing._
import scala.concurrent.Future

import scala.util._






//noinspection ScalaStyle
trait Basic_polymorphismYamlBase extends Controller with PlayBodyParsing {
    import play.api.libs.concurrent.Execution.Implicits.defaultContext
    sealed trait PutType[T] extends ResultWrapper[T]
    
    def Put200(headers: Seq[(String, String)] = Nil) = success(new EmptyReturn(200, headers){})
    

    private type putActionRequestType       = (Option[Pet])
    private type putActionType[T]            = putActionRequestType => Future[PutType[T] forSome { type T }]

        
        import BodyReads._
        
        val putParser = parse.using { request =>
            request.contentType.map(_.toLowerCase(java.util.Locale.ENGLISH)) match {
                
                case other => play.api.mvc.BodyParsers.parse.error(Future.successful(UnsupportedMediaType(s"Invalid content type specified $other")))
            }
        }

    val putActionConstructor  = Action

def putAction[T] = (f: putActionType[T]) => putActionConstructor.async(putParser) { implicit request: Request[Option[Pet]] =>

        def processValidputRequest(dummy: Option[Pet]): Either[Result, Future[PutType[_]]] = {
          lazy val apiFirstTempResultHolder = Right(f((dummy)))
            
            new PutValidator(dummy).errors match {
                case e if e.isEmpty =>
                    apiFirstTempResultHolder
                case l =>
                    import ResponseWriters.jsonParsingErrorsWrites
                    Left(BadRequest(Json.toJson(l)))
            }
            
          
        }

            val dummy: Option[Pet] = request.body
            
            

            processValidputRequest(dummy) match {
                case Left(l) => success(l)
                case Right(r: Future[PutType[_] @unchecked]) =>
                    val providedTypes = Seq[String]()
                    val result = negotiateContent(request.acceptedTypes, providedTypes) map { putResponseMimeType =>
                        import MissingDefaultWrites._
                        r.map(_.toResult(putResponseMimeType).getOrElse(Results.NotAcceptable))
                    }
                    result getOrElse notAcceptable
            }
            
    }

    abstract class EmptyReturn(override val statusCode: Int, headers: Seq[(String, String)]) extends ResultWrapper[Result]  with PutType[Result] { val result = Results.Status(statusCode).withHeaders(headers:_*); val writer = (x: String) => Some(new Writeable((_:Any) => emptyByteString, None)); override def toResult(mimeType: String): Option[play.api.mvc.Result] = Some(result) }
    case object NotImplementedYetSync extends ResultWrapper[Results.EmptyContent]  with PutType[Results.EmptyContent] { val statusCode = 501; val result = Results.EmptyContent(); val writer = (x: String) => Some(new DefaultWriteables{}.writeableOf_EmptyContent); override def toResult(mimeType: String): Option[play.api.mvc.Result] = Some(Results.NotImplemented) }
    lazy val NotImplementedYet = Future.successful(NotImplementedYetSync)
}
