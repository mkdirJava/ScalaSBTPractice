package InitialPractice.model.saleables.animals.farmed

import InitialPractice.model.saleables.animals.{Animal, AnimalSize, SaleableAnimal}

class FarmAnimal (
                   age:Int,
                   size:AnimalSize.Value,
                   cost:BigDecimal,
                   discount:BigDecimal
                 ) extends SaleableAnimal(age,size,cost,discount){

}
