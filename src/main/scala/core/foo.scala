package core

import akka.actor.Actor
import spray.routing._
import spray.http._
import spray.httpx.SprayJsonSupport._

object FooActor {
  case class SendFoo(name: String, signatureId: Int, severity: Int)
}

class FooActor extends Actor {
  import FooActor._

  def receive: Receive = {
    case SendFoo(name, signatureId, severity) =>
  }
}

