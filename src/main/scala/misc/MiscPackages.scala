
class Entry extends App{
  import users.administrators._
  val user : NormalUser = new NormalUser
  user.saySomthing
}

package users {
  package administrators {
    class NormalUser(){
      def saySomthing = println("Hi there ")
    }
  }
  package normalusers {
    class NormalUser
  }
}

