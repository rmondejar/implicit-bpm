package accounting.v1

class Customer {

    String name
    String NIN

    static hasMany = [books: Book]

    static constraints = {
        NIN(blank: false)
        name(blank: false, unique: true)
        //books(nullable: true)
    }

    String toString(){
        name
    }
}
