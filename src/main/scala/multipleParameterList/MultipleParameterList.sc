import scala.concurrent.ExecutionContext

def doSomthing[A](listA:List[A])(op: (A,A)=>A) ={
  listA.foreach(item=> {
    println(op(item,item))
    op(item,item)

  })
}

doSomthing(List(1,2,3,4))((a,b)=> a * b)
doSomthing(List(1,2,3,4))(_+_)


val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//numbers.foldLeft(0, {(m: Int, n: Int) => m + n})
numbers.foldLeft(0)(_ + _)
numbers.foldRight(0)((a,b)=>a + b)




val numberFunc = numbers.foldLeft(List[Int]())_

val squares = numberFunc((xs, x) => xs:+ x*x)
print(squares.toString()) // List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

val cubes = numberFunc((xs, x) => xs:+ x*x*x)
print(cubes.toString())



def execute(arg: Int)(implicit ec: ExecutionContext) = ???