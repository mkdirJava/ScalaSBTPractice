import java.util.function.Predicate

import scala.collection.mutable.MutableList

case class Person(var name:String)

trait nextValue[Person] {
  def hasNext: Boolean
  def next: Person
}




class ConditionIterator (personList: List[Person],p: Predicate[Person]) extends nextValue[Person]{
  var counter= 0
  var validPersonIndices:MutableList[Int] = MutableList.empty

  for(i <- 0 until personList.length){
    if(p.test(personList(i)))
      validPersonIndices += i
  }


  override def hasNext: Boolean = {
    counter < validPersonIndices.length
  }

  override def next: Person = {
    val person = personList(validPersonIndices(counter))
    counter += 1
    person
  }


}

val personList = List(
  Person("TOM"),
  Person("Jerry"),
  Person("Kira"),
  Person("Maven")
)

val iter = new ConditionIterator(personList,item => {
  println(s""" the length of the name is ${item.name.length}""")
  item.name.length ==3
})



while(iter.hasNext){
  println(iter.next)
}