package core

import spray.json._

case class FooList(items: List[Foo])
case class Foo(id: Int, name: String, signatureId: Int, severity: Int)

object Foo {
  def all(): FooList = {
    FooList(List(Foo(1, "Foo", 11111, 10), Foo(2, "Fooz", 222222, 10), Foo(3, "Foo", 333333, 10), Foo(4, "Foo", 444444, 10)))
  }
}

object FooJsonProtocol extends DefaultJsonProtocol {

  // https://github.com/spray/spray-json
  // There is one additional quirk: If you explicitly declare the companion object for your case class the notation
  // above will stop working. You'll have to explicitly refer to the companion objects apply method to fix this:
  implicit val fooFormat = jsonFormat4(Foo.apply)

  implicit object foosListJsonFormat extends RootJsonFormat[FooList] {
    def read(value: JsValue) = FooList(value.convertTo[List[Foo]])
    def write(f: FooList) = f.items.toJson
  }
}



