package InitialPractice.model.retail.transaction

import java.time.LocalDateTime

import InitialPractice.model.person.{Buyer, Seller}
import InitialPractice.model.saleables.Saleable

class TransactionLineNumber(
                    val buyer:Buyer,
                    val seller: Seller,
                    val item:Saleable,
                    val quantity:Int,
                    val price:BigDecimal,
                    val transctionDate:LocalDateTime) {


}
