val pi = scala.math.Pi
println(pi)
println(f"$pi%1.5f")
println(f"$pi%07.2f")
println("%07.3f".format(pi))

val formatter = java.text.NumberFormat.getIntegerInstance
println(formatter.format(10000))

val locale = new java.util.Locale("de", "DE")
val formatter2 = java.text.NumberFormat.getIntegerInstance(locale)
println(formatter2.format(10000))

val formatter3 = java.text.NumberFormat.getInstance
println(formatter3.format(10000.33))

val formatter4 = java.text.NumberFormat.getCurrencyInstance
println(formatter4.format(10000.33))

import java.util.{Currency, Locale}
val de = Currency.getInstance(new Locale("de", "DE"))
formatter4.setCurrency(de)
println(formatter4.format(10000.33))


