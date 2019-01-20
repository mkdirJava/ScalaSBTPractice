// This is used in abstract definitions like traits to take a class hierachy and use it

trait PersonAction{
  val helpMessage = "Help"
}

trait FireManAction{
  this : PersonAction =>
  def shoutForHelp = println(s"I am a fireman ${this.helpMessage}")
}

class FireMan extends PersonAction with FireManAction{
  shoutForHelp
}


