def ~=(x:Double, y:Double, precision:Double) = {
	if ((x-y).abs < precision) true else false
}

val a=0.3

println(a)

val b=0.1+0.2

println(b)

println(~=(a,b,0.0001))

println(~=(b,a,0.0001))

implicit class dd(x:Double) {
	def ~=(y:Double, precision:Double=0.0001) = {
		if ((x-y).abs < precision) true else false
	}
}

if (a ~= b) println("a~=b")
