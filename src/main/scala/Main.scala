import cats.effect.{IO, IOApp}

import scala.util.Try

object Main extends IOApp.Simple {
  override def run: IO[Unit] = {
    val b = (for {
      a <- printABC
      //      if() throw new RuntimeException("AAA")
      c <- IO.fromTry(Try {
        println("in try")
        List(a).tail.tail.tail.head
      })
    } yield c)
    b.map(s => println(s)).onError(t => IO.println(t))
    b.background
    val c = printABC.flatMap(s => IO.println(s + "DEF"))
    c
  }

  private def printABC: IO[String] = {
    IO.println("ABC").map(_ => "ABC")
  }
}
