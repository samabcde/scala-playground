package selftype

trait G {
  this: A & B =>
  val g: GChild

  class GChild {
    def methodG(): Unit = {
      println(a.methodA() + b.methodB())
      ()
    }
  }
}