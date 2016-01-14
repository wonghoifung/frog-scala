
val f = (i:Int) => {i%2==0}

val rf: (Int) => Boolean = i => {i%2==0}


val arr=List(1,2,3,4,5,6)

arr.filter(f).foreach(println)
arr.filter(rf).foreach(println)

val c = scala.math.cos(_)
println(c(0))
