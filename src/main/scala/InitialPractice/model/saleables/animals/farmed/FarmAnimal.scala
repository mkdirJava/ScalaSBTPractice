package InitialPractice.model.saleables.animals.farmed

import InitialPractice.model.saleables.animals.{Animal, AnimalSize}

class FarmAnimal (
                   override val name:String,
                   override val age:Int,
                   override val size:AnimalSize.Value,
                   val price:BigDecimal
                 ) extends Animal(name = name,age=age,size = size){

}
