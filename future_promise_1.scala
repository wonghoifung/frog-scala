import scala.concurrent._
import ExecutionContext.Implicits.global

object futureTest extends App {
	Future {println("future lalalalala...")}
	println("main lalalalala...")
	Thread.sleep(1000)
}