for (i <- 1 to 2; j <- 1 to 3) println(s"i:$i j:$j")

for {i <- 1 to 2 
     j <- 1 to 3} println(s"i:$i j:$j")

val array = Array.ofDim[Int](2,2)
array(0)(0)=0
array(0)(1)=1
array(1)(0)=2
array(1)(1)=3
for {i <- 0 to 1 
     j <- 0 to 1} println(s"i:$i j:$j ${array(i)(j)}")


