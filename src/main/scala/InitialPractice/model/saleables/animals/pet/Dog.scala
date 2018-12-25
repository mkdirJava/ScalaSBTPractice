package InitialPractice.model.saleables.animals.pet

import InitialPractice.model.saleables.animals.{Animal, AnimalSize}

class Dog(override val name:String,override  val size:AnimalSize.Value, override val age:Int) extends Animal(name,size ,age ) {

}
