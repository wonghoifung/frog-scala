def printAll(strings: String*) {
  strings.foreach(println)
}

printAll()
printAll("foo")
printAll("foo", "bar")
printAll("foo", "bar", "baz")

println("---------")

val fruits = List("apple", "banana", "cherry")
printAll(fruits: _*)

