import scala.concurrent._
import java.util.concurrent.atomic._

object cas extends App {

	private val lock = new AtomicBoolean(false)

	def execute(body: =>Unit) = ExecutionContext.global.execute(
		new Runnable{
			def run() = body
		})

	def sync(body: =>Unit):Unit = {
		while (!lock.compareAndSet(false,true)) {}
		try body finally lock.set(false)
	}

	var count = 0

	for( i <- 0 until 32) execute {
		sync { count += 1 }
	}

	Thread.sleep(1000)

	println(s"done count:$count")
}
