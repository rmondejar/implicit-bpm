    <g:if test="${weaverInstance?.appName}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="application.label" default="Application" /></label>
            <span class="property-value" aria-labelledby="line-label"><g:fieldValue bean="${weaverInstance}" field="appName"/></span>
        </div>
    </g:if>
			
    <g:if test="${weaverInstance?.line}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="weaver.line.label" default="Line" /></label>
            <span class="property-value" aria-labelledby="line-label"><g:fieldValue bean="${weaverInstance}" field="line"/></span>
        </div>
    </g:if>

    <g:if test="${weaverInstance?.act}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="weaver.act.label" default="Act" /></label>
            <span class="property-value" aria-labelledby="act-label"><g:link controller="act" action="show" id="${weaverInstance?.act?.id}">${weaverInstance?.act?.encodeAsHTML()}</g:link></span>
        </div>
    </g:if>

    <g:if test="${weaverInstance?.active}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="weaver.active.label" default="Active" /></label>
            <span class="property-value" aria-labelledby="active-label"><g:formatBoolean boolean="${weaverInstance?.active}" /></span>
        </div>
    </g:if>

    <g:if test="${weaverInstance?.behaviours}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="weaver.behaviours.label" default="Behaviours" /></label>
            <div class="controls noinput" aria-labelledby="behaviours-label">
                <g:each in="${weaverInstance.sortedBehaviours}" var="b">
                    <span class="property-value" aria-labelledby="behaviours-label"><g:link controller="behaviour" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
                </g:each>
            </div>
        </div>
    </g:if>
				