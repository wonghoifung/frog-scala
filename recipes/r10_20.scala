val a=Array(1,2,3)

println(a.reduceLeft(_+_))
println(a.foldLeft(20)(_+_))


val divide = (x:Double, y:Double) => {
  val res = x/y
  println(s"$x / $y = $res")
  res
}

val aa=Array(1.0,2.0,3.0)
println(aa.reduceLeft(divide))
println(aa.reduceRight(divide))

println("========")
val product = (x: Int, y: Int) => {
  val result = x * y
  println(s"multiplied $x by $y to yield $result")
  result
}
a.scanLeft(10)(product).foreach(println)
println("========")
a.scanRight(10)(product).foreach(println)
