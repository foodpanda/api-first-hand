package string_formats_validation.yaml

import de.zalando.play.controllers._
import org.scalacheck._
import org.scalacheck.Arbitrary._
import org.scalacheck.Prop._
import org.scalacheck.Test._
import org.specs2.mutable._
import org.specs2.execute._
import play.api.test.Helpers._
import play.api.test._
import play.api.mvc.MultipartFormData.FilePart
import play.api.mvc._

import org.junit.runner.RunWith
import java.net.URLEncoder
import com.fasterxml.jackson.databind.ObjectMapper

import play.api.http.Writeable
import play.api.libs.Files.TemporaryFile
import play.api.test.Helpers.{status => requestStatusCode_}
import play.api.test.Helpers.{contentAsString => requestContentAsString_}
import play.api.test.Helpers.{contentType => requestContentType_}

import org.scalatest.{OptionValues, WordSpec}
import org.scalatestplus.play.{OneAppPerTest, WsScalaTestClient}

import Generators._

import java.time.ZonedDateTime
import java.time.LocalDate
import de.zalando.play.controllers.BinaryString
import BinaryString._
import de.zalando.play.controllers.Base64String
import Base64String._

//noinspection ScalaStyle
class String_formats_validation_yamlSpec extends WordSpec with OptionValues with WsScalaTestClient with OneAppPerTest  {
    def toPath[T](value: T)(implicit binder: PathBindable[T]): String = Option(binder.unbind("", value)).getOrElse("")
    def toQuery[T](key: String, value: T)(implicit binder: QueryStringBindable[T]): String = Option(binder.unbind(key, value)).getOrElse("")
    def toHeader[T](value: T)(implicit binder: QueryStringBindable[T]): String = Option(binder.unbind("", value)).getOrElse("")

  def checkResult(props: Prop): org.specs2.execute.Result =
    Test.check(Test.Parameters.default, props).status match {
      case Failed(args, labels) =>
        val failureMsg = labels.mkString("\n") + " given args: " + args.map(_.arg).mkString("'", "', '","'")
        org.specs2.execute.Failure(failureMsg)
      case Proved(_) | Exhausted | Passed => org.specs2.execute.Success()
      case PropException(_, e: IllegalStateException, _) => org.specs2.execute.Error(e.getMessage)
      case PropException(_, e, labels) =>
        val error = if (labels.isEmpty) e.getLocalizedMessage else labels.mkString("\n")
        org.specs2.execute.Failure(error)
    }

  private def parserConstructor(mimeType: String) = PlayBodyParsing.jacksonMapper(mimeType)

  def parseResponseContent[T](mapper: ObjectMapper, content: String, mimeType: Option[String], expectedType: Class[T]) =
    if (expectedType.getCanonicalName == "scala.runtime.Null$") null else mapper.readValue(content, expectedType)


