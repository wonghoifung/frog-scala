object ThreadsMain extends App {
	val t:Thread = Thread.currentThread
	val name = t.getName
	println(s"$name running")
}