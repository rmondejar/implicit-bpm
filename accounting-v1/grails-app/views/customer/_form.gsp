<%@ page import="accounting.v1.Customer" %>



<div class="fieldcontain ${hasErrors(bean: customerInstance, field: 'NIN', 'error')} required">
    <label for="NIN">
        <g:message code="customer.NIN.label" default="NIN"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="NIN" required="" value="${customerInstance?.NIN}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: customerInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="customer.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${customerInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: customerInstance, field: 'books', 'error')} ">
    <label for="books">
        <g:message code="customer.books.label" default="Books"/>

    </label>

    <ul class="one-to-many">
        <g:each in="${customerInstance?.books ?}" var="b">
            <li><g:link controller="book" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
        </g:each>
        <li class="add">
            <g:link controller="book" action="create"
                    params="['customer.id': customerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'book.label', default: 'Book')])}</g:link>
        </li>
    </ul>

</div>

