package InitialPractice.model.retail.transaction

import java.time.LocalDateTime

import InitialPractice.model.company.role.Seller

case class Receipt ( val seller:Seller, val price :BigDecimal, val date:LocalDateTime,val transaction:Transaction){
  
}
