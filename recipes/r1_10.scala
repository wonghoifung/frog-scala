implicit class ss(s:String) {
	def increment = s.map(c => (c+1).toChar)
}
val result = "hal".increment
println(result)

import com.wong.utils.sutils._
println("hal".Increment)

import com.wong.utils.ssutils._
println("hal".increment2)

class si(s:String) {
	def add3 = s.map(c => (c+3).toChar)
}
implicit def stringToString(s:String) = new si(s)
println("hal".add3)