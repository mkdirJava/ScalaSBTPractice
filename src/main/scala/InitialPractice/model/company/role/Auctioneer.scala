package InitialPractice.model.company.role

import InitialPractice.model.company.Company
import InitialPractice.model.retail.transaction.exceptions.InvalidNewQuantityException
import InitialPractice.model.saleables.Saleable

import scala.collection.mutable.MutableList

abstract class Auctioneer(firstName:String,
                  lastName:String,
                  id:String,
                  company: Company,
                  userName:String) extends Seller(firstName,lastName,id,company,userName) with MiddleRetailer {

  def conductAuction(sellerList:MutableList[AuctionSeller], buyerList:MutableList[AuctionBuyer])
}

