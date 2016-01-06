
val v = Vector.range(0, 10)

v.foreach(print)
println("")

v.par.foreach(print)
println("")

import scala.collection.parallel.immutable.ParVector

val v2 = ParVector.range(0, 10)

v2.foreach{ e => Thread.sleep(100); print(e) }
println("")