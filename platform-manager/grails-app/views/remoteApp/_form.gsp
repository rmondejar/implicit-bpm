<%@ page import="net.sf.bpm.implicit.RemoteApp" %>




<div class="control-group ${hasErrors(bean: remoteAppInstance, field: 'name', 'error')} required col-xs-12">
    <label class="control-label" for="name">
        <g:message code="remoteApp.name.label" default="Name" />
    </label>
    <div class="controls">
        <g:textField name="name" maxlength="50" required="" value="${remoteAppInstance?.name}"/>

    </div>
</div>


<div class="control-group ${hasErrors(bean: remoteAppInstance, field: 'location', 'error')} required col-xs-12">
    <label class="control-label" for="location">
        <g:message code="remoteApp.location.label" default="Location" />
    </label>
    <div class="controls">
        <g:textField name="location" maxlength="150" required="" value="${remoteAppInstance?.location}"/>

    </div>
</div>



