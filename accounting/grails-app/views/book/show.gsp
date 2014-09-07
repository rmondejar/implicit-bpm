
<%@ page import="accounting.Book" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'book.label', default: 'Book')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-book" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<ul class="nav nav-pills breadcrumb">
			<li><a class="home" href="${createLink(uri: '/')}"><i class="icon-home"></i> <g:message code="default.home.label"/></a></li>
			<li><g:link class="list" action="list"><i class="icon-list"></i> <g:message code="default.list.label" args="[entityName]" /></g:link></li>
			<li><g:link class="create" action="create"><i class="icon-plus-sign"/></i> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
		</ul>		
		<div id="show-book" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">				
				<div class="alert alert-info message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
			</g:if>		
			<div class="form-horizontal">
				<fieldset>
			
				<g:if test="${bookInstance?.label}">
					<div class="control-group">
					<label class="property-key"><g:message code="book.label.label" default="Label" /></label>					
					
						<span class="property-value" aria-labelledby="label-label"><g:fieldValue bean="${bookInstance}" field="label"/></span>
					
					</div>
				</g:if>
			
				<g:if test="${bookInstance?.purchases}">
					<div class="control-group">
					<label class="property-key"><g:message code="book.purchases.label" default="Purchases" /></label>					
					
						<g:each in="${bookInstance.purchases}" var="p">
						<span class="property-value" aria-labelledby="purchases-label"><g:link controller="purchase" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
					</div>
				</g:if>
			
				</fieldset>
			</div>
			<g:form>		
				<div class="form-actions">
					<g:hiddenField name="id" value="${bookInstance?.id}" />
					<g:link class="edit btn" action="edit" id="${bookInstance?.id}">
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
