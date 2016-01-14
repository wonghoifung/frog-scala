val divide = new PartialFunction[Int,Int] {
  def apply(x:Int) = 42/x
  def isDefinedAt(x:Int) = x!=0
}

println(divide.isDefinedAt(1))
println(divide.isDefinedAt(0))

val divide2:PartialFunction[Int,Int] = {
  case d:Int if d!=0 => 42/d
}
println(divide2.isDefinedAt(1))
println(divide2.isDefinedAt(0))

val convertLowNumToString = new PartialFunction[Int, String] {
  val nums = Array("one", "two", "three", "four", "five")
  def apply(i: Int) = nums(i-1)
  def isDefinedAt(i: Int) = i > 0 && i < 6
}
println(convertLowNumToString(1))
println(convertLowNumToString(2))


val convert1to5 = new PartialFunction[Int, String] {
  val nums = Array("one", "two", "three", "four", "five")
  def apply(i: Int) = nums(i-1)
  def isDefinedAt(i: Int) = i > 0 && i < 6
}
val convert6to10 = new PartialFunction[Int, String] {
  val nums = Array("six", "seven", "eight", "nine", "ten")
  def apply(i: Int) = nums(i-6)
  def isDefinedAt(i: Int) = i > 5 && i < 11
}
val handle1to10 = convert1to5 orElse convert6to10
println(handle1to10(3))
println(handle1to10(8))


println(List(0,1,2) collect { divide2 })
//println(List(0,1,2) map { divide2 })
