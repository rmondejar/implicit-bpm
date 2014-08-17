
<%@ page import="net.sf.bpm.implicit.DeployUnit" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'deployUnit.label', default: 'DeployUnit')}" />
    <title><g:message code="default.deploy.label" args="[entityName]" /> ${deployUnitInstance.toString()}</title>
</head>
<body>
<div class="page-header">
    <h1><g:message code="default.deploy.label" args="[entityName]" /></h1>
</div>
<div id="show-deployUnit" class="content scaffold-show" role="main">
    <g:if test="${flash.message}">
        <div class="alert alert-${flash.messagetype?:'info'} message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
    </g:if>
    <g:uploadForm action="upload">
    <div class="form-horizontal">
        <fieldset>
            <div class="widget-body">
                <div class="widget-main">
                    <input type="file" name="bpmn20.xml" />
                </div>
            </div>

        </fieldset>
    </div>

        <div class="form-actions">
            <g:hiddenField name="id" value="${deployUnitInstance?.id}" />
                     <button type="submit" name="upload" class="btn btn-sm btn-success save">
                <i class="icon-ok"></i>
                ${message(code: 'default.button.accept.label', default: 'Accept')}
            </button>
            <button type="submit" name="_action_list" class="btn btn-sm">
                ${message(code: 'default.button.cancel.label', default: 'Cancel')}
            </button>
        </div>
    </g:uploadForm>
</div>
</body>
</html>
