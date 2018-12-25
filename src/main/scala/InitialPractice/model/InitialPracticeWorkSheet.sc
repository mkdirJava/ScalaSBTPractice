import InitialPractice.model.saleables.animals.Animal
import service.AnimalService

val animalList:List[Animal]= AnimalService.apply.getBigSizedAnimals()
println(animalList)