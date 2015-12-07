package hello

package object people {
  val defaultName = "John Q. Public"
}
 
package people {
  class Person {
    val name = defaultName
  }
}

class aabb {
	def f1(a:Double, b:Double):Double = {
		Math.sqrt(a * a + b * b)
	}
	def f2(a:Double, b:Double):Double = {
		a * b / 2
	}
}

