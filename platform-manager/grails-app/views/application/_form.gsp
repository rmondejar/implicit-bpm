<%@ page import="net.sf.bpm.implicit.Application" %>




<div class="control-group ${hasErrors(bean: applicationInstance, field: 'name', 'error')} required col-xs-12">
    <label class="control-label" for="name">
        <g:message code="application.name.label" default="Name" />
    </label>
    <div class="controls">
        <g:textField name="name" maxlength="50" required="" value="${applicationInstance?.name}"/>

    </div>
</div>


<div class="control-group ${hasErrors(bean: applicationInstance, field: 'location', 'error')} required col-xs-12">
    <label class="control-label" for="location">
        <g:message code="application.location.label" default="Location" />
    </label>
    <div class="controls">
        <g:textField name="location" maxlength="150" required="" value="${applicationInstance?.location}"/>

    </div>
</div>



