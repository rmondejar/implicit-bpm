
<%@ page import="net.sf.bpm.implicit.RemoteApp" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'remoteApp.label', default: 'RemoteApp')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-remoteApp" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<ul class="nav nav-pills breadcrumb">
			<li><a class="home" href="${createLink(uri: '/')}"><i class="icon-home"></i> <g:message code="default.home.label"/></a></li>
			<li><g:link class="list" action="index"><i class="icon-list"></i> <g:message code="default.list.label" args="[entityName]" /></g:link></li>
			<li><g:link class="create" action="create"><i class="icon-plus-sign"/></i> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
		</ul>		
		<div id="show-remoteApp" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">				
				<div class="alert alert-info message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
			</g:if>		
			<div class="form-horizontal">
				<fieldset>
			
				<g:if test="${remoteAppInstance?.name}">
					<div class="control-group">
					<label class="property-key"><g:message code="remoteApp.name.label" default="Name" /></label>					
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${remoteAppInstance}" field="name"/></span>
					
					</div>
				</g:if>
			
				<g:if test="${remoteAppInstance?.location}">
					<div class="control-group">
					<label class="property-key"><g:message code="remoteApp.location.label" default="Location" /></label>					
					
						<span class="property-value" aria-labelledby="location-label"><g:fieldValue bean="${remoteAppInstance}" field="location"/></span>
					
					</div>
				</g:if>
			
				<g:if test="${remoteAppInstance?.metadata}">
					<div class="control-group">
					<label class="property-key"><g:message code="remoteApp.metadata.label" default="Metadata" /></label>					
					
						<span class="property-value" aria-labelledby="metadata-label"><g:fieldValue bean="${remoteAppInstance}" field="metadata"/></span>
					
					</div>
				</g:if>
			
				</fieldset>
			</div>
			<g:form>		
				<div class="form-actions">
					<g:hiddenField name="id" value="${remoteAppInstance?.id}" />
					<g:link class="edit btn" action="edit" id="${remoteAppInstance?.id}">
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
