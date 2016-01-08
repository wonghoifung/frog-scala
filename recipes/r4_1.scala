class Person(var firstName:String, var lastName:String)
{
  println("ctor begin")

  private val HOME = System.getProperty("user.home")
  var age = 0

  override def toString = s"$firstName $lastName is $age years old"
  def printHome {println(s"HOME=$HOME")}
  def printFullName {println(this)}

  printHome
  printFullName
  println("ctor end")
}

val p = new Person("albert","wong")

println("----")

p.printHome
