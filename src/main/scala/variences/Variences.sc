class Foo[+A] // A covariant class
class Bar[-A] // A contravariant class
class Baz[A]  // An invariant class


//Covarience
// List is expressed as List[+A], it will accept the subtypes as the same.
// A extends B therefore the list expressions have also the same relationship, so it is a "is a" relationship
// by default generics are invariant ie no hierachy used to pass references
abstract class Animal {
  def name: String
}
case class Cat(name: String) extends Animal
class GingerCat(name:String) extends Cat(name)
case class Dog(name: String) extends Animal

class CovarienceContainer[A] (val item: A)

val catCovarienceContainer:CovarienceContainer[Cat] = new CovarienceContainer[Cat](Cat("Mickey"))
// This will not compile unless covarience is used ie +A in line 16 for its generic
// var copyCatContainer:CovarienceContainer[Animal] = catContainer
val dogCovarienceContainer:CovarienceContainer[Dog] = new CovarienceContainer[Dog](Dog("Pup"))

println(catCovarienceContainer.item)
println(dogCovarienceContainer.item)


//contravarience similar to covarience except when the
// generic type is used then in the container it is the opposite
// of the generic type  class hirachy
//ie given you have a generic instance you can ref it from the class
// but not the super

class ContravarienceContainer[-A](item:A)

val catContravarienceContainer: ContravarienceContainer[Cat]= new ContravarienceContainer[Cat](Cat("Jerry"))
// This does not work due to Animal is a super type reference but it is contravarience on Cat, cat is the
// hieghest ref it can be used
//val animalContravarienceContainer: ContravarienceContainer[Animal] = catContravarienceContainer
val gingerCatContravarienceContainer: ContravarienceContainer[GingerCat]= catContravarienceContainer
