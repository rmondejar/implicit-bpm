import petstore.Item

class BootStrap {

    def init = { servletContext ->
		
		def items = [
			new Item(name : "Gold Fish", description : "Fish", unitCost: 5),
			new Item(name : "Fish Tank", description : "Furniture", unitCost: 25),
			new Item(name : "Fish Food", description : "Food", unitCost: 2),
			]		
		items*.save()
		
		
    }
    def destroy = {
    }
}
