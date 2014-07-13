
<%@ page import="net.sf.bpm.implicit.RemoteApp" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'remoteApp.label', default: 'RemoteApp')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div class="page-header">
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
</div>

<div class="row-fluid wizard-actions">
    <g:link class="btn btn-sm btn-info" action="create"><i class="icon-plus"/></i> <g:message code="default.new.label" args="[entityName]" /></g:link>
    <div class="hr dotted clearfix"></div>
</div>

<div id="list-remoteApp" class="content scaffold-list" role="main">
    <g:if test="${flash.message}">
        <div class="alert alert-${flash.messagetype?:'info'} message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
    </g:if>
    <table class="table table-striped table-bordered">
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
            <g:paginate total="${remoteAppInstanceCount ?: 0}" />
        </div>
    </div>
</div>
</body>
</html>