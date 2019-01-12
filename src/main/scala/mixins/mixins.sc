abstract class Vehicle(){
  var numberOfWheels:Int
}


class Car () extends Vehicle{
  override var numberOfWheels = 4
}

trait CarSound extends Vehicle{
  def makeCarSound = s"""Screeching of ${numberOfWheels} on the ground"""
}


class BMW extends Car with CarSound {

}


println(new BMW().makeCarSound)

