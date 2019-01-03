package InitialPractice.model.company.role

import InitialPractice.model.saleables.animals.Animal

class Farmer(
              firstName:String,
              lastName:String,
              id:String
              ) extends Person(firstName,lastName,id){
  var herd:Map[Animal,Int]= Map.empty
}
