<%@ page import="net.sf.bpm.implicit.DeployUnit" %>


<div class="control-group ${hasErrors(bean: deployUnitInstance, field: 'processName', 'error')}  col-xs-12">
    <label class="control-label" for="processName">
        <g:message code="deployUnit.processName.label" default="Process Name" />
        
    </label>
    <div class="controls">
        <g:textField name="processName" required="" value="${deployUnitInstance?.processName}"/>

    </div>
</div>


<div class="control-group ${hasErrors(bean: deployUnitInstance, field: 'weaverDsl', 'error')}  col-xs-12">
    <label class="control-label" for="weaverDsl">
        <g:message code="deployUnit.weaverDsl.label" default="Weaver Dsl" />
        
    </label>
    <div class="controls">
        <g:textArea name="weaverDsl" cols="40" rows="5" maxlength="2000" value="${remoteAppInstance?.metadata}"/>

    </div>
</div>

