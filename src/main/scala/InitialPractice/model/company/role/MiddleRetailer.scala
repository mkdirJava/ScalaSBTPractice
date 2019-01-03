package InitialPractice.model.company.role

import java.time.LocalDateTime

import InitialPractice.model.retail.transaction.{Invoice, Receipt, Transaction, TransactionLineNumber}
import InitialPractice.model.retail.transaction.exceptions.{ActionException, BuyerHasNotEnoughMoneyException, TransactionException}
import InitialPractice.model.saleables.Saleable

trait MiddleRetailer extends SellerAction {
  this:Seller=>

  @throws(classOf[BuyerHasNotEnoughMoneyException])
  protected def doTransaction(seller:Seller,buyer: Buyer,saleItems:Map[Saleable,Int])={

    val basketTotal = saleItems.map(saleItem=>saleItem._1.cost * saleItem._2).sum
    if(buyer.company.balance < basketTotal)
      throw new BuyerHasNotEnoughMoneyException(s"The Buyer ${buyer} has not enough funds for ${basketTotal}")
    try{
      buyer.company.balance -= basketTotal
      seller.company.balance += basketTotal
      val transactionDateTime = LocalDateTime.now()

      //Create the transaction between the buyer and the seller
      val buyerSellerTransactionLineNumbers = saleItems.map(
        item=>
          new TransactionLineNumber(buyer,this,item._1,item._2,item._1.cost)).toList

      val buyerSellerTransaction:Transaction = new Transaction(buyerSellerTransactionLineNumbers,transactionDateTime)
      buyer.company.receiptList :+  Receipt( seller,seller.company,price = basketTotal, transaction = buyerSellerTransaction,date = transactionDateTime)
      seller.company.invoiceList :+ Invoice( buyer,buyer.company,price = basketTotal, transaction = buyerSellerTransaction,date = transactionDateTime)

      //Create the transaction between the seller and the serviceProvider
      val sellerServiceTransactionLineNumbers = saleItems.map(
        item=>
          new TransactionLineNumber(seller,this,item._1,item._2,item._1.cost)).toList

      val sellerServiceTransaction:Transaction = new Transaction(sellerServiceTransactionLineNumbers,transactionDateTime)
      this.company.invoiceList :+  Invoice( seller,seller.company,price = basketTotal, transaction = sellerServiceTransaction,date = transactionDateTime)
      seller.company.receiptList:+  Receipt( this,this.company,price = basketTotal, transaction = sellerServiceTransaction,date = transactionDateTime)


      buyerSellerTransaction

    }catch{
      case exception:Exception =>
        throw new TransactionException(s"Something went wrong in the transaction :${exception.getMessage()}")
    }
  }



}
