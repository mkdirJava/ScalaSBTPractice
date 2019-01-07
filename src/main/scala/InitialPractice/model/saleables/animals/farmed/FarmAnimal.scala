package InitialPractice.model.saleables.animals.farmed

import InitialPractice.model.saleables.animals.{Animal, AnimalSize, SaleableAnimal}

case class FarmAnimal(
                   age:Int,
                   size:AnimalSize.Value,
                   override val cost:BigDecimal
                 ) extends SaleableAnimal(age,size,cost){

}
