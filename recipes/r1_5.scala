val s = "hello"
val sup = s.map(c => c.toUpper)
println(sup)
println(s.map(_.toUpper))
println(s.filter(_ != 'l').map(_.toUpper))

val sup2 = for (c <- s) yield c.toUpper
println(sup2)

val sup3 = for {
	c <- s
	if c != 'l'
    } yield c.toUpper
println(sup3)
println(s)

s.foreach(println)

val sup4 = s.map(c => (c.toByte - 32).toChar)
println(sup4)

// method
def myToUpper(c:Char):Char = (c.toByte - 32).toChar
val sup5 = s.map(myToUpper)
println(sup5)
println( for (c <- s) yield myToUpper(c) )

// function
val myToUpper2 = (c:Char) => (c.toByte - 32).toChar
val sup6 = s.map(myToUpper2)
println(s"6: $sup6")

s.getBytes.foreach(println)
