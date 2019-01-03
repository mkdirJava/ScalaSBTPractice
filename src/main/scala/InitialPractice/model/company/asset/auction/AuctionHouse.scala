package InitialPractice.model.company.asset.auction

import InitialPractice.model.company.asset.Venue
import InitialPractice.model.company.role._

import scala.collection.mutable.MutableList

class AuctionHouse(id:Long, value:BigDecimal,var auctioneer: Auctioneer) extends Venue(value,id) with AuctionAction{

  var buyerList:MutableList[AuctionBuyer] = MutableList.empty
  var sellerList:MutableList[AuctionSeller] = MutableList.empty

}
