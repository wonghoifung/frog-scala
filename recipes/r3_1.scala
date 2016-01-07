val a = Array("apple","banana","orange")

for (i <- 0 until a.length) {
  println(s"$i is ${a(i)}")
}

for ((e,c) <- a.zipWithIndex) {
  println(s"$c $e")
}

val newa = for (e <- a) yield {
             val s = e.toUpperCase
             s
           }
newa.foreach(println)

a.foreach(println)

newa.foreach { e => 
  val s=e.toUpperCase
  println(s)
}
