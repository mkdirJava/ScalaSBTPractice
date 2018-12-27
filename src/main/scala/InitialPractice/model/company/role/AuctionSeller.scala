package InitialPractice.model.company.role

import InitialPractice.model.company.Company
import InitialPractice.model.saleables.Saleable

class AuctionSeller (firstName:String,
                     lastName:String,
                     id:String, company: Company) extends Seller (firstName,lastName,id,company) {

  var soldItems: List[Saleable] = List.empty
}
