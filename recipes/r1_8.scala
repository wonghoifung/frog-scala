val pat = "([0-9]+) ([A-Za-z]+)".r

val pat(num, str) = "123 abc"

println(num)
println(str)
