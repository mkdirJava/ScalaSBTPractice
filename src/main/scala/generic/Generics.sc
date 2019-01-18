class Dequeue[A] {
  private var elements: List[A] = Nil
  def push(x: A) { elements = x :: elements }
  def peek: A = elements.head
  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
  def next()={
    val nextOne = elements(0)
    elements = elements.drop(1)
    nextOne
  }
}

case class Person (name:String, age:Int)


val personDequeue:Dequeue[Person]= new Dequeue[Person]

personDequeue.push(Person("RHCP",34))
personDequeue.push(Person("Baby",2))
personDequeue.push(Person("Force",999999))

println(personDequeue.pop())
println(personDequeue.next())