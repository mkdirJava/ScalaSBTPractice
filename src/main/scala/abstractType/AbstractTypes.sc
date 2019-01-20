// this is like generics but not in param form and defined in the concrete implementation

trait thing {
  type T
  val item:T
}

// contravarience and covarient and invariant applies

trait thing2[T]{
  val item:T
}


