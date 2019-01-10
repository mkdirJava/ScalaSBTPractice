import java.util.stream.IntStream

import com.sun.xml.internal.ws.addressing.v200408.MemberSubmissionWsaServerTube

print(1)
print(1+1)
println("Hi There world")
val functionMethod = (x:Int)=> x*x
def message = {
  println({
    var item = 2 * 2
    "Why am I Here? " + "This is not the end"+
    s"""adding result ${functionMethod(item)}"""
  })
}

message

def printSystemInfo()={
  System.getProperties.forEach((k, v) => println(s"""${k} -> ${v}"""))
}
printSystemInfo()

class PracticeClass (){
  def saySomthing(): Unit ={
    println("Say something, I'm looking out for you")
  }
}

new PracticeClass().saySomthing()

case class MessengerofMissery(message:String ){
}
println(MessengerofMissery("TODAY IS MONDAY!!!"))

val message1 = MessengerofMissery("HOMEISFAR")
val message2 = MessengerofMissery("TIME TO GO BACK")
val message3 = MessengerofMissery("HOMEISFAR")
val message4 = MessengerofMissery("ITS COLD")

if(message1.eq(message1))
  println("ITS THE SAME")
if(message1.equals(message3))
  println("ITS THE SAME VAlue but not object")
if(message1 == message3)
  println("ITS THE SAME ")
if(!message2.eq(message1))
  println("They are not the same")

object YesIKnowTheyAreStatic{
  private var mutableItem:Int = 0
  def create:Int= {
    mutableItem +=1
    mutableItem
  }

}

Seq.range(1,10,1)
println(YesIKnowTheyAreStatic.create)



