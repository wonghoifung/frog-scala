import akka.actor._
import akka.event.Logging

object actorTest extends App {


	class HelloActor(val hello:String) extends Actor {
		val log = Logging(context.system, this)
		def receive = {
			case `hello` => log.info(s"received a '$hello'...$hello")
			case msg => 
				log.info(s"unexpected message '$msg'")
				context.stop(self)
		}
	}

	// TODO
}