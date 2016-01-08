class PandorasBox
{
  case class Thing(name:String)
  
  var things = new collection.mutable.ArrayBuffer[Thing]()
  things += Thing("ddddd#1")
  things += Thing("ddddd#2")
  def addThing(name:String){things += new Thing(name)}
}

val p = new PandorasBox
p.things.foreach(println)

val pt = p.Thing("dddbbb")
println(pt)
