
<%@ page import="accounting.Book" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'book.label', default: 'Book')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-book" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<ul class="nav nav-pills breadcrumb">
			<li><a class="home" href="${createLink(uri: '/')}"><i class="icon-home"></i> <g:message code="default.home.label" /></a></li>
			<li><g:link class="create" action="create"><i class="icon-plus-sign"/></i> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
            <li><g:link class="index" controller="customer" action="index"><i class="icon-list"/></i> <g:message code="customer.label" /> List</g:link></li>
		</ul>		
		<div id="list-book" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="alert alert-info message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
			</g:if>
			<table class="table table-striped">
				<thead>
					<tr>
					
						<g:sortableColumn property="label" title="${message(code: 'book.label.label', default: 'Label')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${bookInstanceList}" status="i" var="bookInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${bookInstance.id}">${fieldValue(bean: bookInstance, field: "label")}</g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination pagination-right">
				<div class="pagination-content">
					<g:paginate total="${bookInstanceTotal}" />
				</div>
			</div>
		</div>
	</body>
</html>
