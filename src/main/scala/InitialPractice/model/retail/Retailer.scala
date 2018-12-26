package InitialPractice.model.retail

import java.time.LocalDateTime

import InitialPractice.model.person.{Buyer, Seller}
import InitialPractice.model.retail.basket.Basket
import InitialPractice.model.retail.transaction.exceptions.{BuyerHasNotEnoughMoneyException, TransactionException}
import InitialPractice.model.retail.transaction.{Receipt, Transaction, TransactionLineNumber}
import InitialPractice.model.retail.transaction.ledger.SalesLedger
import InitialPractice.model.saleables.Saleable

trait Retailer {

  def makeTransaction(seller: Seller,buyer: Buyer,item:Saleable,basket:Basket,salesLedger: SalesLedger)={

    val basketTotal = basket.items.map(saleItem=>saleItem._1.cost * saleItem._2).sum
    if(buyer.balance < basketTotal)
      throw new BuyerHasNotEnoughMoneyException(s"The Buyer ${buyer} has not enough funds for ${basketTotal}")

    try{
      buyer.balance -= basketTotal
      seller.balance += basketTotal
      val transactionDateTime = LocalDateTime.now()
      val transactionLineNumbers = basket.items.map(
        item=>
          new TransactionLineNumber(buyer,seller,item._1,item._2,item._1.cost)).toList

      val transaction:Transaction = new Transaction(transactionLineNumbers,transactionDateTime)
      buyer.receiptList :+ new Receipt( seller = seller,price = basketTotal, transaction = transaction,date = transactionDateTime)
      seller.invoiceList :+ new Receipt( seller = seller,price = basketTotal, transaction = transaction,date = transactionDateTime)
      transaction

    }catch{
      case exception:Exception =>
        throw new TransactionException(s"Something went wrong in the transaction :${exception.getMessage()}")
    }

  }

}
