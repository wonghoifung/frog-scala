import scala.concurrent._
import java.util.concurrent.atomic._
import scala.annotation.tailrec

object lazytest extends App {
	lazy val obj = new AnyRef
	lazy val non = s"made by ${Thread.currentThread.getName}"
	def execute(body: =>Unit) = ExecutionContext.global.execute(
		new Runnable{
			def run() = body
		})
	execute {
		println(s"EC sees obj = $obj")
		println(s"EC sees non = $non")
	}
	println(s"MAIN sees obj = $obj")
	println(s"MAIN sees non = $non")
	Thread.sleep(500)

	/////////////////

	object l {println("l constructor")} // singleton lazy value
	println("1")
	l
	println("2")


}