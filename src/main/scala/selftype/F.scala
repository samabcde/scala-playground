package selftype

class F extends C with A with B with E with G{
  override val d: D = D()
  override val a: AChild = AChild()
  override val b: BChild = BChild()
  override val e: EChild = EChild()
  override val g: GChild = GChild()
}
