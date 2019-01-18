import scala.util.Random

val x =  Random.nextInt(10)


var result = x match{
  case 0 => "0"
  case 1 => "1"
  case 2 => "2"
  case 3 => "3"
  case _ => "Not here"
}

println(result)



def numberToString(x:Int) = x match{
  case 0 => "0"
  case 1 => "1"
  case 2 => "2"
  case 3 => "3"
  case _ => "Not here"
}


println(numberToString(0))
println(numberToString(22))

//////////////////////////////////////////////////////////////////////////////////

object Size extends Enumeration {
  type size = Value
  val Large,Medium,Small = Value
}

object Color extends Enumeration {
  type size = Value
  val Red,Green,Blue= Value
}

case class Item(name:String, size:Size.Value,color:Color.Value)
class Pencil(color:Color.Value) extends Item("Pencil",Size.Small,color)
class Pen(color:Color.Value) extends Item("Pen",Size.Medium,color)
class Marker(color:Color.Value) extends Item("Marker",Size.Large,color)

def showType(item:Item) ={
  item match{
    case p:Pen => "Pen"
    case p:Pencil => "Pencil"
    case m:Marker => "Marker"
  }
}

def showTypeByParam(item:Item, color: Color.Value) ={
  item match{
    case p:Pen => s"Pen of the color ${p.color}"
    case p:Pencil => "Pencil of the color ${p.color}"
    case m:Marker => "Marker of the color ${p.color}"
  }
}

def showTypesByParam (itemList:List[Item], color:Color.Value)={

  for(item <- itemList){
    item match{
      case p:Pen  if(p.color == color) => s"Pen of the color ${p.color}"
      case p:Pencil if(p.color == color) => "Pencil of the color ${p.color}"
      case m:Marker if(m.color == color) => "Marker of the color ${p.color}"
    }
  }
}

// Wl This is a very good example
abstract class Device
case class Phone(model: String) extends Device{
  def screenOff = "Turning screen off"
}
case class Computer(model: String) extends Device {
  def screenSaverOn = "Turning screen saver on..."
}

def goIdle(device: Device) = device match {
  case p: Phone => p.screenOff
  case c: Computer => c.screenSaverOn
}

goIdle(Phone("IPHONE"))
goIdle(Computer("Mac"))

//Wl I like the idea of sealed class being the base, ie all sub types must be in the same file
sealed abstract class Furniture
case class Couch() extends Furniture
case class Chair() extends Furniture

def findPlaceToSit(piece: Furniture): String = piece match {
  case a: Couch => "Lie on the couch"
  case b: Chair => "Sit on the chair"
}

findPlaceToSit(Couch())
findPlaceToSit(Chair())



