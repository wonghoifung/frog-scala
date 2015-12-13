import scala.concurrent._
import ExecutionContext.Implicits.global

object promiseTest extends App {
	val p = Promise[String]
	val q = Promise[String]
	println("---1")
	p.future foreach {
		case x => println(s"p succeeded with $x")
	}
	println("---2")
	Thread.sleep(1000)
	println("---2---")
	p success "assigned"
	q failure new Exception("not kept")
	println("---3")
	q.future.failed foreach {
		case t => println(s"q failed with $t")
	}
	println("---4")
	Thread.sleep(1000)
	println("---4---")
}