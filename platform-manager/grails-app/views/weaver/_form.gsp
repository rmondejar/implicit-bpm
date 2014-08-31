<%@ page import="net.sf.bpm.implicit.Weaver" %>


<div class="control-group ${hasErrors(bean: weaverInstance, field: 'act.appName', 'error')}  col-xs-12">
    <label class="control-label" for="appName">
        <g:message code="application.label" default="Application" />
        <span class="required-indicator">*</span>
    </label>
    <div class="controls">
        <g:textField name="appName" maxlength="50" required="" value="${weaverInstance?.appName}"/>

    </div>
</div>

<div class="control-group ${hasErrors(bean: weaverInstance, field: 'line', 'error')} required col-xs-12">
    <label class="control-label" for="line">
        <g:message code="weaver.line.label" default="Line" />
        <span class="required-indicator">*</span>
    </label>
    <div class="controls">
        <g:textField name="line" maxlength="150" required="" value="${weaverInstance?.line}"/>

    </div>
</div>