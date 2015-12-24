package com.wong.utils

object sutils {
	implicit class SS(s:String) {
		def Increment = s.map(c => (c+1).toChar.toUpper)
	}
}

package object ssutils {
	implicit class ss2(s:String) {
		def increment2 = s.map(c => (c+2).toChar)
	}
}