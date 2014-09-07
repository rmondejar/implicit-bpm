package accounting

class Customer {

    String name
    String surname
    String nin

    String email
    String phone
    String address

    String toString() {
        "$name $surname $nin"
    }

    static hasMany = [purchase:Purchase]

    static constraints = {
    }
}
