package InitialPractice.model.saleables.animals

import InitialPractice.model.saleables.Saleable

class SaleableAnimal (
                       age:Int,
                       size:AnimalSize.Value,
                       cost:BigDecimal,
                       discount:BigDecimal
                     ) extends Saleable(cost,discount){

}
