package InitialPractice.model.retail

import java.time.LocalDateTime

import InitialPractice.model.company.role.{Buyer, Seller, ServiceProvider}
import InitialPractice.model.retail.basket.Basket
import InitialPractice.model.retail.transaction.exceptions.{BuyerHasNotEnoughMoneyException, TransactionException}
import InitialPractice.model.retail.transaction.{Receipt, Transaction, TransactionLineNumber}
import InitialPractice.model.retail.transaction.ledger.Ledger
import InitialPractice.model.saleables.Saleable

trait MiddleRetailer {
  this:ServiceProvider =>

  def makeTransaction(seller: Seller,buyer: Buyer,item:Saleable,basket:Basket,salesLedger: Ledger)={

    val basketTotal = basket.items.map(saleItem=>saleItem._1.cost * saleItem._2).sum
    if(buyer.company.balance < basketTotal)
      throw new BuyerHasNotEnoughMoneyException(s"The Buyer ${buyer} has not enough funds for ${basketTotal}")

    try{
      buyer.company.balance -= basketTotal
      this.company.balance += basketTotal
      val transactionDateTime = LocalDateTime.now()
      val transactionLineNumbers = basket.items.map(
        item=>
          new TransactionLineNumber(buyer,this,item._1,item._2,item._1.cost)).toList

      val transaction:Transaction = new Transaction(transactionLineNumbers,transactionDateTime)
      buyer.company.receiptList :+ new Receipt( seller = this,price = basketTotal, transaction = transaction,date = transactionDateTime)
      this.company.invoiceList :+ new Receipt( seller = this,price = basketTotal, transaction = transaction,date = transactionDateTime)
      transaction

    }catch{
      case exception:Exception =>
        throw new TransactionException(s"Something went wrong in the transaction :${exception.getMessage()}")
    }

  }

}
