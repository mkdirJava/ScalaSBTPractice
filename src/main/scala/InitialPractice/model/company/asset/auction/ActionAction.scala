package InitialPractice.model.company.asset.auction

import java.util.Optional

import InitialPractice.model.company.role.{AuctionBuyer, AuctionSeller, Buyer, Seller}
import InitialPractice.model.retail.transaction.exceptions.TransactionException
import InitialPractice.model.saleables.Saleable

trait AuctionAction {
  this:AuctionHouse =>

  var auctionBids:Map[AuctionBuyer,Optional[BigDecimal]]= Map.empty

  def conductAuction() = synchronized{
    this.sellerList.flatMap(seller=>seller.saleableItems)
      .foreach(
        saleableItem =>{
          val buyerBid = this.takeBids(saleableItem._1)
          try{
            this.makeTransaction(saleableItem._1.seller,buyerBid._1,Map.apply(saleableItem))
          }catch {
            case e: TransactionException => println(s"cannot do transaction with ${buyerBid._1}")
          }
          auctionBids = Map.empty
        })
  }

  private def isMoreThanOneBid() ={
    this.auctionBids.map(bids=>bids._2).count(bid=>bid.isPresent) > 1
  }
  private def takeBids(saleable: Saleable) = synchronized{
    var highestBid:(AuctionBuyer,BigDecimal) = null;
    this.buyerList.foreach(buyer=> this.auctionBids + (buyer ->buyer.placeBid(saleable)))

    while(isMoreThanOneBid()){
      highestBid = this.auctionBids.filter(bid=>bid._2.isPresent)
        .map(bid=>(bid._1,bid._2.get()))
        .maxBy(bid=>bid._2)
      this.auctionBids = Map.empty
      this.buyerList.foreach(buyer=> this.auctionBids + (buyer -> buyer.rebid(saleable,highestBid)))
    }

    highestBid

  }

  private def makeTransaction(seller: Seller,buyer: Buyer,saleItems: Map[Saleable,Int])= synchronized{
    try{
      this.auctioneer.makeTransaction(seller,buyer,saleItems)
    }catch{
      case e: TransactionException => println(s"Cannot conduct transaction exception of ${e.getMessage()}")
    }

  }

  def registerSeller(auctionSeller: AuctionSeller)={
    this.sellerList :+ auctionSeller

  }

  def registerBuyer(auctionBuyer: AuctionBuyer)={
      this.buyerList :+ auctionBuyer
    auctionBuyer.registeredAuctionHouse(this)
  }

}
