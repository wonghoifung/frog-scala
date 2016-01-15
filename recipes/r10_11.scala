val days = Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

days.zipWithIndex.foreach {
  case(day, count) => println(s"$count is $day")
}

println("=========")

for ((day, count) <- days.zipWithIndex) {
  println(s"$count is $day")
}


