package InitialPractice.model.company

import InitialPractice.model.company.role.Employee
import InitialPractice.model.retail.transaction.{Invoice, Receipt}
import InitialPractice.model.retail.transaction.ledger.Ledger

import scala.collection.mutable.MutableList

case class Company (var companyName:String,var balance:BigDecimal){

  val saleLedger:Ledger = new Ledger()
  val expensesLedger:Ledger = new Ledger()
  val receiptList:MutableList[Receipt] = MutableList.empty
  val invoiceList:MutableList[Invoice] = MutableList.empty
  var employeeList: MutableList[Employee]  = MutableList.empty

}
