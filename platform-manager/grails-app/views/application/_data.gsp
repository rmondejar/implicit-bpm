<g:if test="${applicationInstance?.name}">
    <div class="control-group col-xs-12">
        <label class="property-key"><g:message code="application.name.label" default="Name"/></label>
        <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${applicationInstance}"
                                                                                field="name"/></span>
    </div>
</g:if>

<g:if test="${applicationInstance?.version}">
    <div class="control-group col-xs-12">
        <label class="property-key"><g:message code="application.verNum.label" default="Version"/></label>
        <span class="property-value" aria-labelledby="location-label"><g:fieldValue bean="${applicationInstance}"
                                                                                    field="verNum"/></span>
    </div>
</g:if>

<g:if test="${applicationInstance?.location}">
    <div class="control-group col-xs-12">
        <label class="property-key"><g:message code="application.location.label" default="Location"/></label>
        <span class="property-value" aria-labelledby="location-label"><g:fieldValue bean="${applicationInstance}"
                                                                                    field="location"/></span>
    </div>
</g:if>

    <div class="control-group col-xs-12">
        <label class="property-key"><g:message code="application.isWar.label" default="Is War?"/></label>
        <span class="property-value" aria-labelledby="location-label"><g:fieldValue bean="${applicationInstance}"
                                                                                    field="isWar"/></span>
    </div>


<g:if test="${applicationInstance?.framework}">
    <div class="control-group col-xs-12">
        <label class="property-key"><g:message code="application.framework.label" default="Framework"/></label>
        <span class="property-value" aria-labelledby="location-label"><g:fieldValue bean="${applicationInstance}"
                                                                                    field="framework"/></span>
    </div>
</g:if>

<g:if test="${applicationInstance?.metadata}">
    <div class="control-group col-xs-12">
        <label class="property-key"><g:message code="application.metadata.label" default="Metadata"/></label>
        <span class="property-value" aria-labelledby="metadata-label"><g:fieldValue bean="${applicationInstance}"
                                                                                    field="metadata"/></span>
    </div>
</g:if>
				