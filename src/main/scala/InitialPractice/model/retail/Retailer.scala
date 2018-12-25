package InitialPractice.model.retail

import java.time.LocalDateTime

import InitialPractice.model.person.{Buyer, Seller}
import InitialPractice.model.retail.basket.Basket
import InitialPractice.model.retail.transaction.exceptions.BuyerHasNotEnoughMoneyException
import InitialPractice.model.retail.transaction.{Transaction, TransactionLineNumber}
import InitialPractice.model.retail.transaction.ledger.SalesLedger
import InitialPractice.model.saleables.Saleable

trait Retailer {

  def makeTransaction(seller: Seller,buyer: Buyer,item:Saleable,basket:Basket,salesLedger: SalesLedger):Transaction ={
    val basketTotal = basket.items.foldLeft(0)(_+_)
    if(buyer.balance < basketTotal)
      throw new BuyerHasNotEnoughMoneyException(s"The Buyer ${buyer} has not enough funds for ${basketTotal}")

    val transactionLineNumbers = basket.items.map(
      item=>
        new TransactionLineNumber(buyer,seller,item._1,item._2,item._1.cost,LocalDateTime.now())).toList
    new Transaction(transactionLineNumbers)
  }

}
