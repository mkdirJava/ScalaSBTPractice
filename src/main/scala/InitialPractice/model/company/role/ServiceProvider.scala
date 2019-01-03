package InitialPractice.model.company.role

import InitialPractice.model.saleables.Saleable

trait ServiceProvider extends SellerAction {
this:Seller=>
  protected def doService(seller: Seller,buyer: Buyer,saleItems:Map[Saleable,Int])

}
