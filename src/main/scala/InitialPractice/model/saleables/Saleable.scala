package InitialPractice.model.saleables

import InitialPractice.model.company.role.Seller

case class Saleable (val cost:BigDecimal, val discount:BigDecimal, val seller: Seller) {

}
