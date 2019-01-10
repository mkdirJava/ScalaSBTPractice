import InitialPractice.model.saleables.animals.Animal
import InitialPractice.service.AnimalService

val animalList:List[Animal]= AnimalService.apply.getBigSizedAnimals()
println(animalList)