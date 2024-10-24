package selftype

trait B {
  this: C & G =>
  val b: BChild

  class BChild {
    def methodB(): String = "A"
  }
}
