import scala.util.matching.Regex

val numberPattern: Regex = "[0-9]".r

numberPattern.findFirstMatchIn("awesomepassword") match {
  case Some(_) => println("Password OK")
  case None => println("Password must contain a number")
}

val onlyNumberPattern: Regex = "^[0-9]+$".r

def stringOnlyNumbers(message:String) ={
  onlyNumberPattern.findFirstMatchIn(message) match {
    case Some(item)=> println(s"There are only numbers ${item} ")
    case None => println(s"There are more than numbers")
  }
}

stringOnlyNumbers("op22")
stringOnlyNumbers("22343")


// Wl: I like this one, the regex stripping on iteration, however it also could be done via splitting
// on ':'

val keyValPattern: Regex = "([0-9a-zA-Z-#() ]+): ([0-9a-zA-Z-#() ]+)".r

val input: String =
  """background-color: #A03300;
    |background-image: url(img/header100.png);
    |background-position: top center;
    |background-repeat: repeat-x;
    |background-size: 2160px 108px;
    |margin: 0;
    |height: 108px;
    |width: 100%;""".stripMargin

for (patternMatch <- keyValPattern.findAllMatchIn(input))
  println(s"key: ${patternMatch.group(1)} value: ${patternMatch.group(2)}")