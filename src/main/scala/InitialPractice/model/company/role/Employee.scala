package InitialPractice.model.company.role

import InitialPractice.model.company.Company

class Employee (firstName:String,
                lastName:String,
                id:String,
                val company: Company,
                val userName:String) extends Person (firstName,lastName,id){

}