    "POST /string" should {
        def testInvalidInput(input: (String, Option[String], LocalDate, Option[BinaryString], Option[LocalDate], Base64String, Option[Base64String], Option[String], ZonedDateTime, String, Option[ZonedDateTime])): Prop = {

            val (string_required, password_optional, date_required, binary_optional, date_optional, base64required, base64optional, string_optional, date_time_required, password_required, date_time_optional) = input

            val url = s"""/string?${toQuery("string_required", string_required)}&${toQuery("password_optional", password_optional)}&${toQuery("date_required", date_required)}&${toQuery("date_optional", date_optional)}&${toQuery("base64required", base64required)}&${toQuery("base64optional", base64optional)}&${toQuery("string_optional", string_optional)}&${toQuery("date_time_required", date_time_required)}&${toQuery("password_required", password_required)}&${toQuery("date_time_optional", date_time_optional)}"""
            val contentTypes: Seq[String] = Seq()
            val acceptHeaders: Seq[String] = Seq(
               "application/json", 
            
               "application/yaml"
            )
            val contentHeaders = for { ct <- contentTypes; ac <- acceptHeaders } yield (ct, ac)
            if (contentHeaders.isEmpty) throw new IllegalStateException(s"No 'produces' defined for the $url")

            val propertyList = contentHeaders.map { case (consumes, produces) =>
                val headers =
                    Seq() :+ ("Accept" -> produces) :+ ("Content-Type" -> consumes)

                    val parsed_binary_optional = PlayBodyParsing.jacksonMapper("application/json").writeValueAsString(binary_optional)

                val request = FakeRequest(POST, url).withHeaders(headers:_*).withBody(parsed_binary_optional)
                val path =
                    if (consumes == "multipart/form-data") {
                        import de.zalando.play.controllers.WriteableWrapper.anyContentAsMultipartFormWritable

                        val files: Seq[FilePart[TemporaryFile]] = Nil
                        val data = Map.empty[String, Seq[String]] 
                        val form = new MultipartFormData(data, files, Nil)

                        route(app, request.withMultipartFormDataBody(form)).get
                    } else if (consumes == "application/x-www-form-urlencoded") {
                        route(app, request.withFormUrlEncodedBody()).get
                    } else route(app, request).get

                val errors = new StringPostValidator(string_required, password_optional, date_required, binary_optional, date_optional, base64required, base64optional, string_optional, date_time_required, password_required, date_time_optional).errors

                lazy val validations = errors flatMap { _.messages } map { m =>
                    s"Contains error: $m in ${contentAsString(path)}" |:(contentAsString(path).contains(m) ?= true)
                }

                (s"given 'Content-Type' [$consumes], 'Accept' header [$produces] and URL: [$url]" + " and body [" + parsed_binary_optional + "]") |: all(
                    "StatusCode = BAD_REQUEST" |: (requestStatusCode_(path) ?= BAD_REQUEST),
                    s"Content-Type = $produces" |: ((consumes ?= "*/*") || (requestContentType_(path) ?= Some(produces))),
                    "non-empty errors" |: (errors.nonEmpty ?= true),
                    "at least one validation failing" |: atLeastOne(validations:_*)
                )
            }
            propertyList.reduce(_ && _)
        }
        def testValidInput(input: (String, Option[String], LocalDate, Option[BinaryString], Option[LocalDate], Base64String, Option[Base64String], Option[String], ZonedDateTime, String, Option[ZonedDateTime])): Prop = {
            val (string_required, password_optional, date_required, binary_optional, date_optional, base64required, base64optional, string_optional, date_time_required, password_required, date_time_optional) = input
            
            val parsed_binary_optional = parserConstructor("application/json").writeValueAsString(binary_optional)
            
            val url = s"""/string?${toQuery("string_required", string_required)}&${toQuery("password_optional", password_optional)}&${toQuery("date_required", date_required)}&${toQuery("date_optional", date_optional)}&${toQuery("base64required", base64required)}&${toQuery("base64optional", base64optional)}&${toQuery("string_optional", string_optional)}&${toQuery("date_time_required", date_time_required)}&${toQuery("password_required", password_required)}&${toQuery("date_time_optional", date_time_optional)}"""
            val consumesAll: Seq[String] = Seq()
            val producesAll: Seq[String] = Seq(
                "application/json", 
            
                "application/yaml"
            )
            val contentHeaders = for { cs <- consumesAll; ps <- producesAll } yield (cs, ps)
            if (contentHeaders.isEmpty) throw new IllegalStateException(s"No 'produces' defined for the $url")

            val propertyList = contentHeaders.map { case (consumes, produces) =>
                val headers =
                   Seq() :+ ("Accept" -> produces) :+ ("Content-Type" -> consumes)

                val request = FakeRequest(POST, url).withHeaders(headers:_*).withBody(parsed_binary_optional)
                val path =
                    if (consumes == "multipart/form-data") {
                        import de.zalando.play.controllers.WriteableWrapper.anyContentAsMultipartFormWritable

                        val files: Seq[FilePart[TemporaryFile]] = Nil
                        val data = Map.empty[String, Seq[String]] 
                        val form = new MultipartFormData(data, files, Nil)

                        route(app, request.withMultipartFormDataBody(form)).get
                    } else if (consumes == "application/x-www-form-urlencoded") {
                        route(app, request.withFormUrlEncodedBody()).get
                    } else route(app, request).get

                val errors = new StringPostValidator(string_required, password_optional, date_required, binary_optional, date_optional, base64required, base64optional, string_optional, date_time_required, password_required, date_time_optional).errors
                val possibleResponseTypes: Map[Int,Class[_ <: Any]] = Map(
                    200 -> classOf[Null]
                )

                val expectedCode = requestStatusCode_(path)
                val mimeType = requestContentType_(path)
                val mapper = parserConstructor(mimeType.getOrElse("*/*"))

                val parsedApiResponse = scala.util.Try {
                    parseResponseContent(mapper, requestContentAsString_(path), mimeType, possibleResponseTypes(expectedCode))
                }

                (s"Given response code [$expectedCode], 'Content-Type' [$consumes], 'Accept' header [$produces] and URL: [$url]" + " and body [" + parsed_binary_optional + "]") |: all(
                    "Response Code is allowed" |: (possibleResponseTypes.contains(expectedCode) ?= true),
                    "Successful" |: (parsedApiResponse.isSuccess ?= true),
                    s"Content-Type = $produces" |: ((parsedApiResponse.get ?= null) || (consumes ?= "*/*") || (requestContentType_(path) ?= Some(produces))),
                    "No errors" |: (errors.isEmpty ?= true)
                )
            }
            propertyList.reduce(_ && _)
        }
        "discard invalid data" in {
            val genInputs = for {
                        string_required <- StringGenerator
                        password_optional <- OptionStringGenerator
                        date_required <- LocalDateGenerator
                        binary_optional <- OptionBinaryStringGenerator
                        date_optional <- OptionLocalDateGenerator
                        base64required <- Base64StringGenerator
                        base64optional <- OptionBase64StringGenerator
                        string_optional <- OptionStringGenerator
                        date_time_required <- ZonedDateTimeGenerator
                        password_required <- StringGenerator
                        date_time_optional <- OptionZonedDateTimeGenerator
                    
                } yield (string_required, password_optional, date_required, binary_optional, date_optional, base64required, base64optional, string_optional, date_time_required, password_required, date_time_optional)
            val inputs = genInputs suchThat { case (string_required, password_optional, date_required, binary_optional, date_optional, base64required, base64optional, string_optional, date_time_required, password_required, date_time_optional) =>
                new StringPostValidator(string_required, password_optional, date_required, binary_optional, date_optional, base64required, base64optional, string_optional, date_time_required, password_required, date_time_optional).errors.nonEmpty
            }
            val props = forAll(inputs) { i => testInvalidInput(i) }
            assert(checkResult(props) == Success())
        }
        "do something with valid data" in {
            val genInputs = for {
                    string_required <- StringGenerator
                    password_optional <- OptionStringGenerator
                    date_required <- LocalDateGenerator
                    binary_optional <- OptionBinaryStringGenerator
                    date_optional <- OptionLocalDateGenerator
                    base64required <- Base64StringGenerator
                    base64optional <- OptionBase64StringGenerator
                    string_optional <- OptionStringGenerator
                    date_time_required <- ZonedDateTimeGenerator
                    password_required <- StringGenerator
                    date_time_optional <- OptionZonedDateTimeGenerator
                
            } yield (string_required, password_optional, date_required, binary_optional, date_optional, base64required, base64optional, string_optional, date_time_required, password_required, date_time_optional)
            val inputs = genInputs suchThat { case (string_required, password_optional, date_required, binary_optional, date_optional, base64required, base64optional, string_optional, date_time_required, password_required, date_time_optional) =>
                new StringPostValidator(string_required, password_optional, date_required, binary_optional, date_optional, base64required, base64optional, string_optional, date_time_required, password_required, date_time_optional).errors.isEmpty
            }
            val props = forAll(inputs) { i => testValidInput(i) }
            assert(checkResult(props) == Success())
        }

    }

