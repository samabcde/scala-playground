import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.scalatestplus.junit5.JUnitSuiteLike

class HelloTest extends JUnitSuiteLike {
  @Test
  def testSomething(): Unit = {
    assertEquals("Hello", Hello().something())
  }

}
