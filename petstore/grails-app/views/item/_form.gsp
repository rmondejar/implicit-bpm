<%@ page import="petstore.Item" %>

<div class="control-group ${hasErrors(bean: itemInstance, field: 'description', 'error')} ">
	<label class="control-label" for="description">
		<g:message code="item.description.label" default="Description" />
		
	</label>
	<div class="controls">
		<g:textField name="description" value="${itemInstance?.description}"/>
	</div>
</div>


<div class="control-group ${hasErrors(bean: itemInstance, field: 'name', 'error')} ">
	<label class="control-label" for="name">
		<g:message code="item.name.label" default="Name" />
		
	</label>
	<div class="controls">
		<g:textField name="name" value="${itemInstance?.name}"/>
	</div>
</div>


<div class="control-group ${hasErrors(bean: itemInstance, field: 'unitCost', 'error')} required">
	<label class="control-label" for="unitCost">
		<g:message code="item.unitCost.label" default="Unit Cost" />
		<span class="required-indicator">*</span>
	</label>
	<div class="controls">
		<g:field type="number" name="unitCost" step="any" required="" value="${itemInstance.unitCost}"/>
	</div>
</div>

