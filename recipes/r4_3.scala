class Pizza(var crustSize:Int, var crustType:String) 
{
  def this(crustSize:Int) {this(crustSize, Pizza.DEFAULT_CRUST_TYPE)}
  def this(crustType:String) {this(Pizza.DEFAULT_CRUST_SIZE, crustType)}
  def this() {this(Pizza.DEFAULT_CRUST_SIZE,Pizza.DEFAULT_CRUST_TYPE)}
  override def toString() = s"a $crustSize inch pizza with a $crustType crust"
}

object Pizza
{
  val DEFAULT_CRUST_SIZE=12
  val DEFAULT_CRUST_TYPE="THIN"
}

val p1 = new Pizza(1,"ss")
println(p1)
val p2 = new Pizza(2)
println(p2)
val p3 = new Pizza("bb")
println(p3)
val p4 = new Pizza()
println(p4)

println("")

case class Person(var name:String, var age:Int)
object Person
{
  def apply() = new Person("unknown",0)
  def apply(name:String) = new Person(name,0)
}

val a=Person()
val b=Person("wong")
val c=Person("albert",30)
println(a)
println(b)
println(c)
a.name="hi"
a.age=29
println(a)
