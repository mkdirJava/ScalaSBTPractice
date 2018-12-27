package InitialPractice.model.retail.transaction

import java.time.LocalDateTime

import InitialPractice.model.company.Company
import InitialPractice.model.company.role.{Buyer, Employee}

case class Invoice (val employee: Employee,val company: Company, val price :BigDecimal, val date:LocalDateTime,val transaction:Transaction){

}
