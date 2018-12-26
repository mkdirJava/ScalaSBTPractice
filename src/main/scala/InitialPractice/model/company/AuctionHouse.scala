package InitialPractice.model.company

import InitialPractice.model.company.role.{Employee, ServiceProvider}

class AuctionHouse(id:Long, companyName:String,balance:BigDecimal,  employeeList:List[Employee]) extends ServiceProvider(id, companyName,balance,  employeeList) {

}
