import org.scalatest.FunSuite
import InitialPractice.model.{Animal, AnimalSize, Cat}
import service.AnimalService

class InitialPracticeEntryTest extends FunSuite{



  def convertionFunction(num:Int): String ={
    num.toString()

  }

  test("doSomthingWithAFunction"){


    InitialPracticeEntry.doSomethingWithAFunction(func = convertionFunction)

    //assert(
     // Example.doSomthingWithAFunction(func = doSomthingWithAFunctionFunction
      //).equals(Example.num.toString),"Something is wrong with the function")
  };

  test("getLargeAnimals"){
    for (elem <- AnimalService.apply.getBigSizedAnimals()) {
      assert(elem.size.equals(AnimalSize.Big))
    }
  }
  test ("getMediumAnimals"){
    for( elem <- AnimalService.apply.getMediumSizedAnimals()){
      assert(elem.size.equals(AnimalSize.Medium))
    }
  }
  test ("getSmallAnimals"){
    for( elem <- AnimalService.apply.getSmallSizedAnimals()){
      assert(elem.size.equals(AnimalSize.Small))
    }
  }

  test("SortedAnimalAge"){
    val sorted = AnimalService.apply.animalList.sortBy((item)=> item.age)
    println(sorted)
    print(AnimalService.apply.animalList.sortWith((x,y)=>{x.age > y.age}))

    //assert(sorted(0).age < sorted(sorted.length-1).age,"The first age is not less than last, sorted not working")
  }
}
