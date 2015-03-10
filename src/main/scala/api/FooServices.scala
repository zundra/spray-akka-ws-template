package api

import akka.actor.ActorRef
import scala.concurrent.ExecutionContext
import spray.routing.Directives
import spray.can.Http
import spray.json._
import spray.http._

// Custom imports
import core.FooJsonProtocol._
import core.Foo

class FooService(messenger: ActorRef)(implicit executionContext: ExecutionContext)
  extends Directives with DefaultJsonFormats {


   val route =
      path("events") {
        get {
          respondWithMediaType(MediaTypes.`application/json`) {
          complete {
            Foo.all()
          }
        }
      }
    }
}