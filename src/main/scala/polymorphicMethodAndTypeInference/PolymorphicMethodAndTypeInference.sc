// This is where the types are infered, short hand very much concise but can leave typing a guessing game

val number =1

val listOfNumbers = List(1,2,3)

def listOfDuplicates[A](x: A, length: Int): List[A] = {
  if (length < 1)
    Nil
  else
    x :: listOfDuplicates(x, length - 1)
}
println(listOfDuplicates[Int](3, 4))
println(listOfDuplicates("La", 8))