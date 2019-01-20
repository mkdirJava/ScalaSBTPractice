// When specifying the parameter, you might need to require it extend classes but also
// have it having some mixins.

trait Cloneable extends java.lang.Cloneable {
  override def clone(): Cloneable = {
    super.clone().asInstanceOf[Cloneable]
  }
}
trait Resetable {
  def reset: Unit
}

def cloneAndReset(obj: Cloneable with Resetable): Cloneable = {
  obj.reset
  obj.clone()
}
