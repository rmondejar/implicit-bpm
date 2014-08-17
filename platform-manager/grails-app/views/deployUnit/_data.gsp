
			
					<g:if test="${deployUnitInstance?.deployedProcess}">
						<div class="control-group col-xs-12">
							<label class="property-key"><g:message code="deployUnit.deployedProcess.label" default="Deployed Process" /></label>
							<span class="property-value" aria-labelledby="deployedProcess-label"><g:fieldValue bean="${deployUnitInstance}" field="deployedProcess"/></span>
						</div>
					</g:if>
				
					<g:if test="${deployUnitInstance?.processOk}">
						<div class="control-group col-xs-12">
							<label class="property-key"><g:message code="deployUnit.processOk.label" default="Process Ok" /></label>
							<span class="property-value" aria-labelledby="processOk-label"><g:formatBoolean boolean="${deployUnitInstance?.processOk}" /></span>
						</div>
					</g:if>
				
					<g:if test="${deployUnitInstance?.running}">
						<div class="control-group col-xs-12">
							<label class="property-key"><g:message code="deployUnit.running.label" default="Running" /></label>
							<span class="property-value" aria-labelledby="running-label"><g:formatBoolean boolean="${deployUnitInstance?.running}" /></span>
						</div>
					</g:if>
				
					<g:if test="${deployUnitInstance?.weaverDsl}">
						<div class="control-group col-xs-12">
							<label class="property-key"><g:message code="deployUnit.weaverDsl.label" default="Weaver Dsl" /></label>
							<span class="property-value" aria-labelledby="weaverDsl-label"><g:fieldValue bean="${deployUnitInstance}" field="weaverDsl"/></span>
						</div>
					</g:if>
				