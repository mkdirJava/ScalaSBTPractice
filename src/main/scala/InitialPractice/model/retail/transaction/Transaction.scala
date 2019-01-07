package InitialPractice.model.retail.transaction

import java.time.LocalDateTime

case class Transaction(val lineNumbers:List[TransactionLineNumber],val transactionDate:LocalDateTime) {

}
