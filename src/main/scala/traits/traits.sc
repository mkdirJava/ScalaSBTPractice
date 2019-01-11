import java.util.function.Predicate


case class Person(var name:String)

trait nextValue[Person] {
  def hasNext: Boolean
  def next: Person
}




class ConditionIterator (personList: List[Person],p: Predicate[Person]) extends nextValue[Person]{
  var counter:Int= 0

  override def hasNext: Boolean = {

    var hasMore:Boolean = false
    for(i <- counter until personList.length){
      if(!hasMore && p.test(personList(i) )){
        counter = i
        hasMore = true
      }
    }
    hasMore
  }

  override def next: Person = {
    val person = personList(counter)
    counter +=1
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
  item.name.length == 3
})



while(iter.hasNext){
  println(iter.next)
}