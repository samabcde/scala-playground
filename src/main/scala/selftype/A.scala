package selftype

trait A {
  this: E =>
  val a: AChild

  class AChild {
    def methodA(): String = "A"
  }
}
