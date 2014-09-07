
<%@ page import="accounting.Purchase" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'purchase.label', default: 'Purchase')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-purchase" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<ul class="nav nav-pills breadcrumb">
			<li><a class="home" href="${createLink(uri: '/')}"><i class="icon-home"></i> <g:message code="default.home.label" /></a></li>
			<li><g:link class="create" action="create"><i class="icon-plus-sign"/></i> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
		</ul>		
		<div id="list-purchase" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="alert alert-info message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
			</g:if>
			<table class="table table-striped">
				<thead>
					<tr>
					
						<th><g:message code="purchase.book.label" default="Book" /></th>
					
						<th><g:message code="purchase.customer.label" default="Customer" /></th>
					
						<g:sortableColumn property="date" title="${message(code: 'purchase.date.label', default: 'Date')}" />
					
						<g:sortableColumn property="price" title="${message(code: 'purchase.price.label', default: 'Price')}" />
					
						<g:sortableColumn property="product" title="${message(code: 'purchase.product.label', default: 'Product')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${purchaseInstanceList}" status="i" var="purchaseInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${purchaseInstance.id}">${fieldValue(bean: purchaseInstance, field: "book")}</g:link></td>
					
						<td>${fieldValue(bean: purchaseInstance, field: "customer")}</td>
					
						<td><g:formatDate date="${purchaseInstance.date}" /></td>
					
						<td>${fieldValue(bean: purchaseInstance, field: "price")}</td>
					
						<td>${fieldValue(bean: purchaseInstance, field: "product")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination pagination-right">
				<div class="pagination-content">
					<g:paginate total="${purchaseInstanceTotal}" />
				</div>
			</div>
		</div>
	</body>
</html>
