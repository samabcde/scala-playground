class Point:
  private var _a = 0
  private var _b = 0
  private val bound = 100

  def c: Int = _a

  def c_=(newValue: Int): Unit =
    if newValue < bound then
      _a = newValue
    else
      printWarning()

  def y: Int = _b

  def y_=(newValue: Int): Unit =
    if newValue < bound then
      _b = newValue
    else
      printWarning()

  private def printWarning(): Unit =
    println("WARNING: Out of bounds")
end Point

def main(args: Array[String]): Unit = {
  val p = Point()
  p.c = 2
  p.y = 2
  p.c
}