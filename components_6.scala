import scala.concurrent._
import java.util.concurrent.atomic._
import scala.collection._
import scala.collection.convert.decorateAsScala._
import scala.sys.process._
import java.io.File
import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue, ConcurrentHashMap}
import scala.annotation.tailrec

object traverse extends App {

	def execute(body: =>Unit) = ExecutionContext.global.execute(
		new Runnable{
			def run() = body
		})

	val names = new ConcurrentHashMap[String,Int]().asScala 
	names("Johny")=0
	names("wong")=0
	names("hoifung")=0
	execute {
		for (n <- 0 until 10) names(s"Johny $n") = n
	}
	execute {
		for (n <- names) println(s"name: $n")
	}
	Thread.sleep(1000)

	///////////////////////

	val n2 = new concurrent.TrieMap[String,Int]
	n2("java")=0
	n2("scala")=0
	execute {
		for (n <- 10 until 100) n2(s"c++ $n")=n
	}
	execute {
		println("snapshot")
		for (n <- n2.map(_._1).toSeq.sorted) println(s"name: $n")
	}
	Thread.sleep(1000)

	//////////////////////

	val output = s"wc components_6.scala".!!
	println(output)

}