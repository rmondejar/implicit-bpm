<%@ page import="petstore.Order" %>




<div class="control-group ${hasErrors(bean: orderInstance, field: 'customer', 'error')} ">
	<label class="control-label" for="customer">
		<g:message code="order.customer.label" default="Customer" />
		
	</label>
	<div class="controls">
		<g:textField name="customer" value="${orderInstance?.customer}"/>
	</div>
</div>


<div class="control-group ${hasErrors(bean: orderInstance, field: 'deliveryAddress', 'error')} ">
	<label class="control-label" for="deliveryAddress">
		<g:message code="order.deliveryAddress.label" default="Delivery Address" />
		
	</label>
	<div class="controls">
		<g:textField name="deliveryAddress" value="${orderInstance?.deliveryAddress}"/>
	</div>
</div>


<div class="control-group ${hasErrors(bean: orderInstance, field: 'orderDate', 'error')} required">
	<label class="control-label" for="orderDate">
		<g:message code="order.orderDate.label" default="Order Date" />
		<span class="required-indicator">*</span>
	</label>
	<div class="controls">
		<g:datePicker name="orderDate" precision="day"  value="${orderInstance?.orderDate}"  />
	</div>
</div>


<div class="control-group ${hasErrors(bean: orderInstance, field: 'orderLines', 'error')} ">
	<label class="control-label" for="orderLines">
		<g:message code="order.orderLines.label" default="Order Lines" />
		
	</label>
	<div class="controls">
		<g:select name="orderLines" from="${petstore.OrderLine.list()}" multiple="multiple" optionKey="id" size="5" value="${orderInstance?.orderLines*.id}" class="many-to-many"/>
	</div>
</div>

