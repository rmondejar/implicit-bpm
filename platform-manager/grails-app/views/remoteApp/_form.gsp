<%@ page import="net.sf.bpm.implicit.RemoteApp" %>



<div class="fieldcontain ${hasErrors(bean: remoteAppInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="remoteApp.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="100" required="" value="${remoteAppInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: remoteAppInstance, field: 'location', 'error')} required">
	<label for="location">
		<g:message code="remoteApp.location.label" default="Location" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="url" name="location" required="" value="${remoteAppInstance?.location}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: remoteAppInstance, field: 'metadata', 'error')} required">
	<label for="metadata">
		<g:message code="remoteApp.metadata.label" default="Metadata" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="metadata" cols="40" rows="5" maxlength="2000" required="" value="${remoteAppInstance?.metadata}"/>

</div>

