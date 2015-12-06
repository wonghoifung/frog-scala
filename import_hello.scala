import hello._
val a = new aabb
println(a.f1(3, 4))
println(a.f2(3, 4))

/////////////

val v1 = Vector(1,3,5,7,9)
for( i <- v1) {
	println(i)
}
println("head: " + v1.head)
println("tail: " + v1.tail)
println("idx4: " + v1(4))

/////////////

var result = ""
for( i <- Range(0,10).inclusive) {
	result += i + " "
}
println(result)

/////////////

def matchColor(color:String):String = {
	color match {
		case "red" => "RED"
		case "blue" => "BLUE"
		case "green" => "GREEN"
		case _ => "UNKNOWN COLOR: " + color
	}
}

println(matchColor("white"))
println(matchColor("blue"))

/////////////

class ClassArg(a:Int) {
	println(f)
	def f():Int = {
		a * 10
	}
}

val ca = new ClassArg(9)
println(ca.f)

/////////////

class Sum(args:Int*) {
	def result():Int = {
		var total = 0
		for( n <- args) {
			total += n
		}
		total
	}
}

println(new Sum(1,2,3,4).result)

/////////////

class GardenGnome(val height:Double, val weight:Double, val happy:Boolean) {
	println("inside primary constructor")
	var painted = true
	def magic(level:Int):String = {
		"poof! " + level
	}
	def this(height:Double) {
		this(height, 100.0, true)
	}
	def this(name:String) {
		this(15.0)
	}
	def show():String = {
		height + " " + weight + " " + happy + " " + painted
	}
}

println(new GardenGnome(20.0, 110.0, false).show)

println(new GardenGnome("Bob").show)

/////////////

case class Dog(name:String)
val d1 = new Dog("d1")
val d2 = Dog("d2")
val ds = Vector(d1, d2)
println(ds)

/////////////

def fi(s:String, n:Int, d:Double):String = {
	s"first: $s, second: $n, third: $d"
}
println(fi("wong",1,2))

def ff(n:Int):Int = {
	n * 11
}
println(s"ff(8) is ${ff(8)}")


case class sky(color:String)
println(s"""${new sky("blue")}""")

/////////////

val v = Vector(1,2,3)
println(v)
val vv = Vector[Int](4,5,6)
println(vv)

/////////////

def show(n:Int):Unit = {
	println("> " + n)
}
vv.foreach(show)

v.foreach(n => {println(">>> " + n)})

var sss = ""
val ddd = "ddd".toVector
ddd.foreach(n => sss = sss + n + ":")
println(sss)

val v2 = v.sortWith((i, j) => j < i)
println(v2)

class Later(val f: () => Unit) {
	def call():Unit = {
		f()
	}
}
var l = new Later(() => println("..."))
l.call

/////////////

val v3 = v.map(n => n + 1)
println(v3)

println(v.reduce((sum, n) => sum + n))

/////////////

def eventGT5(v:Vector[Int]):Vector[Int] = {
	var result = Vector[Int]()
	for {
		n <- v
		if n > 5
		if n % 2 == 0
	} result = result :+ n
	result
}
val v4 = Vector(1,2,3,5,6,7,8,10,13,14,17)
println(eventGT5(v4))

def yielding(v:Vector[Int]):Vector[Int] = {
	val result = for {
		n <- v
		if n < 10
		if n % 2 != 0
	} yield n
	result
}
println(yielding(v4))

def yielding2(v:Vector[Int]) = {
	for {
		n <- v
		if n < 10
		if (n % 2 != 0)
	} yield {
		for( u <- Range(0,n))
			yield u
	}
}
println(yielding2(v4))

/////////////

def acceptAnything(x:Any):String = {
	x match {
		case ss:String => "string: " + ss
		case ii:Int if (ii < 20) => s"an int less than 20: $ii"
		case ii:Int => s"some other int: $ii"
		case pp:Person => s"a person ${pp.name}"
		case _ => "i don't know what that is"
	}
}

println(acceptAnything(5))
println(acceptAnything(21))
println(acceptAnything("sssss"))

case class Person(name:String)
println(acceptAnything(Person("wong")))
println(acceptAnything(Vector(1)))

/////////////

case class Passenger(first:String, last:String)
case class Train(travelers:Vector[Passenger], line:String)
case class Bus(passengers:Vector[Passenger], capacity:Int)

def travel(transport:Any):String = {
	transport match {
		case Train(travelers, line) => s"train line $line $travelers"
		case Bus(travelers, seats) => s"bus size $seats $travelers"
		case Passenger => "walking along"
		case what => s"$what is in limbo"
	}
}

val travelers = Vector(Passenger("hoifung", "wong"), Passenger("haifeng", "huang"))
val trip = Vector(Train(travelers, "Reading"), Bus(travelers, 100))
println(travel(trip(0)))
println(travel(trip(1)))

/////////////

class M(var i:Int) {
	def +(o:M) = {
		i += o.i
	}
}

var m1 = new M(8)
var m2 = new M(9)
println(m1.i)
println(m2.i)
m1 + m2
println(m1.i)
println(m2.i)

/////////////

