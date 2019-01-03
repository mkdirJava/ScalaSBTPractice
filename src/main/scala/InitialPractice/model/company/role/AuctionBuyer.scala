package InitialPractice.model.company.role

import java.util.Optional

import InitialPractice.model.company.Company
import InitialPractice.model.company.asset.auction.AuctionHouse
import InitialPractice.model.saleables.Saleable

import scala.util.Random

class AuctionBuyer (firstName:String,
                    lastName:String,
                    id:String,
                    company: Company,
                    userName:String) extends Buyer(firstName,lastName,id,company,userName) {
  this:Employee=>

  var currentBid :BigDecimal = null;
  var registeredAuctionHouse:AuctionHouse = null

  def rebid(saleable: Saleable, highestBid: (AuctionBuyer, BigDecimal)) ={
    if(highestBid._2 * 2 > currentBid){
      placeBid(saleable)
    }else{
      Optional.empty()
    }

  }

  def placeBid(saleable: Saleable)={
    val random:Random = new Random()
    currentBid = BigDecimal.apply(random.nextDouble())
    println(s"my name is ${this.firstName} from ${this.company} I am bidding ${currentBid}")
    Optional.of(currentBid)

  }

  def registerAuctionHouse(auctionHouse: AuctionHouse): Unit ={
    this.registeredAuctionHouse = auctionHouse
  }


}
