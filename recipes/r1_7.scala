val addr = "123 aaa".replaceAll("[0-9]","x")
println(addr)

val reg = "[0-9]".r
val addr1 = reg.replaceAllIn("123123123 a;slkdfasldkfj","z")
println(addr1)

val addr2 = "123 aaa".replaceFirst("[0-9]","x")
println(addr2)

val reg1 = "H".r
val res = reg1.replaceFirstIn("Hello","o")
println(res)