class ble(val a:String) {
	override def toString() = {
		"ble with " + a
	}
}
println(new ble("wong"))

/////////////

case class tuple(data:Double, info:String)

def data(input:Double) = {
	if(input > 5.0){
		tuple(input * 2, "high")
	}
	else{
		tuple(input * 2, "low")
	}
}
println(data(7.0))
println(data(4.0))

def data2(input:Double):(Double, String) = {
	if(input > 5.0){
		(input * 2, "high")
	}
	else{
		(input * 2, "low")
	}
}
println(data2(7.0))
println(data2(4.0))

def tt = (1,2,3)
println(tt._1)
println(tt._2)
println(tt._3)
val (az,bz,cz) = tt
println(cz,bz,az)

/////////////

object X {
	val n = 2
	def g = n * 2
}
println(X.n)
println(X.g)

class Count {
	val id = Count.id()
	override def toString = s"Count$id"
}
object Count {
	var n = -1
	def id() = {
		n += 1;
		n
	}
}
val cv = Vector(new Count, new Count, new Count)
println(cv)

class Car(val make:String) {
	override def toString = s"Car($make)"
}
object Car {
	def apply(make:String) = new Car(make)
}
val mycar = Car("toyota")
println(mycar)

/////////////

class GreatApe {
	val weight = 100.0
	val age = 12
}
class Bonobo extends GreatApe 
def display(ape:GreatApe) = {
	s"weight: ${ape.weight}, age: ${ape.age}"
}
println(display(new Bonobo))

/////////////

class House(val address:String, val state:String, val zip:String) {
	def this(state:String, zip:String) = {
		this("address?", state, zip)
	}
	def this(zip:String) = {
		this("address?", "state?", zip)
	}
}
class Home(address:String, state:String, zip:String, val name:String) extends House(address, state, zip) {
	override def toString = s"$name: $address, $state, $zip"
}
println(new Home("aaa","sss","zzz","nnn"))

/////////////

object Level extends Enumeration {
	//type Level = Value
	val Overflow, High, Medium, Low, Empty = Value
}
println(Level.Medium)
import Level._
println(Medium)
println( { for( n <- Range(0, Level.maxId)) yield (n, Level(n)) } )
println( { for( n <- Level.values) yield n }.toIndexedSeq )

/////////////

abstract class Animal {
	def templateMethod = s"the $animal goes $sound"
	def animal:String
	def sound:String
}
class Duck extends Animal {
	def animal = "Duck"
	override def sound = "Quack" // override is optional
}
println((new Duck).templateMethod)

/////////////

trait A {
	def f = 1.1
	def g = "A.g"
	val n = 7
}
trait  B {
	def f = 7.7
	def g = "B.g"
	val n = 17
}
object C extends A with  B {
	override def f = 9.9
	override val n = 27
	override def g = super[A].g + super[B].g
}
println(C.f)
println(C.n)
println(C.g)

/////////////

trait  Base {
	var d3:Int
	var n = 1
}

class Derived extends Base {
	def d3 = n
	def d3_=(newVal:Int) = {
		n = newVal
	}
}

val dddd = new Derived
println(dddd.d3)
dddd.d3 = 999
println(dddd.d3)

/////////////

import java.util.Date
val datej = new Date
println(datej)

/////////////

import reflect.runtime.currentMirror
object Name {
	def className(o:Any) = {
		currentMirror.reflect(o).symbol.toString.replace('$', ' ').split(' ').last
	}
}
trait Name {
	override def toString = Name.className(this)
}

class Solid extends Name
val ssss = new Solid
println(ssss)

/////////////

class Element extends Name {
	def interact(other:Element) = s"$this interact $other"
}
class Inert extends Element
class Wall extends Element

trait Material {
	def resilience:String
}
trait Wood extends Material {
	def resilience = "breakable"
}
trait Rock extends Material {
	def resilience = "hard"
}

class RockWall extends Wall with Rock
class WoodWall extends Wall with Wood

trait Skill
trait Fighting extends Skill {
	def fight = "Fight!"
}
trait Digging extends Skill {
	def dig = "Dig!"
}
trait Magic extends Skill {
	def castSpell = "Spell!"
}
trait Flight extends Skill {
	def fly = "Fly!"
}

class Character(var player:String="None") extends Element
class Fairy extends Character with  Magic
class Viking extends Character with  Fighting
class Dwarf extends Character with Digging with Fighting
class Wizard extends Character with Magic
class Dragon extends Character with Magic with Flight

val dragon1 = new Dragon
dragon1.player = "Puff"
println(dragon1.interact(new Wall))

def battle(fighter:Fighting) = {
	s"$fighter, ${fighter.fight}"
}
println(battle(new Viking))
println(battle(new Dwarf))
println(battle(new Fairy with Fighting))

def fly(flyer:Element with Flight, opponent:Element) = {
	s"$flyer, ${flyer.fly}, " + s"${opponent.interact(flyer)}"
}
println(fly(dragon1, new Fairy))

/////////////

// 1*1 + 3*3 + .... + 99*99
var sum=0
for( n <- 1 to 99) if(n%2==1) sum+=n*n 
println(sum)



















