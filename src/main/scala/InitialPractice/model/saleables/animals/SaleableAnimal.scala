package InitialPractice.model.saleables.animals

import InitialPractice.model.saleables.Saleable

class SaleableAnimal (
                       age:Int,
                       size:AnimalSize.Value,
                       cost:BigDecimal
                     ) extends Saleable(cost){

}
