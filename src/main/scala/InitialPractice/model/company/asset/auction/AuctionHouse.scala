package InitialPractice.model.company.asset.auction

import InitialPractice.model.company.asset.Venue
import InitialPractice.model.company.role.{Auctioneer, Buyer, Seller}

class AuctionHouse(value:BigDecimal,id:Int,var auctioneer:Auctioneer) extends Venue(value,id) with AuctionAction{

  var buyerList:List[Buyer] = List.empty
  var sellerList:List[Seller] = List.empty

  def init(): Unit ={
    this.sellerList.foreach(item=>{
      item.
    })
  }

}
