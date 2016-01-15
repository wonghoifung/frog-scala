val stream = 1 #:: 2 #:: 3 #:: Stream.empty
println(stream.take(3))

stream.foreach(println)
