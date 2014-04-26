
<%@ page import="net.sf.bpm.implicit.RemoteApp" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'remoteApp.label', default: 'RemoteApp')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-remoteApp" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<ul class="nav nav-pills breadcrumb">
			<li><a class="home" href="${createLink(uri: '/')}"><i class="icon-home"></i> <g:message code="default.home.label" /></a></li>
			<li><g:link class="create" action="create"><i class="icon-plus-sign"/></i> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
		</ul>		
		<div id="list-remoteApp" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="alert alert-info message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
			</g:if>
			<table class="table table-striped">
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'remoteApp.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="location" title="${message(code: 'remoteApp.location.label', default: 'Location')}" />
					
						<g:sortableColumn property="metadata" title="${message(code: 'remoteApp.metadata.label', default: 'Metadata')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${remoteAppInstanceList}" status="i" var="remoteAppInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${remoteAppInstance.id}">${fieldValue(bean: remoteAppInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: remoteAppInstance, field: "location")}</td>
					
						<td>${fieldValue(bean: remoteAppInstance, field: "metadata")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination pagination-right">
				<div class="pagination-content">
					<g:paginate total="${remoteAppInstanceCount}" />
				</div>
			</div>
		</div>
	</body>
</html>
