package selftype

trait C {
  this: A & B =>
  val d: D

  class D {
    def infer(): Unit = {
      println(a.methodA() + b.methodB())
    }
  }
}
