package InitialPractice.model.company.asset.auction

trait AuctionAction extends AuctionHouse {

  def displayAuction(): Unit ={
    //Auction is about to begin
  }

  def takebids(): Unit ={
   //Auction is taking bids
  }

  def makeTransaction(): Unit ={
    //Auction closed on item
  }

}
