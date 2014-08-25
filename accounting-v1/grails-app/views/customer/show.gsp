<%@ page import="accounting.v1.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-customer" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                               default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-customer" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list customer">

        <g:if test="${customerInstance?.NIN}">
            <li class="fieldcontain">
                <span id="NIN-label" class="property-label"><g:message code="customer.NIN.label" default="NIN"/></span>

                <span class="property-value" aria-labelledby="NIN-label"><g:fieldValue bean="${customerInstance}"
                                                                                       field="NIN"/></span>

            </li>
        </g:if>

        <g:if test="${customerInstance?.name}">
            <li class="fieldcontain">
                <span id="name-label" class="property-label"><g:message code="customer.name.label"
                                                                        default="Name"/></span>

                <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${customerInstance}"
                                                                                        field="name"/></span>

            </li>
        </g:if>

        <g:if test="${customerInstance?.books}">
            <li class="fieldcontain">
                <span id="books-label" class="property-label"><g:message code="customer.books.label"
                                                                         default="Books"/></span>

                <g:each in="${customerInstance.books}" var="b">
                    <span class="property-value" aria-labelledby="books-label"><g:link controller="book" action="show"
                                                                                       id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
                </g:each>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource: customerInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${customerInstance}"><g:message
                    code="default.button.edit.label" default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
