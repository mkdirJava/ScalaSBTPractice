package InitialPractice.model.retail.transaction

import java.time.LocalDateTime

import InitialPractice.model.company.Company
import InitialPractice.model.company.role.Employee

case class Receipt (val employee: Employee,val seller:Company, val price :BigDecimal, val date:LocalDateTime, val transaction:Transaction){
  
}
