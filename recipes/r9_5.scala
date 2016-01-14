
class Foo {
  def exec(f:(String)=>Unit, name:String) {
    f(name)
  }
}

var hello = "Hello"
def sayHello(name:String) {println(s"$hello, $name")}

val foo = new Foo
foo.exec(sayHello, "albert")

hello = "Hola"
foo.exec(sayHello, "wong")
