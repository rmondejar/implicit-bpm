<%@ page import="accounting.Purchase" %>




<div class="control-group ${hasErrors(bean: purchaseInstance, field: 'book', 'error')} required">
	<label class="control-label" for="book">
		<g:message code="purchase.book.label" default="Book" />
		<span class="required-indicator">*</span>
	</label>
	<div class="controls">
		<g:select id="book" name="book.id" from="${accounting.Book.list()}" optionKey="id" required="" value="${purchaseInstance?.book?.id}" class="many-to-one"/>
	</div>
</div>


<div class="control-group ${hasErrors(bean: purchaseInstance, field: 'customer', 'error')} required">
	<label class="control-label" for="customer">
		<g:message code="purchase.customer.label" default="Customer" />
		<span class="required-indicator">*</span>
	</label>
	<div class="controls">
		<g:select id="customer" name="customer.id" from="${accounting.Customer.list()}" optionKey="id" required="" value="${purchaseInstance?.customer?.id}" class="many-to-one"/>
	</div>
</div>


<div class="control-group ${hasErrors(bean: purchaseInstance, field: 'date', 'error')} required">
	<label class="control-label" for="date">
		<g:message code="purchase.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<div class="controls">
		<g:datePicker name="date" precision="day"  value="${purchaseInstance?.date}"  />
	</div>
</div>


<div class="control-group ${hasErrors(bean: purchaseInstance, field: 'price', 'error')} required">
	<label class="control-label" for="price">
		<g:message code="purchase.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<div class="controls">
		<g:field type="number" name="price" step="any" required="" value="${purchaseInstance.price}"/>
	</div>
</div>


<div class="control-group ${hasErrors(bean: purchaseInstance, field: 'product', 'error')} ">
	<label class="control-label" for="product">
		<g:message code="purchase.product.label" default="Product" />
		
	</label>
	<div class="controls">
		<g:textField name="product" value="${purchaseInstance?.product}"/>
	</div>
</div>

