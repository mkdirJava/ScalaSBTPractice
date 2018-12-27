package InitialPractice.model.company.asset.auction

import InitialPractice.model.company.asset.Venue
import InitialPractice.model.company.role._

class AuctionHouse(value:BigDecimal,id:Int,var auctioneer:Auctioneer) extends Venue(value,id) with AuctionAction{

  var buyerList:List[AuctionBuyer] = List.empty
  var sellerList:List[AuctionSeller] = List.empty

}
