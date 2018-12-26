package InitialPractice.model.company.role

import InitialPractice.model.saleables.Saleable

trait Seller extends Employee {

  var saleableItems:List[Saleable]

}
