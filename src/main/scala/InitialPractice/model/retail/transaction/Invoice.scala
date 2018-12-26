package InitialPractice.model.retail.transaction

import java.time.LocalDateTime

import InitialPractice.model.company.role.Buyer

case class Invoice (val buyer: Buyer, val price :BigDecimal, val date:LocalDateTime,val transaction:Transaction){

}