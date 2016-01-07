// scalac -Xprint:parse r3_1_discussion.scala
// scalac -Xprint:all r3_1_discussion.scala

class Main {
  for (i <- 1 to 10 if i < 5) println(i)

  val m = for (i <- 1 to 10 if i>5) yield i + 100
}
