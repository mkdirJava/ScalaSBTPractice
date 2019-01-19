abstract class Animal {
  def name: String
}

abstract class Pet extends Animal {}

class Cat extends Pet {
  override def name: String = "Cat"
}

class Dog extends Pet {
  override def name: String = "Dog"
}

class Lion extends Animal {
  override def name: String = "Lion"
}


//Wl Upper type bound. This generic statement says P must extend Pet
class PetContainer[P <: Pet](p: P) {
  def pet: P = p
}
//Wl Upper type bound. This generic statement says P must be a superClass of lion
class NotPetContainer[P >: Lion](p: P) {
  def pet: P = p
}

val dogContainer = new PetContainer[Dog](new Dog)
val catContainer = new PetContainer[Cat](new Cat)