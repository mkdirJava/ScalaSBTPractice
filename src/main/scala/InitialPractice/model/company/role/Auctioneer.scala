package InitialPractice.model.company.role

import InitialPractice.model.retail.MiddleRetailer

class  Auctioneer(
                    id:Long,
                    companyName:String,
                    balance:BigDecimal,
                    employeeList:List[Employee]
                      ) extends ServiceProvider(employeeList,balance )  with MiddleRetailer{


}
