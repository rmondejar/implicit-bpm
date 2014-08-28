
			

						<div class="control-group col-xs-12">
							<label class="property-key"><g:message code="process.name.label" default="Name" /></label>
							<span class="property-value" aria-labelledby="processName-label"><g:fieldValue bean="${processInstance}" field="name"/></span>
						</div>


						<div class="control-group col-xs-12">
							<label class="property-key"><g:message code="process.deployed.label" default="Deployed" /></label>
							<span class="property-value" aria-labelledby="deployed-label"><g:formatBoolean boolean="${processInstance?.deployed}" /></span>
						</div>

						<div class="control-group col-xs-12">
							<label class="property-key"><g:message code="process.running.label" default="Running" /></label>
							<span class="property-value" aria-labelledby="running-label"><g:formatBoolean boolean="${processInstance?.running}" /></span>
						</div>