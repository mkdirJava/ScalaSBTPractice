// default parameters, Scala supports this

case class Thing(val num:Int = 0 )

println(Thing)
println(Thing(9))

// Like python you can order the parameter passing by specing
// the param name

println(Thing(num=2))

/*
Packaging in Scala can form in a flexable manner
It is very similar to C++, you can define packages
within others and imports whenever convenient
 */


