package InitialPractice.model.retail.transaction.ledger

import java.util

import InitialPractice.model.retail.transaction.{Transaction, TransactionLineNumber}

abstract class SalesLedger() {
  abstract val sales:util.Collection[Transaction]
}
