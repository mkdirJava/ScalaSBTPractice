package InitialPractice.model.company.asset.auction

import java.util.Optional

import InitialPractice.model.company.role._

trait AuctionAction {
  this:AuctionHouse =>

  def conductAuction() = synchronized{
    this.auctioneer.conductAuction(this.sellerList,this.buyerList)
    println("Finished auction")
  }

  def registerSeller(auctionSeller: AuctionSeller)={
    this.sellerList += auctionSeller

  }

  def registerBuyer(auctionBuyer: AuctionBuyer)={
      this.buyerList += auctionBuyer
    auctionBuyer.registerAuctionHouse(this)
  }

  def switchAuctioneer(auctioneer: Auctioneer): Unit ={
    this.auctioneer = auctioneer
  }


}
