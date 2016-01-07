case class Person(firstName: String, lastName: String)

object Test2 extends App {
  def matchType(x: Any): String = x match {
    case x @ List(1, _*) => s"$x" 
    case x @ Some(_) => s"$x" 
    case p @ Person(first, "Doe") => s"$p" 
  }
  println(matchType(List(1,2,3))) 
  println(matchType(Some("foo"))) 
  println(matchType(Person("John", "Doe"))) 
}
