package InitialPractice.model.company.role

import InitialPractice.model.company.Company

class Employee (firstName:String,
                lastName:String,
                id:String, val company: Company) extends Person (firstName,lastName,id){

}
