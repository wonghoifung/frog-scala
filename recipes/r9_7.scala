def saySomething(prefix:String) = (s:String)=>{
  prefix + " " + s
}

val sayHello = saySomething("Hello")

println(sayHello("albert"))
