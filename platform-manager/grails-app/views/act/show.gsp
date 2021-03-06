
<%@ page import="net.sf.bpm.implicit.Act" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'act.label', default: 'Act')}" />
    <title><g:message code="default.show.label" args="[entityName]" /> ${actInstance.toString()}</title>
</head>
<body>
<div class="page-header">
    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
</div>

<div id="show-act" class="content scaffold-show" role="main">
    <g:if test="${flash.message}">
        <div class="alert alert-${flash.messagetype?:'info'} message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
    </g:if>
    <div class="form-horizontal">
        <fieldset>
            <g:render template="data" model="${['actInstance': actInstance]}" />
        </fieldset>
    </div>
    <g:form>
        <div class="form-actions">
            <g:hiddenField name="id" value="${actInstance?.id}" />
            <g:link class="edit btn btn-sm btn-primary" action="edit" id="${actInstance?.id}">
                <i class="icon-trash icon-pencil"></i>
                <g:message code="default.button.edit.label" default="Edit" />
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
