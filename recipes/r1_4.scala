val name = "abc"
val age = 30
val s = s"$name is $age years old"
println(s)

val s2 = s"age: ${age + 1}"
println(s2)

case class Stu(name:String,score:Int)
val wong=Stu("wonghoifung",99)
val s3 = s"${wong.name} score ${wong.score}"
println(s3)

val weight = 80
val s4 = f"weight is $weight%.2f kilo"
println(s4)

val s5 = raw"hello\nworld"
println(s5)

val s6 = "%s...".format(name)
println(s6)
