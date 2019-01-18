

object MyStuff{
  private var _myStuff:List[String]=  List("Pencil","Pen","Calculator")

  def getMyStuff = _myStuff
  def giveAwayOneItem() = {
    val item = _myStuff(0)
    _myStuff = _myStuff.drop(1)
    item
  }
  def takeInOneItem( item:String)= _myStuff ::: List(item)
}

println(MyStuff.giveAwayOneItem())
println(MyStuff.getMyStuff)
MyStuff.takeInOneItem("DRUM")
println(MyStuff.getMyStuff)

//Companion Object

case class Item(name:String){
  import Item._
  def log = logItOut("I am here")

}

object Item{
  private def logItOut(message:String) = println(message)


}


// Wl I like this example mixes in pattern matching and companion class

class Email(val username: String, val domainName: String)

object Email {
  def fromString(emailString: String): Option[Email] = {
    emailString.split('@') match {
      case Array(a, b) => Some(new Email(a, b))
      case _ => None
    }
  }
}

val scalaCenterEmail = Email.fromString("scala.center@epfl.ch")
scalaCenterEmail match {
  case Some(email) => println(
    s"""Registered an email
       |Username: ${email.username}
       |Domain name: ${email.domainName}
     """)
  case None => println("Error: could not parse email")
}


