<%@ page import="net.sf.bpm.implicit.Process" %>


<div class="control-group ${hasErrors(bean: processInstance, field: 'name', 'error')}  col-xs-12">
    <label class="control-label" for="name">
        <g:message code="process.name.label" default="Name" />
        
    </label>
    <div class="controls">
        <g:textField name="name" required="" value="${processInstance?.name}"/>

    </div>
</div>

