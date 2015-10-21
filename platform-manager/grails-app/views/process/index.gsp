
<%@ page import="net.sf.bpm.implicit.Process" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'process.label', default: 'Process')}" />
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

<div id="list-process" class="content scaffold-list" role="main">
    <g:if test="${flash.message}">
        <div class="alert alert-${flash.messagetype?:'info'} message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
    </g:if>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            
            <g:sortableColumn property="name" title="${message(code: 'process.name.label', default: 'Name')}" />
            
            <g:sortableColumn property="deployed" title="${message(code: 'process.deployed.label', default: 'Deployed')}" />
            
            <g:sortableColumn property="running" title="${message(code: 'process.running.label', default: 'Running')}" />

        </tr>
        </thead>
        <tbody>
        <g:each in="${processInstanceList}" status="i" var="processInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                
                <td><g:link action="show" id="${processInstance.id}">${fieldValue(bean: processInstance, field: "name")}</g:link></td>
                
                <td><g:formatBoolean boolean="${processInstance.deployed}" /></td>
                
                <td><g:formatBoolean boolean="${processInstance.running}" /></td>

            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination pagination-right">
        <div class="pagination-content">
            <g:paginate total="${processInstanceCount ?: 0}" />
        </div>
    </div>
</div>
</body>
</html>