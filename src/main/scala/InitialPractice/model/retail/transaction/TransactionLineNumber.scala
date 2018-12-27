package InitialPractice.model.retail.transaction

import InitialPractice.model.company.role.{Employee, Seller}
import InitialPractice.model.saleables.Saleable

class TransactionLineNumber(
                    val employee: Employee,
                    val seller: Seller,
                    val item:Saleable,
                    val quantity:Int,
                    val price:BigDecimal,
                    ) {


}
