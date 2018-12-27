package InitialPractice.model.company.role

import InitialPractice.model.company.Company
import InitialPractice.model.saleables.Saleable

class Buyer (firstName:String,
             lastName:String,
             id:String,
             company: Company) extends Employee (firstName,lastName,id,company){

     var boughtItems:List[Saleable] = List.empty


}
