package InitialPractice

object InitialPracticeEntry extends App {


  def doSomethingWithAFunction[ A >: Int](func : A => String ) = {
    println("Going to do something with a function")

    val converted = for (num <- 1 to 10) yield {
      func(num)
      num
    }

  println("Finished doing somthing with a function")
    converted
  }


}
