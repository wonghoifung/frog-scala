import akka.actor._

case object Explode

class Kenny extends Actor {
  def receive = {
    case Explode => throw new Exception("boom")
    case _ => println("kenny received a msg")
  }
  override def preStart { println("kenny: preStart") }
  override def postStop { println("kenny: postStop") }
  override def preRestart(reason: Throwable, message: Option[Any]) {
    println("kenny: preRestart")
    super.preRestart(reason, message)
  }
  override def postRestart(reason: Throwable) {
    println("kenny: postRestart")
    super.postRestart(reason)
  }
}

class Parent extends Actor {
  val kenny = context.actorOf(Props[Kenny],name="kenny")
  context.watch(kenny)
  def receive = {
    case Terminated(kenny) => println("omg, they kelled kenny")
    case _ => println("parent received a msg")
  }
}

object DeathWatch extends App {
  val system = ActorSystem("DWSYSTEM")
  val parent = system.actorOf(Props[Parent],name="parent")
  val kenny = system.actorSelection("/user/parent/kenny")
  kenny ! Explode
  kenny ! "bbbb"
  //kenny ! PoisonPill
  Thread.sleep(5000)
  println("shutdown system")
  system.shutdown
}
