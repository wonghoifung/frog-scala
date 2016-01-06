import akka.actor._

class HelloActor(myName:String) extends Actor {
  def receive = {
    case "hello" => println(s"hello back at you from $myName")
    case _       => println(s"huh? from $myName")
  }
}

object Main extends App {
  val system = ActorSystem("helloSystem")
  //val helloactor = system.actorOf(Props[HelloActor], name="helloactor")
  val helloactor = system.actorOf(Props(new HelloActor("albert")), name="helloactor")
  helloactor ! "hello"
  helloactor ! "hi"
  system.shutdown
}

