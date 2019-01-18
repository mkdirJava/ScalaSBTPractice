
// Wl have done some of this anyways:
// The syntax is
// for (enumerators) yeild e
// enumerator is either a generator or a filter


case class Person (name:String, age: Int)

val people = List(Person("Tim",2),Person("Gemma",12),Person("Robin",52),Person("Batman",34))

val peopleOver10 = for(person <- people
if person.age >10
) yield person.name

println(peopleOver10)

for (num1 <- 0 until 10;
     num2 <- num1 until 10 )
  yield print (num1, num2)

people.withFilter(person => person.age>30).foreach(person => println(person))

