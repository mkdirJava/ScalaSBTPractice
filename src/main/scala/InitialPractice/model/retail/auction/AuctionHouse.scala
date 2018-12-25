package InitialPractice.model.retail.auction

import InitialPractice.model.person.{Buyer, Seller}

class AuctionHouse {

  val actioneer :Auctioneer = new Auctioneer()
  val buyers:List[Buyer]
  val sellers:List[Seller]

}
