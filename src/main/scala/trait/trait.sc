import java.util.function.Predicate

case class Person(var name:String)

trait nextValue[Person] {
  def hasNext(): Boolean
  def next(): Person
}




class ConditionIterator (personList: List[Person],p: Predicate[Person]) extends nextValue[Person]{
  var counter= 0;
  override def hasNext(): Boolean = {

    if(counter < personList.length){

      val person = personList(counter)


      val hasNext = p.test(person)
      if(hasNext)
        counter +=1
      hasNext

    }


  }

  override def next(): Person = {
    personList(counter)
  }
}

val personList = List(
  Person("TOM"),
  Person("Jerry"),
  Person("Kira"),
  Person("Maven")
)

val iter = new ConditionIterator(personList,(item => item.name.length > 2))



while(iter.hasNext()){
  println(iter.next())
}