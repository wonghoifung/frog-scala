case class Person(var username:String, var password:String)
{
  var age = 0
  var address = None:Option[Address]
}

case class Address(city:String,state:String,zip:String)

val p = Person("wong","ssss")
//p.address = Some(Address("zs","east","1111"))

p.address.foreach {
	a =>
		println(a.city)
		println(a.state)
		println(a.zip)
}
