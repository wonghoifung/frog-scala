class Person private (var name:String)

//val p=new Person("hi")

object Person
{
  val p = new Person("wong")
  def getInstance = p
}

val p = Person.getInstance
println(p.name)
