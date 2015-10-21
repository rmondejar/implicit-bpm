
<%@ page import="petstore.Order" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'order.label', default: 'Order')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-order" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<ul class="nav nav-pills breadcrumb">
			<li><a class="home" href="${createLink(uri: '/')}"><i class="icon-home"></i> <g:message code="default.home.label" /></a></li>
			<li><g:link class="create" action="create"><i class="icon-plus-sign"/></i> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
		</ul>		
		<div id="list-order" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="alert alert-info message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
			</g:if>
			<table class="table table-striped">
				<thead>
					<tr>
					
						<g:sortableColumn property="customer" title="${message(code: 'order.customer.label', default: 'Customer')}" />
					
						<g:sortableColumn property="deliveryAddress" title="${message(code: 'order.deliveryAddress.label', default: 'Delivery Address')}" />
					
						<g:sortableColumn property="orderDate" title="${message(code: 'order.orderDate.label', default: 'Order Date')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${orderInstanceList}" status="i" var="orderInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${orderInstance.id}">${fieldValue(bean: orderInstance, field: "customer")}</g:link></td>
					
						<td>${fieldValue(bean: orderInstance, field: "deliveryAddress")}</td>
					
						<td><g:formatDate date="${orderInstance.orderDate}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination pagination-right">
				<div class="pagination-content">
					<g:paginate total="${orderInstanceTotal}" />
				</div>
			</div>
		</div>
	</body>
</html>
