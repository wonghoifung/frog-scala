def exec(cb:() => Unit)
{
  cb()
}

val sayHi = () => println("hi")

exec(sayHi)
