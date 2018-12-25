package InitialPractice.model.saleables.animals.farmed

import InitialPractice.model.saleables.animals.AnimalSize

class Cow(name:String,age:Int,price:BigDecimal) extends FarmAnimal(name,age,AnimalSize.Big,price) {
}
