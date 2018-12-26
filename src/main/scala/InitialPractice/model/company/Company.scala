package InitialPractice.model.company

import InitialPractice.model.company.role.Employee
import InitialPractice.model.retail.transaction.{Invoice, Receipt}
import InitialPractice.model.retail.transaction.ledger.Ledger

class Company (val employeeList: List[Employee],var balance:BigDecimal){

  val saleLedger:Ledger = new Ledger()
  val expensesLedger:Ledger = new Ledger()
  val receiptList:List[Receipt] = List.empty
  val invoiceList:List[Invoice] = List.empty

}