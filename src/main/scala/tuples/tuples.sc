val tupleFour :(String, Int, Int, Char)= ("home",12,33,'c')
println(tupleFour)
println(tupleFour._4)

val (location,age,counter,initial) = tupleFour

println(location)
println(age)
println(counter)
println(initial)


val interestingList = List(
  ("Light",13,1),
  ("Dark",22,2),
  ("Moment",42,3),
  ("Future",53,4)
)

interestingList.foreach(tuple=>{
  tuple match{
    case ("Light",level,number) => println(s"""The light is ${level} and at ${number}""")
    case p if(p._2 % 2 ==0) => println(s"Level is even ${p._1}")
    case _=> println("Others")
  }
})


for((a,b,c) <- interestingList){
  if(a.length > 5)
    println(a)
}


val nameList = for{
  (a,b,c) <- interestingList
  if(c > 3)
} yield a




nameList.foreach(item => println( s"""result ${item}"""))
