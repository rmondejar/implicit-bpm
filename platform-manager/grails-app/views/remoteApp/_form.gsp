<%@ page import="net.sf.bpm.implicit.RemoteApp" %>




<div class="control-group ${hasErrors(bean: remoteAppInstance, field: 'name', 'error')} required col-xs-12">
    <label class="control-label" for="name">
        <g:message code="remoteApp.name.label" default="Name" />
        <span class="required-indicator">*</span>
    </label>
    <div class="controls">
        <g:textField name="name" maxlength="100" required="" value="${remoteAppInstance?.name}"/>

    </div>
</div>


<div class="control-group ${hasErrors(bean: remoteAppInstance, field: 'location', 'error')} required col-xs-12">
    <label class="control-label" for="location">
        <g:message code="remoteApp.location.label" default="Location" />
        <span class="required-indicator">*</span>
    </label>
    <div class="controls">
        <g:field type="url" name="location" required="" value="${remoteAppInstance?.location}"/>

    </div>
</div>


<div class="control-group ${hasErrors(bean: remoteAppInstance, field: 'metadata', 'error')} required col-xs-12">
    <label class="control-label" for="metadata">
        <g:message code="remoteApp.metadata.label" default="Metadata" />
        <span class="required-indicator">*</span>
    </label>
    <div class="controls">
        <g:textArea name="metadata" cols="40" rows="5" maxlength="2000" required="" value="${remoteAppInstance?.metadata}"/>

    </div>
</div>

