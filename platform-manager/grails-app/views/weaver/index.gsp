
<%@ page import="net.sf.bpm.implicit.Weaver" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'weaver.label', default: 'Weaver')}" />
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

<div id="list-weaver" class="content scaffold-list" role="main">
    <g:if test="${flash.message}">
        <div class="alert alert-${flash.messagetype?:'info'} message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
    </g:if>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <g:sortableColumn property="line" title="${message(code: 'weaver.act.appName.label', default: 'Application')}" />

            <g:sortableColumn property="line" title="${message(code: 'weaver.line.label', default: 'Line')}" />
            
            <g:sortableColumn property="active" title="${message(code: 'weaver.active.label', default: 'Active')}" />
            
        </tr>
        </thead>
        <tbody>
        <g:each in="${weaverInstanceList}" status="i" var="weaverInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td>${fieldValue(bean: weaverInstance, field: "appName")}</td>

                <td><g:link action="show" id="${weaverInstance.id}">${fieldValue(bean: weaverInstance, field: "inputDSL")}</g:link></td>

                <td><g:formatBoolean boolean="${weaverInstance.active}" /></td>
                
            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination pagination-right">
        <div class="pagination-content">
            <g:paginate total="${weaverInstanceCount ?: 0}" />
        </div>
    </div>
</div>
</body>
</html>