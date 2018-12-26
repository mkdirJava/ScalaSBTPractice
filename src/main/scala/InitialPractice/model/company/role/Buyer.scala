package InitialPractice.model.company.role

import InitialPractice.model.saleables.Saleable

trait Buyer extends Employee {

     var boughtItems:List[Saleable]
}
