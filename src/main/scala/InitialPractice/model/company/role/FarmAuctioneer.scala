package InitialPractice.model.company.role

import java.util.Optional

import InitialPractice.model.company.Company
import InitialPractice.model.retail.transaction.exceptions.{InvalidNewQuantityException, TransactionException}
import InitialPractice.model.saleables.Saleable

import scala.collection.mutable.MutableList

class FarmAuctioneer(firstName:String,
                     lastName:String,
                     id:String,
                     company: Company,
                     userName:String) extends Auctioneer (firstName,lastName,id,company,userName) with MiddleRetailer{

  override def conductAuction(sellerList:MutableList[AuctionSeller],buyerList:MutableList[AuctionBuyer]): Unit ={

    var auctionBids:Map[AuctionBuyer,Optional[BigDecimal]]= Map.empty
    sellerList.map(seller => (seller -> seller.saleableItems))
      .foreach(
        sellerToSaleables =>{
          sellerToSaleables._2.foreach(saleableItem =>{
            val buyerBid = this.takeBids(saleableItem._1,buyerList)
            try{
              doTransaction(sellerToSaleables._1,buyerBid._1,Map.apply(saleableItem))
            }catch {
              case e: TransactionException => println(s"cannot do transaction with ${buyerBid._1}, issue of : ${e.getMessage()}")
            }
            auctionBids = Map.empty
          })
        })
  }

  @throws(classOf[InvalidNewQuantityException])
  override protected def performAction(seller: Seller,buyer: Buyer, saleItems:Map[Saleable,Int]):Unit={

    saleItems.keySet.intersect(seller.saleableItems.keySet)
      .foreach(saleable => {
        if (seller.saleableItems(saleable) - saleItems(saleable) < 0)
          throw InvalidNewQuantityException(s"There is not enough in the transaction " +
            s"from buyer to seller." +
            s"Seller quantity ${seller.saleableItems(saleable)}" +
            s"Buyer quantity ${saleItems(saleable)}")

        if(seller.saleableItems(saleable) - saleItems(saleable) == 0 ){
          seller.saleableItems -= saleable
        }else{
          seller.saleableItems.updated(saleable,seller.saleableItems(saleable) - saleItems(saleable))
        }
        buyer.boughtItems.updated(saleable , seller.saleableItems(saleable) - saleItems(saleable))
      })
  }


  private def takeBids(saleable: Saleable, buyerList:MutableList[AuctionBuyer]) = synchronized{
    var highestBid:(AuctionBuyer,BigDecimal) = null;
    var auctionBids:Map[AuctionBuyer,Optional[BigDecimal]]= Map.empty
    buyerList.foreach(buyer=> auctionBids += (buyer ->buyer.placeBid(saleable)))

    while(isMoreThanOneBid(auctionBids)){
      highestBid = auctionBids.filter(bid=>bid._2.isPresent())
        .map(bid=>(bid._1,bid._2.get()))
        .maxBy(bid=>bid._2)
      auctionBids = Map.empty
      buyerList.foreach(buyer=> auctionBids + (buyer -> (buyer,buyer.rebid(saleable,highestBid))))
    }
    highestBid
  }
  private def isMoreThanOneBid(auctionBids:Map[AuctionBuyer,Optional[BigDecimal]]) ={
    auctionBids.map(bids=>bids._2).count(bid=>bid.isPresent) > 1
  }

}
