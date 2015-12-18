
val pattern = "[0-9]+".r

val s = "111 aaa bbb 888 ccc 777 ddd 222"

println(pattern.findFirstIn(s))

val all = pattern.findAllIn(s)

all.foreach(println)

pattern.findAllIn(s).toArray.foreach(println)

import scala.util.matching.Regex

val pat = new Regex("[0-9]+")

println(pat.findFirstIn(s))

pat.findFirstIn(s).foreach {
	e => println(s"found a match: $e")
}

