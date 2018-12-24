import InitialPractice.model.Animal
import service.AnimalService

val animalList:List[Animal]= AnimalService.apply.getBigSizedAnimals()
println(animalList)