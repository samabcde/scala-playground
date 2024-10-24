package selftype

object SelfTypeInferIssue {
  @main def main(): Unit = {
    val e = F()
    e.d.infer()
  }
}
