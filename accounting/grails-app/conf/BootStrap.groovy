import accounting.Purchase
import accounting.Book
import accounting.Customer

class BootStrap {

    def init = { servletContext ->
		
		def customers = [
			new Customer(name : "Robert", surname: "Dowley", nin:"43646642S", email : "rdowley@port.uk", address:"45B Backery Street, London", phone:"+31 555 245 325"),
			new Customer(name : "John", surname:"Peterson",  nin:"65934543M", email : "jpeterson@jmail.com", address:"23 Green Ave, Manchester", phone:"+31 453 223 753"),
			new Customer(name : "Brook", surname:"Smith",    nin:"10436554W", email : "bsmith@uahhoo.org", address:"110 Main Street, Lancaster", phone:"+31 467 024 876")
			]
        customers*.save(flush:true, failOnError:true)

        Book book = new Book(label:"General ledger")

        def today= new Date()
        def purchases = [
             new Purchase(product: "Blue Bird", price: 15.49, customer:customers.first(), date: today - 1),
             new Purchase(product : "Grey Cat", price: 49.99, customer:customers.get(1), date: today - 1),
             new Purchase(product: "Red Dog", price: 67.19, customer:customers.get(1), date: today - 2),
             new Purchase(product: "Yellow Fish", price: 2.99, customer:customers.last(), date: today - 2),
             new Purchase(product: "Black Spider", price: 29.49, customer:customers.last(), date: today - 4),
             new Purchase(product: "White Hamster", price: 5.99, customer:customers.first(), date: today - 6)
        ]


        purchases.each { p -> book.addToPurchases(p) }
        book.save(flush:true, failOnError:true)
		
		
    }
    def destroy = {
    }
}
