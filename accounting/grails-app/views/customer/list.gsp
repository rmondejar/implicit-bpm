
<%@ page import="accounting.Customer" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-customer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<ul class="nav nav-pills breadcrumb">
			<li><a class="home" href="${createLink(uri: '/')}"><i class="icon-home"></i> <g:message code="default.home.label" /></a></li>
			<li><g:link class="create" action="create"><i class="icon-plus-sign"/></i> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
		</ul>		
		<div id="list-customer" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="alert alert-info message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
			</g:if>
			<table class="table table-striped">
				<thead>
					<tr>

                        <g:sortableColumn property="nin" title="${message(code: 'customer.nin.label', default: 'Nin')}" />

						<g:sortableColumn property="name" title="${message(code: 'customer.name.label', default: 'Name')}" />

						<g:sortableColumn property="surname" title="${message(code: 'customer.surname.label', default: 'Surname')}" />

                        <g:sortableColumn property="address" title="${message(code: 'customer.address.label', default: 'Address')}" />

                        <g:sortableColumn property="email" title="${message(code: 'customer.email.label', default: 'Email')}" />

                        <g:sortableColumn property="phone" title="${message(code: 'customer.phone.label', default: 'Phone')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${customerInstanceList}" status="i" var="customerInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${customerInstance.id}">${fieldValue(bean: customerInstance, field: "nin")}</g:link></td>

						<td>${fieldValue(bean: customerInstance, field: "name")}</td>

						<td>${fieldValue(bean: customerInstance, field: "surname")}</td>

                        <td>${fieldValue(bean: customerInstance, field: "address")}</td>

                        <td>${fieldValue(bean: customerInstance, field: "email")}</td>

						<td>${fieldValue(bean: customerInstance, field: "phone")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination pagination-right">
				<div class="pagination-content">
					<g:paginate total="${customerInstanceTotal}" />
				</div>
			</div>
		</div>
	</body>
</html>
