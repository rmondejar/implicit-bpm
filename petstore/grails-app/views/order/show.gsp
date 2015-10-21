
<%@ page import="petstore.Order" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'order.label', default: 'Order')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-order" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<ul class="nav nav-pills breadcrumb">
			<li><a class="home" href="${createLink(uri: '/')}"><i class="icon-home"></i> <g:message code="default.home.label"/></a></li>
			<li><g:link class="list" action="list"><i class="icon-list"></i> <g:message code="default.list.label" args="[entityName]" /></g:link></li>
			<li><g:link class="create" action="create"><i class="icon-plus-sign"/></i> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
		</ul>		
		<div id="show-order" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">				
				<div class="alert alert-info message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
			</g:if>		
			<div class="form-horizontal">
				<fieldset>
			
				<g:if test="${orderInstance?.customer}">
					<div class="control-group">
					<label class="property-key"><g:message code="order.customer.label" default="Customer" /></label>					
					
						<span class="property-value" aria-labelledby="customer-label"><g:fieldValue bean="${orderInstance}" field="customer"/></span>
					
					</div>
				</g:if>
			
				<g:if test="${orderInstance?.deliveryAddress}">
					<div class="control-group">
					<label class="property-key"><g:message code="order.deliveryAddress.label" default="Delivery Address" /></label>					
					
						<span class="property-value" aria-labelledby="deliveryAddress-label"><g:fieldValue bean="${orderInstance}" field="deliveryAddress"/></span>
					
					</div>
				</g:if>
			
				<g:if test="${orderInstance?.orderDate}">
					<div class="control-group">
					<label class="property-key"><g:message code="order.orderDate.label" default="Order Date" /></label>					
					
						<span class="property-value" aria-labelledby="orderDate-label"><g:formatDate date="${orderInstance?.orderDate}" /></span>
					
					</div>
				</g:if>
			
				<g:if test="${orderInstance?.orderLines}">
					<div class="control-group">
					<label class="property-key"><g:message code="order.orderLines.label" default="Order Lines" /></label>
					
						<g:each in="${orderInstance.orderLines}" var="o">
						<span class="property-value" aria-labelledby="orderLines-label"><g:link controller="orderLine" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></span>
						</g:each>
					
					</div>
				</g:if>
			
				</fieldset>
			</div>
			<g:form>		
				<div class="form-actions">
					<g:hiddenField name="id" value="${orderInstance?.id}" />
                    <g:if test="${!orderInstance.processed}">
					<g:link class="edit btn" action="edit" id="${orderInstance?.id}">
						<i class="icon-pencil"></i>
						<g:message code="default.button.edit.label" default="Edit" />					
					</g:link>
                    <g:link class="btn btn-warning process" action="process" id="${orderInstance?.id}" onclick="return confirm('${message(code: 'default.button.process.confirm.message', default: 'Are you sure?')}');">
                        <i class="icon-shopping-cart"></i>
                        <g:message code="default.button.process.label" default="Process" />
                    </g:link>
					<button type="submit" name="_action_delete" class="btn btn-danger delete" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">
						<i class="icon-trash icon-white"></i> 
						${message(code: 'default.button.delete.label', default: 'Delete')}
					</button>
                    </g:if>
				</div>
			</g:form>
		</div>
	</body>
</html>
