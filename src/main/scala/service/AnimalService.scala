package service

import InitialPractice.model._

object AnimalService{
  private val animalService:AnimalService = new AnimalService()
  def apply: AnimalService = animalService
}
class AnimalService {

  //Create a final constant of animal List just for this practice exercise to work on

  private val animalList :List[Animal]= {
    List(
      new Dog(name="Bob",size = AnimalSize.Big,age = 5),
      new Cat(name = "Puddy",size = AnimalSize.Medium,age = 3),
      new Mouse(name="Jerry",size = AnimalSize.Small,age = 1)
    )
  }

  def getBigSizedAnimals():List[Animal]={
    getAnimalBySize(AnimalSize.Big)

  }
  def getMediumSizedAnimals():List[Animal]={
    getAnimalBySize(AnimalSize.Medium)
  }
  def getSmallSizedAnimals():List[Animal]={
    getAnimalBySize(AnimalSize.Small)
  }

  private def getAnimalBySize(animalSize: AnimalSize.Value)={

    for {
      elem:Animal <- animalList
      if(elem.size.equals(animalSize))
    }yield elem

  }


}

