package InitialPractice.model.person

import InitialPractice.model.retail.transaction.Invoice

trait Seller extends Person{
  var invoiceList: List[Invoice]

}
