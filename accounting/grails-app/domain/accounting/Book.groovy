package accounting

class Book {

    static def transactionTypes = ['purchase', 'sale', 'receipt', 'payment']

    String label

    static hasMany = [purchases:Purchase]

    String toString() {
        label
    }

    static constraints = {
    }
}
