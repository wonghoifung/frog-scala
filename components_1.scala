import scala.concurrent._

object executorcreate extends App {
	// val executor = new forkjoin.ForkJoinPool
	
	// executor.execute(new Runnable {
	// 	def run = println("task running")
	// 	})

	// Thread.sleep(5000)

	def execute(body: =>Unit) = ExecutionContext.global.execute(
		new Runnable{
			def run() = body
		})

	for( i <- 0 until 32) execute {
		Thread.sleep(2000)
		println(s"task $i completed")
	}
	Thread.sleep(10000)
}
