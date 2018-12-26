package InitialPractice.model.retail.transaction

import java.time.LocalDateTime

import InitialPractice.model.company.role.Seller
import InitialPractice.model.person.Buyer
import InitialPractice.model.saleables.Saleable

class TransactionLineNumber(
                    val buyer:Buyer,
                    val seller: Seller,
                    val item:Saleable,
                    val quantity:Int,
                    val price:BigDecimal,
                    ) {


}
