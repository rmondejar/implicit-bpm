<%@ page import="accounting.Customer" %>


<div class="control-group ${hasErrors(bean: customerInstance, field: 'name', 'error')} ">
	<label class="control-label" for="name">
		<g:message code="customer.name.label" default="Name" />
		
	</label>
	<div class="controls">
		<g:textField name="name" value="${customerInstance?.name}"/>
	</div>
</div>


<div class="control-group ${hasErrors(bean: customerInstance, field: 'surname', 'error')} ">
	<label class="control-label" for="surname">
		<g:message code="customer.surname.label" default="Surname" />
		
	</label>
	<div class="controls">
		<g:textField name="surname" value="${customerInstance?.surname}"/>
	</div>
</div>

<div class="control-group ${hasErrors(bean: customerInstance, field: 'nin', 'error')} ">
    <label class="control-label" for="nin">
        <g:message code="customer.nin.label" default="Nin" />

    </label>
    <div class="controls">
        <g:textField name="nin" value="${customerInstance?.nin}"/>
    </div>
</div>


<div class="control-group ${hasErrors(bean: customerInstance, field: 'email', 'error')} ">
    <label class="control-label" for="email">
        <g:message code="customer.email.label" default="Email" />

    </label>
    <div class="controls">
        <g:textField name="email" value="${customerInstance?.email}"/>
    </div>
</div>


<div class="control-group ${hasErrors(bean: customerInstance, field: 'address', 'error')} ">
    <label class="control-label" for="address">
        <g:message code="customer.address.label" default="Address" />

    </label>
    <div class="controls">
        <g:textField name="address" value="${customerInstance?.address}"/>
    </div>
</div>



<div class="control-group ${hasErrors(bean: customerInstance, field: 'phone', 'error')} ">
	<label class="control-label" for="phone">
		<g:message code="customer.phone.label" default="Phone" />
		
	</label>
	<div class="controls">
		<g:textField name="phone" value="${customerInstance?.phone}"/>
	</div>
</div>

