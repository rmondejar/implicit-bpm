    <g:if test="${actInstance?.weaver}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="weaver.label" default="Weaver" /></label>
            <span class="property-value" aria-labelledby="weaver-label"><g:link controller="weaver" action="show" id="${actInstance?.weaver?.id}">${actInstance?.weaver?.encodeAsHTML()}</g:link></span>
        </div>
    </g:if>

    <g:if test="${actInstance?.when}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="act.when.label" default="When" /></label>
            <span class="property-value" aria-labelledby="when-label"><g:fieldValue bean="${actInstance}" field="when"/></span>
        </div>
    </g:if>

    <g:if test="${actInstance?.variable}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="act.variable.label" default="Variable" /></label>
            <span class="property-value" aria-labelledby="variable-label"><g:fieldValue bean="${actInstance}" field="variable"/></span>
        </div>
    </g:if>

    <g:if test="${actInstance?.element}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="act.element.label" default="Element" /></label>
            <span class="property-value" aria-labelledby="element-label"><g:fieldValue bean="${actInstance}" field="element"/></span>
        </div>
    </g:if>

    <g:if test="${actInstance?.fromController}">
        <div class="control-group col-xs-12">
            <label class="property-key"><g:message code="act.fromController.label" default="From Controller" /></label>
            <span class="property-value" aria-labelledby="fromController-label"><g:fieldValue bean="${actInstance}" field="fromController"/></span>
        </div>
    </g:if>
				