import scala.actors.Actor 

object actorTest extends App {
	class HiActor extends Actor {
		def act() {
			while (true) {
				receive {
					case "Hi" => println("hello")
				}
			}
		}
	}

	val actor1 = new HiActor
	actor1.start()

	actor1 ! "Hi"
}