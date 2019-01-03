package InitialPractice.model.saleables.animals.pet

import InitialPractice.model.saleables.animals.{Animal, AnimalSize}

class Dog(var name:String,override  val size:AnimalSize.Value, override val age:Int) extends Animal(size ,age ) {

}
