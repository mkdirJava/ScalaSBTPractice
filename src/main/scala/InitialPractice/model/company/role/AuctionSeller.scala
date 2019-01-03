package InitialPractice.model.company.role

import InitialPractice.model.company.Company
import InitialPractice.model.saleables.animals.farmed.FarmAnimal

class AuctionSeller (firstName:String,
                     lastName:String,
                     id:String,
                     company: Company,
                     userName:String) extends Seller (firstName,lastName,id,company,userName) {
  type T = FarmAnimal
  type seller = AuctionSeller

}
