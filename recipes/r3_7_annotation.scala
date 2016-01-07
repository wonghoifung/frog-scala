//scalac r3_7_annotation.scala
//javap -c SwitchDemo

import scala.annotation.switch

class SwitchDemo {
  val i=1
  val T=2
  val x=(i: @switch) match {
    case 1 => "one"
    case 2 => "two"
    //case T => "two"
    case _ => "other"
  }
}
