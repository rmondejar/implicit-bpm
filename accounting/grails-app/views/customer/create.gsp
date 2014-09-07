<%@ page import="accounting.Customer" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-customer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills breadcrumb">
				<li><a class="home" href="${createLink(uri: '/')}"><i class="icon-home"></i> <g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><i class="icon-list"></i> <g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-customer" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="alert alert-info message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${customerInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${customerInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form class="form-horizontal" action="save" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="form-actions">
					<button type="submit" name="create" class="btn save">
						<i class="icon-ok"></i>
						${message(code: 'default.button.create.label', default: 'Create')}
					</button>					
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
