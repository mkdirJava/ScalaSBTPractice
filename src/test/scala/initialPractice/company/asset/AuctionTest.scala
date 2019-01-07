package initialPractice.company.asset

import InitialPractice.model.company.Company
import InitialPractice.model.company.asset.auction.AuctionHouse
import InitialPractice.model.company.role._
import InitialPractice.model.saleables.animals.farmed.{Cow, Pig, Sheep}
import org.scalatest.FunSuite

import scala.collection.mutable.{ListBuffer, MutableList}


object AuctionTest{

  def createAuctionSellers(company: Company): MutableList[Employee] ={
    val sellerOne = new AuctionSeller(s"Bob",s"Jones","1",company,s"${company.companyName}seller Bob.J")
    sellerOne.saleableItems = Map(
      (new Cow(2,BigDecimal(0))-> 1),
      (new Pig(1,BigDecimal(0))->2),
      (new Sheep(9,BigDecimal(0))->1)
    )
    val sellerTwo = new AuctionSeller(s"Pete",s"Major","2",company,s"${company.companyName} Seller Pete.M")
    sellerTwo.saleableItems =  Map(
      (new Cow(5,BigDecimal(0))->23),
      (new Pig(2,BigDecimal(0))->11),
      (new Sheep(1,BigDecimal(0))->41)
    )
    MutableList(sellerOne,sellerTwo)
  }

  def createBuyers(company: Company):MutableList[Employee] ={
    MutableList(
      new AuctionBuyer(s"Todd",s"Harper","3",company,s"${company.companyName} Buyer Todd.H"),
      new AuctionBuyer(s"Macc",s"Tide","4",company,s"${company.companyName} Buyer Macc.T")
    )
  }
  def createCompany(companyName:String)={
    val company = new Company(companyName,BigDecimal(0))
    company.employeeList = createAuctionSellers(company) ++= createBuyers(company)
    company
  }

  val id:Long = 1L
  val value:BigDecimal = BigDecimal(0)
  val auctionCompany = new Company("The Auction House",0)
  val auctionHouse: AuctionHouse =  new AuctionHouse(id,value,new FarmAuctioneer(
    "Tom",
    "Baker",
    "1",
    auctionCompany,
    "Auctioneer Tom.B"))



  val companies:List[Company]= List(
    createCompany("The Great Butchers"),
    createCompany("Pie Meaters"),
    createCompany("We Make Everything Sausage"),
    createCompany("Head To Toe")
  )
}

class AuctionTest extends FunSuite{

  test("The AuctionHouse should be able to conduction auctions"){
    AuctionTest.companies.flatMap(company=> company.employeeList)
      .foreach(employee => employee match {
        case auctionBuyer: AuctionBuyer => AuctionTest.auctionHouse.registerBuyer(auctionBuyer)
        case auctionSeller: AuctionSeller => AuctionTest.auctionHouse.registerSeller(auctionSeller)
        })
    AuctionTest.auctionHouse.conductAuction()
    AuctionTest.companies.flatMap(company => company.invoiceList).foreach(invoice=>println(s"The invoice ${invoice}"))
    AuctionTest.companies.flatMap(company => company.receiptList).foreach(receipt=>println(s"The receipt ${receipt}"))
    AuctionTest.auctionHouse.buyerList.flatMap(buyer =>buyer.boughtItems).foreach(bought=>println(s"The bought ${bought}"))
    AuctionTest.auctionHouse.sellerList.flatMap(seller =>seller.saleableItems).foreach(item=>println(s"The Item ${item}"))

  }
/*
  test("The AuctionHouse should be able to register Buyers"){
    AuctionTest.companies.flatMap(company=> company.employeeList)
      .foreach(employee =>
        if(employee.isInstanceOf[AuctionBuyer]){
          AuctionTest.auctionHouse.registerBuyer(employee.asInstanceOf[AuctionBuyer])
        })
    assert(AuctionTest.auctionHouse.buyerList.length == 8, "There should be 8 buyers in the auction House")
    AuctionTest.auctionHouse.buyerList= MutableList.empty
  }

  test("The AuctionHouse should be able to register Sellers"){
    AuctionTest.companies.flatMap(company=> company.employeeList)
      .foreach(employee =>
        if(employee.isInstanceOf[AuctionSeller]){
          AuctionTest.auctionHouse.registerSeller(employee.asInstanceOf[AuctionSeller])
        })

    assert(AuctionTest.auctionHouse.sellerList.length == 8, "There should be 8 sellers in the auction House")
    AuctionTest.auctionHouse.sellerList = MutableList.empty
  }*/

}
