import scala.concurrent.{Future,future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure,Success}
import scala.util.Random

object Cloud {
  def runA(i:Int):Future[Int]=future {
    Thread.sleep(Random.nextInt(500))
    val result = i + 10;
    println(s"returning result from cloud: $result")
    result
  }
}

object RunningMultipleTask extends App {
  println("starting futures")
  val res1 = Cloud.runA(10)
  val res2 = Cloud.runA(20)
  val res3 = Cloud.runA(30)
  println("before for-comprehension")
  val result = for {
    r1 <- res1
    r2 <- res2
    r3 <- res3
  } yield (r1+r2+r3)
  println("before onSuccess")
  result onSuccess {
    case result => println(s"total = $result")
  }
  println("before sleep at the end")
  Thread.sleep(2000)
}