    "POST /string2" should {
        def testInvalidInput(binary_required: BinaryString): Prop = {


            val url = s"""/string2"""
            val contentTypes: Seq[String] = Seq()
            val acceptHeaders: Seq[String] = Seq(
               "application/json", 
            
               "application/yaml"
            )
            val contentHeaders = for { ct <- contentTypes; ac <- acceptHeaders } yield (ct, ac)
            if (contentHeaders.isEmpty) throw new IllegalStateException(s"No 'produces' defined for the $url")

            val propertyList = contentHeaders.map { case (consumes, produces) =>
                val headers =
                    Seq() :+ ("Accept" -> produces) :+ ("Content-Type" -> consumes)

                    val parsed_binary_required = PlayBodyParsing.jacksonMapper("application/json").writeValueAsString(binary_required)

                val request = FakeRequest(POST, url).withHeaders(headers:_*).withBody(parsed_binary_required)
                val path =
                    if (consumes == "multipart/form-data") {
                        import de.zalando.play.controllers.WriteableWrapper.anyContentAsMultipartFormWritable

                        val files: Seq[FilePart[TemporaryFile]] = Nil
                        val data = Map.empty[String, Seq[String]] 
                        val form = new MultipartFormData(data, files, Nil)

                        route(app, request.withMultipartFormDataBody(form)).get
                    } else if (consumes == "application/x-www-form-urlencoded") {
                        route(app, request.withFormUrlEncodedBody()).get
                    } else route(app, request).get

                val errors = new String2PostValidator(binary_required).errors

                lazy val validations = errors flatMap { _.messages } map { m =>
                    s"Contains error: $m in ${contentAsString(path)}" |:(contentAsString(path).contains(m) ?= true)
                }

                (s"given 'Content-Type' [$consumes], 'Accept' header [$produces] and URL: [$url]" + " and body [" + parsed_binary_required + "]") |: all(
                    "StatusCode = BAD_REQUEST" |: (requestStatusCode_(path) ?= BAD_REQUEST),
                    s"Content-Type = $produces" |: ((consumes ?= "*/*") || (requestContentType_(path) ?= Some(produces))),
                    "non-empty errors" |: (errors.nonEmpty ?= true),
                    "at least one validation failing" |: atLeastOne(validations:_*)
                )
            }
            propertyList.reduce(_ && _)
        }
        def testValidInput(binary_required: BinaryString): Prop = {
            
            val parsed_binary_required = parserConstructor("application/json").writeValueAsString(binary_required)
            
            val url = s"""/string2"""
            val consumesAll: Seq[String] = Seq()
            val producesAll: Seq[String] = Seq(
                "application/json", 
            
                "application/yaml"
            )
            val contentHeaders = for { cs <- consumesAll; ps <- producesAll } yield (cs, ps)
            if (contentHeaders.isEmpty) throw new IllegalStateException(s"No 'produces' defined for the $url")

            val propertyList = contentHeaders.map { case (consumes, produces) =>
                val headers =
                   Seq() :+ ("Accept" -> produces) :+ ("Content-Type" -> consumes)

                val request = FakeRequest(POST, url).withHeaders(headers:_*).withBody(parsed_binary_required)
                val path =
                    if (consumes == "multipart/form-data") {
                        import de.zalando.play.controllers.WriteableWrapper.anyContentAsMultipartFormWritable

                        val files: Seq[FilePart[TemporaryFile]] = Nil
                        val data = Map.empty[String, Seq[String]] 
                        val form = new MultipartFormData(data, files, Nil)

                        route(app, request.withMultipartFormDataBody(form)).get
                    } else if (consumes == "application/x-www-form-urlencoded") {
                        route(app, request.withFormUrlEncodedBody()).get
                    } else route(app, request).get

                val errors = new String2PostValidator(binary_required).errors
                val possibleResponseTypes: Map[Int,Class[_ <: Any]] = Map(
                    200 -> classOf[Null]
                )

                val expectedCode = requestStatusCode_(path)
                val mimeType = requestContentType_(path)
                val mapper = parserConstructor(mimeType.getOrElse("*/*"))

                val parsedApiResponse = scala.util.Try {
                    parseResponseContent(mapper, requestContentAsString_(path), mimeType, possibleResponseTypes(expectedCode))
                }

                (s"Given response code [$expectedCode], 'Content-Type' [$consumes], 'Accept' header [$produces] and URL: [$url]" + " and body [" + parsed_binary_required + "]") |: all(
                    "Response Code is allowed" |: (possibleResponseTypes.contains(expectedCode) ?= true),
                    "Successful" |: (parsedApiResponse.isSuccess ?= true),
                    s"Content-Type = $produces" |: ((parsedApiResponse.get ?= null) || (consumes ?= "*/*") || (requestContentType_(path) ?= Some(produces))),
                    "No errors" |: (errors.isEmpty ?= true)
                )
            }
            propertyList.reduce(_ && _)
        }
        "discard invalid data" in {
            val genInputs = for {
                    binary_required <- BinaryStringGenerator
                } yield binary_required
            val inputs = genInputs suchThat { binary_required =>
                new String2PostValidator(binary_required).errors.nonEmpty
            }
            val props = forAll(inputs) { i => testInvalidInput(i) }
            assert(checkResult(props) == Success())
        }
        "do something with valid data" in {
            val genInputs = for {
                binary_required <- BinaryStringGenerator
            } yield binary_required
            val inputs = genInputs suchThat { binary_required =>
                new String2PostValidator(binary_required).errors.isEmpty
            }
            val props = forAll(inputs) { i => testValidInput(i) }
            assert(checkResult(props) == Success())
        }

    }
}
