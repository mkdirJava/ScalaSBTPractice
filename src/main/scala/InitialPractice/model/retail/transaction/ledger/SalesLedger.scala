package InitialPractice.model.retail.transaction.ledger

import java.util

import InitialPractice.model.retail.transaction.TransactionLineNumber

abstract class SalesLedger() {
  abstract val sales:util.Collection[TransactionLineNumber]
}
