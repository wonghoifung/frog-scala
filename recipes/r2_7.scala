val r = scala.util.Random
println(r.nextInt)
println(r.nextInt(100))
println(r.nextFloat)
println(r.nextDouble)

val r2 = new scala.util.Random(1000)
println(r.nextInt)
println(r.nextInt(100))
println(r.nextFloat)
println(r.nextDouble)

r2.setSeed(99)
println(r.nextInt)
println(r.nextInt(100))
println(r.nextFloat)
println(r.nextDouble)

println(r.nextPrintableChar)
println(r.nextPrintableChar)
println(r.nextPrintableChar)

println(0 to r.nextInt(10))
println(for(i <- 0 to r.nextInt(10)) yield i * 2)

println(for(i <- 0 to r.nextInt(10)) yield (i * r.nextFloat))

