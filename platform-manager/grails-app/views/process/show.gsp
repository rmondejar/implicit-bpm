
<%@ page import="net.sf.bpm.implicit.Process" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'process.label', default: 'Process')}" />
    <title><g:message code="default.show.label" args="[entityName]" /> ${processInstance.toString()}</title>
</head>
<body>
<div class="page-header">
    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
</div>
<div class="row-fluid wizard-actions">
    <g:link class="btn btn-sm btn-purple" action="index"><i class="icon-list"/></i> <g:message code="default.list.label" args="[entityName]" /></g:link>
    <g:link class="btn btn-sm btn-info" action="create"><i class="icon-plus"/></i> <g:message code="default.new.label" args="[entityName]" /></g:link>
</div>
<div id="show-process" class="content scaffold-show" role="main">
    <g:if test="${flash.message}">
        <div class="alert alert-${flash.messagetype?:'info'} message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
    </g:if>
    <div class="form-horizontal">
        <fieldset>
            <g:render template="data" model="${['processInstance': processInstance]}" />
        </fieldset>
    </div>
    <g:form>
        <div class="form-actions">
            <g:hiddenField name="id" value="${processInstance?.id}" />
            <g:link class="edit btn btn-sm btn-primary" action="edit" id="${processInstance?.id}">
                <i class="icon-pencil"></i>
                <g:message code="default.button.edit.label" default="Edit" />
            </g:link>
            <g:link class="edit btn btn-sm btn-purple" action="deploy" id="${processInstance?.id}">
                <i class="icon-cloud-upload"></i>
                <g:message code="default.button.deploy.label" default="Deploy" />
            </g:link>
            <button type="submit" name="_action_delete" class="btn btn-sm btn-danger delete" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">
                <i class="icon-trash icon-white"></i>
                ${message(code: 'default.button.delete.label', default: 'Delete')}
            </button>
        </div>
    </g:form>
</div>
</body>
</html>
