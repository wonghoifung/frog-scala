import scala.concurrent._
import java.util.concurrent.atomic._
import scala.annotation.tailrec

object fileops extends App {

	sealed trait State
	class Idle extends State
	class Creating extends State
	class Copying(val n:Int) extends State
	class Deleting extends State

	class Entry(val isDir:Boolean) {
		val state = new AtomicReference[State](new Idle)
	}

	@tailrec private def prepareForDelete(entry:Entry):Boolean = {
		val s0 = entry.state.get
		s0 match {
			case i:Idle => 
				if (entry.state.compareAndSet(s0,new Deleting)) true
				else prepareForDelete(entry)
			case c:Creating =>
				println("creating, cannot delete"); false
			case c:Copying =>
				println("copying, cannot delete"); false
			case d:Deleting => false
		}
	}
}
