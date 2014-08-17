
			

						<div class="control-group col-xs-12">
							<label class="property-key"><g:message code="deployUnit.processName.label" default="Process Name" /></label>
							<span class="property-value" aria-labelledby="processName-label"><g:fieldValue bean="${deployUnitInstance}" field="processName"/></span>
						</div>


						<div class="control-group col-xs-12">
							<label class="property-key"><g:message code="deployUnit.deployed.label" default="Deployed" /></label>
							<span class="property-value" aria-labelledby="deployed-label"><g:formatBoolean boolean="${deployUnitInstance?.deployed}" /></span>
						</div>

						<div class="control-group col-xs-12">
							<label class="property-key"><g:message code="deployUnit.running.label" default="Running" /></label>
							<span class="property-value" aria-labelledby="running-label"><g:formatBoolean boolean="${deployUnitInstance?.running}" /></span>
						</div>

					<g:if test="${deployUnitInstance?.weaverDsl}">
						<div class="control-group col-xs-12">
							<label class="property-key"><g:message code="deployUnit.weaverDsl.label" default="Weaver Dsl" /></label>
							<span class="property-value" aria-labelledby="weaverDsl-label"><g:fieldValue bean="${deployUnitInstance}" field="weaverDsl"/></span>
						</div>
					</g:if>
				