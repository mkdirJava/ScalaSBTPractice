import scala.util.Random
import scala.util.matching.Regex


//Wl An extractor object is one with an unapply method. Unapply will take an object and give back its constructor param
// the param then can be used as normal ones



import scala.util.Random

object CustomerID {

  def apply(name: String) = s"$name--${Random.nextLong}"

  def unapply(customerID: String): Option[String] = {
    val stringArray: Array[String] = customerID.split("--")
    if (customerID.contains("--") && stringArray.tail.nonEmpty) Some(stringArray.head) else None
  }
}


val customer1ID = CustomerID("Sukyoung")  // Sukyoung--23098234908
customer1ID match {
  case CustomerID(name) => println(name)  // prints Sukyoung
  case _ => println("Could not extract a CustomerID")
}

//Wl Line 18 is calling the unapply function, looks like the context of doing pattern matching will cause the unapply to be used
// Extractor methods, interesting as it inverses the left and right side of the = operator

val customer2ID = CustomerID("Nico")
val CustomerID(name) = customer2ID
println(name)  // prints Nico

val CustomerID(name2) = CustomerID("Timmy")
println(name2)

val name3 = CustomerID.unapply(CustomerID("HOME")).get
println(name3)

val CustomerID(name4) = "--asdfasdfasdf"


// Rule for the return values,
//Test return boolean
// single param then return Option[T]
// Many param then return Option [(T,S,U)]