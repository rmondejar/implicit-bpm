
<%@ page import="accounting.Purchase" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'purchase.label', default: 'Purchase')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-purchase" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<ul class="nav nav-pills breadcrumb">
			<li><a class="home" href="${createLink(uri: '/')}"><i class="icon-home"></i> <g:message code="default.home.label"/></a></li>
			<li><g:link class="list" action="list"><i class="icon-list"></i> <g:message code="default.list.label" args="[entityName]" /></g:link></li>
			<li><g:link class="create" action="create"><i class="icon-plus-sign"/></i> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
		</ul>		
		<div id="show-purchase" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">				
				<div class="alert alert-info message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
			</g:if>		
			<div class="form-horizontal">
				<fieldset>
			
				<g:if test="${purchaseInstance?.book}">
					<div class="control-group">
					<label class="property-key"><g:message code="purchase.book.label" default="Book" /></label>					
					
						<span class="property-value" aria-labelledby="book-label"><g:link controller="book" action="show" id="${purchaseInstance?.book?.id}">${purchaseInstance?.book?.encodeAsHTML()}</g:link></span>
					
					</div>
				</g:if>
			
				<g:if test="${purchaseInstance?.customer}">
					<div class="control-group">
					<label class="property-key"><g:message code="purchase.customer.label" default="Customer" /></label>					
					
						<span class="property-value" aria-labelledby="customer-label"><g:link controller="customer" action="show" id="${purchaseInstance?.customer?.id}">${purchaseInstance?.customer?.encodeAsHTML()}</g:link></span>
					
					</div>
				</g:if>
			
				<g:if test="${purchaseInstance?.date}">
					<div class="control-group">
					<label class="property-key"><g:message code="purchase.date.label" default="Date" /></label>					
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate date="${purchaseInstance?.date}" /></span>
					
					</div>
				</g:if>
			
				<g:if test="${purchaseInstance?.price}">
					<div class="control-group">
					<label class="property-key"><g:message code="purchase.price.label" default="Price" /></label>					
					
						<span class="property-value" aria-labelledby="price-label"><g:fieldValue bean="${purchaseInstance}" field="price"/></span>
					
					</div>
				</g:if>
			
				<g:if test="${purchaseInstance?.product}">
					<div class="control-group">
					<label class="property-key"><g:message code="purchase.product.label" default="Product" /></label>					
					
						<span class="property-value" aria-labelledby="product-label"><g:fieldValue bean="${purchaseInstance}" field="product"/></span>
					
					</div>
				</g:if>
			
				</fieldset>
			</div>
			<g:form>		
				<div class="form-actions">
					<g:hiddenField name="id" value="${purchaseInstance?.id}" />
					<g:link class="edit btn" action="edit" id="${purchaseInstance?.id}">
						<i class="icon-trash icon-pencil"></i> 
						<g:message code="default.button.edit.label" default="Edit" />					
					</g:link>
					<button type="submit" name="_action_delete" class="btn btn-danger delete" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">
						<i class="icon-trash icon-white"></i> 
						${message(code: 'default.button.delete.label', default: 'Delete')}
					</button>					
				</div>
			</g:form>
		</div>
	</body>
</html>
