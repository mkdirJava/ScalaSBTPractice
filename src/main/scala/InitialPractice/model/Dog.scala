package InitialPractice.model

class Dog(override val name:String,override  val size:AnimalSize.Value, override val age:Int) extends Animal(name,size ,age ) {

}
