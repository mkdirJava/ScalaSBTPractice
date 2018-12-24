import org.scalatest.FunSuite
import InitialPractice.model.Cat
import InitialPractice.model.AnimalSize
import service.AnimalService

class InitialPracticeEntryTest extends FunSuite{



  def convertionFunction(num:Int): String ={
      print("I am in the converstion")
      println(num.toString())
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

}
