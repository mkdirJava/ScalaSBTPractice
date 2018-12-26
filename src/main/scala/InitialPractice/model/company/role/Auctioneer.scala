package InitialPractice.model.company.role

class  Auctioneer(
                    id:Long,
                    companyName:String,
                    balance:BigDecimal,
                    employeeList:List[Employee]
                      ) extends ServiceProvider(employeeList,balance ) {

}
