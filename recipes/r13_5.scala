//package actortests.parentchild

import akka.actor._

case class CreateChild(name:String)
case class Name(name:String)

class Child extends Actor {
  var name = "no name"
  override def postStop {
    println(s"they killed me ($name): ${self.path}")
  }
  def receive = {  
    case Name(name) => this.name = name
    case _ => println(s"child $name got message")
  }
}

class Parent extends Actor {
  def receive = {
    case CreateChild(name) => 
      println(s"parent about to create child ($name)...")  
      val child = context.actorOf(Props[Child],name=s"$name")
      child ! Name(name)
    case _ => println(s"parent got some other msg")
  }
}

object ParentChild extends App {
  val actorSystem = ActorSystem("PCSYSTEM")
  val parent = actorSystem.actorOf(Props[Parent],name="parent")
  parent ! CreateChild("wong")
  parent ! CreateChild("albert")
  Thread.sleep(500)
  println("sending wong a poison pill ...")
  val wong = actorSystem.actorSelection("/user/parent/wong")
  wong ! PoisonPill
  println("wong was killed")
  Thread.sleep(500)
  println("system shutdown")
  actorSystem.shutdown
}
