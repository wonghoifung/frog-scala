object ThreadsCreation extends App {
	class MyThread extends Thread {
		override def run():Unit = {
			println(".............")
		}
	}

	val t = new MyThread
	t.start()
	t.join()
	println("main end")

	//////////////////////////

	def thread(body: =>Unit):Thread = {
		val t = new Thread {
			override def run() = body
		}
		t.start()
		t
	}

	val t2 = thread {
		Thread.sleep(1000)
		println("--------------")
		Thread.sleep(1000)
		println("==============")
		Thread.sleep(1000)
		println("done")
	}
	t2.join
	println("main end 2")

	//////////////////////////

	var uid = 0L
	def getuid() = this.synchronized {
		val ret = uid + 1
		uid = ret
		ret
	}
	def printuid(n:Int):Unit = {
		val uids = for (i <- 0 until n) yield getuid
		println(uids)
	}
	val t3 = thread { printuid(5) }
	printuid(5)
	t3.join
}
