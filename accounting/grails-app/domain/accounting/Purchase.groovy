package accounting

class Purchase {

    String product
    BigDecimal price
    Date date

    static belongsTo = [book:Book]
    static hasOne = [customer:Customer]

    static constraints = {
    }
}
