package InitialPractice.model.saleables.animals.farmed

import InitialPractice.model.saleables.animals.AnimalSize

class Cow(age:Int,cost:BigDecimal, discount:BigDecimal) extends FarmAnimal(age,AnimalSize.Big,cost,discount) {
}
