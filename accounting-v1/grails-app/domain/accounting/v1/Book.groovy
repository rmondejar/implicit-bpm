package accounting.v1

class Book {

    Date createdDate = new Date()
    float amount
    Customer owner

    static def totalBalance() {
        Book.getAll().sum { it.amount }

    }

    static constraints = {
        createdDate()
        amount()
        owner(nullable: true)
    }


}
