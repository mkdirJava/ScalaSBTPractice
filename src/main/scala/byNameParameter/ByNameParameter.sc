// this is where an expression is used, most likley to control process flow,
// the expression is only evaluated when used. this can be a good thing for performance
// very much using the callback / functions passed in to orchastrate a response

def whileLoop(condition: => Boolean)(body: => Unit): Unit =
  if (condition) {
    body
    whileLoop(condition)(body)
  }

var i = 2

whileLoop (i > 0) {
  println(i)
  i -= 1
}  // prints 2 1


