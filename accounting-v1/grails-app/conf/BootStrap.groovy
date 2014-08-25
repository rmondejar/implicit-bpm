import accounting.v1.Book
import accounting.v1.Customer

class BootStrap {

    def init = { servletContext ->

        def customers = [
                new Customer(name: "Anne", NIN: 12345),
                new Customer(name: "Bob", NIN: 23456)
        ]
        customers*.save()

        def books = [
                new Book(amount: 1000),
                new Book(amount: 100, owner: customers.find {it.name="Bob"})
        ]
        books*.save()

    }
    def destroy = {
    }
}
