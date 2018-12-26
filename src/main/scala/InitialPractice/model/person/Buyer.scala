package InitialPractice.model.person

import InitialPractice.model.retail.transaction.Receipt

trait Buyer extends Person{
     val receiptList :List[Receipt]

}
