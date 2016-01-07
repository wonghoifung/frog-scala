import util.control.Breaks._
import util.control._

object BreakAndContinueDemo extends App {

  breakable {
    for (i <- 1 to 10) {
      println(i)
      if (i > 4) break
    }
  }

  for (i <- 0 to 10) {
    breakable {
      if (i % 2 == 0) break
      println(s"----> $i")
    }
  }

  val Inner = new Breaks
  val Outer = new Breaks
  Outer.breakable {
    for (i <- 1 to 5) {
      Inner.breakable {
        for (j <- 'a' to 'e') {
          if (i==1 && j=='c') Inner.break else println(s"i: $i, j: $j")
          if (i==2 && j=='b') Outer.break
        }
      }
    }
  }
}

