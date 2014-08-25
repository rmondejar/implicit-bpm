<%@ page import="accounting.v1.Book" %>



<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'createdDate', 'error')} required">
    <label for="createdDate">
        <g:message code="book.createdDate.label" default="Created Date"/>
        <span class="required-indicator">*</span>
    </label>
    <g:datePicker name="createdDate" precision="day" value="${bookInstance?.createdDate}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'amount', 'error')} required">
    <label for="amount">
        <g:message code="book.amount.label" default="Amount"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field name="amount" value="${fieldValue(bean: bookInstance, field: 'amount')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'owner', 'error')} ">
    <label for="owner">
        <g:message code="book.owner.label" default="Owner"/>

    </label>
    <g:select id="owner" name="owner.id" from="${accounting.v1.Customer.list()}" optionKey="id"
              value="${bookInstance?.owner?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

