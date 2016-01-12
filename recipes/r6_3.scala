def printAll(numbers:Int*) {
  println("class: "+numbers.getClass)
}

printAll(1,2,3)
printAll()

val hello = <p>Hello, world</p>
hello.child.foreach(e => println(e.getClass))

val hello1 = <p>Hello, <br/>world</p>
hello1.child.foreach(e => println(e.getClass))
