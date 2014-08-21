<g:if test="${remoteAppInstance?.name}">
    <div class="control-group col-xs-12">
        <label class="property-key"><g:message code="remoteApp.name.label" default="Name"/></label>
        <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${remoteAppInstance}"
                                                                                field="name"/></span>
    </div>
</g:if>

<g:if test="${remoteAppInstance?.version}">
    <div class="control-group col-xs-12">
        <label class="property-key"><g:message code="remoteApp.version.label" default="Version"/></label>
        <span class="property-value" aria-labelledby="location-label"><g:fieldValue bean="${remoteAppInstance}"
                                                                                    field="version"/></span>
    </div>
</g:if>

<g:if test="${remoteAppInstance?.location}">
    <div class="control-group col-xs-12">
        <label class="property-key"><g:message code="remoteApp.location.label" default="Location"/></label>
        <span class="property-value" aria-labelledby="location-label"><g:fieldValue bean="${remoteAppInstance}"
                                                                                    field="location"/></span>
    </div>
</g:if>

<g:if test="${remoteAppInstance?.isWarMode}">
    <div class="control-group col-xs-12">
        <label class="property-key"><g:message code="remoteApp.isWarMode.label" default="War Mode"/></label>
        <span class="property-value" aria-labelledby="location-label"><g:fieldValue bean="${remoteAppInstance}"
                                                                                    field="isWarMode"/></span>
    </div>
</g:if>

<g:if test="${remoteAppInstance?.framework}">
    <div class="control-group col-xs-12">
        <label class="property-key"><g:message code="remoteApp.framework.label" default="Framework"/></label>
        <span class="property-value" aria-labelledby="location-label"><g:fieldValue bean="${remoteAppInstance}"
                                                                                    field="framework"/></span>
    </div>
</g:if>

<g:if test="${remoteAppInstance?.metadata}">
    <div class="control-group col-xs-12">
        <label class="property-key"><g:message code="remoteApp.metadata.label" default="Metadata"/></label>
        <span class="property-value" aria-labelledby="metadata-label"><g:fieldValue bean="${remoteAppInstance}"
                                                                                    field="metadata"/></span>
    </div>
</g:if>
				