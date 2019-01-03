package InitialPractice.model.company.role

import InitialPractice.model.company.Company
import InitialPractice.model.saleables.Saleable


class Seller (firstName:String,
              lastName:String,
              id:String,
              company: Company,
              userName:String) extends Employee(firstName,lastName,id,company,userName) {

  var saleableItems:Map[Saleable, Int] = Map.empty
  var soldItems: Map[Saleable, Int] = Map.empty

}
