
    <g:if test="${behaviourInstance?.weaver}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="weaver.label" default="Weaver" /></label>
            <span class="property-value" aria-labelledby="weaver-label"><g:link controller="weaver" action="show" id="${behaviourInstance?.weaver?.id}">${behaviourInstance?.weaver?.encodeAsHTML()}</g:link></span>
        </div>
    </g:if>

    <g:if test="${behaviourInstance?.position>=0}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="behaviour.position.label" default="Position" /></label>
            <span class="property-value" aria-labelledby="position-label"><g:fieldValue bean="${behaviourInstance}" field="position"/></span>
        </div>
    </g:if>

    <g:if test="${behaviourInstance?.connector}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="behaviour.connector.label" default="Connector" /></label>
            <span class="property-value" aria-labelledby="connector-label"><g:fieldValue bean="${behaviourInstance}" field="connector"/></span>
        </div>
    </g:if>

    <g:if test="${behaviourInstance?.variable}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="behaviour.variable.label" default="Variable" /></label>
            <span class="property-value" aria-labelledby="variable-label"><g:fieldValue bean="${behaviourInstance}" field="variable"/></span>
        </div>
    </g:if>

    <g:if test="${behaviourInstance?.element}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="behaviour.element.label" default="Element" /></label>
            <span class="property-value" aria-labelledby="element-label"><g:fieldValue bean="${behaviourInstance}" field="element"/></span>
        </div>
    </g:if>

    <g:if test="${behaviourInstance?.fromController}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="behaviour.fromController.label" default="From Controller" /></label>
            <span class="property-value" aria-labelledby="fromController-label"><g:fieldValue bean="${behaviourInstance}" field="fromController"/></span>
        </div>
    </g:if>

    <g:if test="${behaviourInstance?.byVariable}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="behaviour.byVariable.label" default="By Variable" /></label>
            <span class="property-value" aria-labelledby="byVariable-label"><g:fieldValue bean="${behaviourInstance}" field="byVariable"/></span>
        </div>
    </g:if>

				