import scala.collection.mutable

object Size extends Enumeration {
  type size = Value
  val Large,Medium,Small = Value
}

object Color extends Enumeration {
  type size = Value
  val Red,Green,Blue= Value
}

case class Item(name:String, size:Size.Value,color:Color.Value)
val pencil = Item("pencil",Size.Large, Color.Red)
var paper = Item("paper",Size.Small,Color.Blue)

val itemList = List(pencil,paper)
for( item <-itemList){
  item match{
    case Item(name,_,_) => println(s"I have an item ${name}")
  }
}



class Pencil(color:Color.Value) extends Item("Pencil",Size.Small,color)
class Pen(color:Color.Value) extends Item("Pen",Size.Medium,color)
class Marker(color:Color.Value) extends Item("Marker",Size.Large,color)

val listOfItems:mutable.MutableList[Item] = mutable.MutableList.empty

for(i <- 1 to 30){

  val colorIndex = i % 3
  listOfItems.+=(new Pencil(Color.values.toList(colorIndex)))
  listOfItems.+=(new Pen(Color.values.toList(colorIndex)))
  listOfItems.+=(new Marker(Color.values.toList(colorIndex)))
}


for(iterationItem <- listOfItems) {
  iterationItem match {
    case p: Pencil => println(s"""I have a pencil of color: ${p.color}""")
    case p:Pen => println(s"""I have a Pen of color: ${p.color}""")
    case m:Marker => println(s"""I have a Marker of color: ${m.color}""")
  }
}

val siftedRedCount = listOfItems.count(item=> item.color == Color.Red)
val siftedRed = listOfItems.filter(item=> item.color == Color.Red).toList




val siftedRedCountFoldLeft = listOfItems.foldLeft(mutable.MutableList.empty[Item])((a, b) => {
  if(b.color == Color.Red){
    a += b
  }
  a
})





println(siftedRedCount)
println(siftedRed)

println(s"foldLeft ${siftedRedCountFoldLeft}" )
