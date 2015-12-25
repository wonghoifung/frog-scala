
println("100".toInt)

println(BigDecimal("3.1415926"))

println(Integer.parseInt("100", 2))

implicit class si(s:String) {
	def toIntByRadix(radix:Int) = Integer.parseInt(s,radix)
}

println("100".toIntByRadix(8))

def toInt(s:String):Option[Int] = {
	try {
		Some(s.toInt)
	} catch {
		case e: NumberFormatException => None
	}
}
println(toInt("999").getOrElse(0))
println(toInt("abc").getOrElse(0))

toInt("xxx") match {
	case Some(n) => println(n)
	case None => println("not a number") 
}

val res = toInt("777") match {
	case Some(n) => n
	case None => 0  
}
println(res)
