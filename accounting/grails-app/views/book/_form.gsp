<%@ page import="accounting.Book" %>




<div class="control-group ${hasErrors(bean: bookInstance, field: 'label', 'error')} ">
	<label class="control-label" for="label">
		<g:message code="book.label.label" default="Label" />
		
	</label>
	<div class="controls">
		<g:textField name="label" value="${bookInstance?.label}"/>
	</div>
</div>


<div class="control-group ${hasErrors(bean: bookInstance, field: 'purchases', 'error')} ">
	<label class="control-label" for="purchases">
		<g:message code="book.purchases.label" default="Purchases" />
		
	</label>
	<div class="controls">
		
<ul class="one-to-many">
<g:each in="${bookInstance?.purchases?}" var="p">
    <li><g:link controller="purchase" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="purchase" action="create" params="['book.id': bookInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'purchase.label', default: 'Purchase')])}</g:link>
</li>
</ul>

	</div>
</div>

