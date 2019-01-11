
case class Address (val firstLine:String, val SecondLine:String, val postCode:String)

class Person( name:String, age:Int = 0, address: Address ){

  private var _secretMessage:String = "jo"

  def secretMessage = _secretMessage
  def secretMessage_= (newValue:String){
    if(newValue.length < 2){
      _secretMessage = newValue
      println("Set the secret message")
    }else{
      printErrorMessage()
    }
  }
  def printErrorMessage()= println("The message is Too Long")

  override def toString():String={
    s"""
    name ${name}
    age ${age}
    address ${address}
       secretMessage ${_secretMessage}
    """
  }
}

val person = new Person("Todd",22, Address("99","Stated Road","Ba12 1PT"))
person.secretMessage= "Homeis Here"
println(person)
person.secretMessage= "O"

println(person)
