package InitialPractice.model.company.role

import InitialPractice.model.retail.transaction.Transaction
import InitialPractice.model.saleables.Saleable

trait SellerAction {


  protected def doTransaction(seller:Seller,buyer: Buyer,saleItems:Map[Saleable,Int]):Transaction

  protected def performAction(seller:Seller,buyer: Buyer, saleItems:Map[Saleable,Int])

  protected def doAction(seller:Seller,buyer: Buyer, saleItems:Map[Saleable,Int])={
    println("Made Transaction")
    doTransaction(seller,buyer,saleItems)
    performAction(seller,buyer,saleItems)
  }

}
