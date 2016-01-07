val fruits = "apple" :: "banana" :: "orange" :: Nil

val out = for (e <- fruits) yield e.toUpperCase

out.foreach(println)
