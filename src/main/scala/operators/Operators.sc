// Operators are methods:
// infix operator, just without the . , this is used for one parameter methods


case class Vec(val x: Double, val y: Double) {
  def +(that: Vec) = new Vec(this.x + that.x, this.y + that.y)
}

val vector1 = Vec(1.0, 1.0)
val vector2 = Vec(2.0, 2.0)

val vector3 = vector1 + vector2
vector3.x  // 3.0
vector3.y  // 3.0

// It can get compicated, I seem to remember that Kotlin only allows for overriding s set of operators but not
// define them
case class MyBool(x: Boolean) {
  def and(that: MyBool): MyBool = if (x) that else this
  def or(that: MyBool): MyBool = if (x) this else that
  def negate: MyBool = MyBool(!x)
}

//Precedence

/*
(characters not shown below)
* / %
+ -
  :
= !
  < >
  &
^
|
(all letters)
*/
