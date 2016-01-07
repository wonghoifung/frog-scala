val i=20
i match {
case a if 0 to 9 contains a => println("0-9 range: " + a)
case b if 10 to 19 contains b => println("10-19 range: " + b)
case c if 20 to 29 contains c => println("20-29 range: " + c)
case _ => println("Hmmm...")
}
