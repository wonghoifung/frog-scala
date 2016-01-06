import akka.actor._

case object ActNormalMessage
case object TryToFindSolution
case object BadGuysMakeMeAngry

class DavidBanner extends Actor {
	import context._

	def angryState: Receive = {
		case ActNormalMessage =>
			println("phew, i am back to being david")
			become(normalState)
	}

	def normalState: Receive = {
		case TryToFindSolution =>
			println("looking for solution to my problem...")
		case BadGuysMakeMeAngry =>
			println("i am getting angry...")
			become(angryState)
	}

	def receive = {
		case BadGuysMakeMeAngry => become(angryState)
		case ActNormalMessage => become(normalState)
	}
}

object BecomeHulk extends App {
	val system = ActorSystem("BHSYSTEM")
	val david = system.actorOf(Props[DavidBanner],name="davidBanner")
	david ! ActNormalMessage
	david ! TryToFindSolution
	david ! BadGuysMakeMeAngry
	Thread.sleep(1000)
	david ! ActNormalMessage
	system.shutdown
}