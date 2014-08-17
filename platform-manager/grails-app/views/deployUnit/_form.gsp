<%@ page import="net.sf.bpm.implicit.DeployUnit" %>




<div class="control-group ${hasErrors(bean: deployUnitInstance, field: 'deployedProcess', 'error')}  col-xs-12">
    <label class="control-label" for="deployedProcess">
        <g:message code="deployUnit.deployedProcess.label" default="Deployed Process" />
        
    </label>
    <div class="controls">
        <g:textField name="deployedProcess" required="" value="${deployUnitInstance?.deployedProcess}"/>

    </div>
</div>


<div class="control-group ${hasErrors(bean: deployUnitInstance, field: 'processOk', 'error')}  col-xs-12">
    <label class="control-label" for="processOk">
        <g:message code="deployUnit.processOk.label" default="Process Ok" />
        
    </label>
    <div class="controls">
        <g:checkBox name="processOk" value="${deployUnitInstance?.processOk}" />

    </div>
</div>


<div class="control-group ${hasErrors(bean: deployUnitInstance, field: 'running', 'error')}  col-xs-12">
    <label class="control-label" for="running">
        <g:message code="deployUnit.running.label" default="Running" />
        
    </label>
    <div class="controls">
        <g:checkBox name="running" value="${deployUnitInstance?.running}" />

    </div>
</div>


<div class="control-group ${hasErrors(bean: deployUnitInstance, field: 'weaverDsl', 'error')}  col-xs-12">
    <label class="control-label" for="weaverDsl">
        <g:message code="deployUnit.weaverDsl.label" default="Weaver Dsl" />
        
    </label>
    <div class="controls">
        <g:textField name="weaverDsl" required="" value="${deployUnitInstance?.weaverDsl}"/>

    </div>
</div>

