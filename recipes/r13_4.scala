import akka.actor._

class Kenny extends Actor {
  println("entered the Kenny ctor")
  override def preStart {println("Kenny: preStart")}
  override def postStop {println("Kenny: postStop")}
  override def preRestart(reason:Throwable, message:Option[Any]) {
    println("Kenny: preRestart")
    println(s" Message: ${message.getOrElse("")}")
    println(s" Reason: ${reason.getMessage}")
    super.preRestart(reason, message)
  }
  override def postRestart(reason:Throwable) {
    println("Kenny: postRestart")
    println(s" Reason: ${reason.getMessage}")
    super.postRestart(reason)
  }
  def receive = {
    case ForceRestart => throw new Exception("Boom")
    case _ => println("Kenny received a message")
  }
}

case object ForceRestart

object Lifecycle extends App {
  
  val system = ActorSystem("LCSYSTEM")
  val kenny = system.actorOf(Props[Kenny], name="kenny")

  println("sending kenny a simple string msg")
  kenny ! "hi"
  Thread.sleep(1000)

  println("make kenny restart")
  kenny ! ForceRestart
  Thread.sleep(1000)

  println("stopping kenny")
  system.stop(kenny)
  Thread.sleep(1000)

  println("shutdown system")
  system.shutdown
}

