import java.util.function.BiFunction

val range = 1 to 10
println(range.map(_*2))
/*
Higher order functions, to accept a function as an arguement
or produce a function as a return

In Java 8 the Stream API, you are able to do this

BiFunction<Integer,Integer,Integer> func = (i,o) ->{return i*o}

private doSomthing(BiFunction<Integer,Integer,Integer> func, List<Integer> nums){
  nums.stream.foreach(num ->
    func.apply(2,num)
  )

}
 */


object rentUtil{

  private def increaseRent(rent:BigDecimal,increaseFunction: BigDecimal => BigDecimal): BigDecimal ={
    increaseFunction(rent)
  }

  def doubleIncrease(rent:BigDecimal) = increaseRent(rent,r=> r * 2)
  def oneIncrease(rent:BigDecimal)= increaseRent(rent, r=> r +1)

}


println(rentUtil.doubleIncrease(BigDecimal(50)))
println(rentUtil.oneIncrease(BigDecimal(50)))


def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
  val schema = if (ssl) "https://" else "http://"
  (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
}

val domainName = "www.example.com"
def getURL = urlBuilder(ssl=true, domainName)
val endpoint = "users"
val query = "id=1"
val url = getURL(endpoint, query)








