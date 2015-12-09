import scala.collection._

object jt3 extends App {

	private val tasks = mutable.Queue[() => Unit]()

	object Worker extends Thread {
		setDaemon(true)
		var terminated = false
		def poll() = tasks.synchronized {
			while (tasks.isEmpty && !terminated) tasks.wait()
			if(!terminated) Some(tasks.dequeue()) else None
		}
		import scala.annotation.tailrec
		@tailrec override def run() = poll() match {
			case Some(task) => task(); run()
			case None => 
		}
		def shutdown() = tasks.synchronized {
			terminated = true
			tasks.notify()
		}
	}

	Worker.start()

	def asynchronous(body: => Unit) = tasks.synchronized {
		tasks.enqueue(() => body)
		tasks.notify()
	}

	asynchronous{println("hello")}
	asynchronous{println{"world"}}

	Worker.shutdown()

	Thread.sleep(5000)

	///////////////////////

	def thread(body: =>Unit):Thread = {
		val t = new Thread {
			override def run() = body
		}
		t.start()
		t
	}

	class Page(val txt:String, var position:Int)

	val pages = for (i <- 1 to 5) yield new Page("Na" * (100 - 20 * i) + " !", -1)

	@volatile var found = false

	for( p <- pages ) yield thread {
		var i = 0
		while (i < p.txt.length && !found) {
			if(p.txt(i) == '!') {
				p.position = i
				found = true
			}
			else {
				i += 1
			}
		}
	}

	while (!found) {}

	println(s"results: ${pages.map(_.position)}")
}