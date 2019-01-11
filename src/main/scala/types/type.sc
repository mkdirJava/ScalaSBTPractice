val allValueList: List[Any] = List(
  331,
  true,
  'B',
  "Stringed messageg",
  () => "an anonymous function returning a string"
)
allValueList.foreach(entry => println(entry))

allValueList.foreach(entry => entry match {
  case s:String  => println(s"I am an String ${s}")
  case i:Int => println(s"I am a Int ${i}")
  case unreg => println(s"unregistered Type ${unreg.getClass}" )
})
// cannot cast, will have to tell the compiller to loose precision

