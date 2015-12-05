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

