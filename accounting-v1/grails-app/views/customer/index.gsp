<%@ page import="accounting.v1.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-customer" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                               default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-customer" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="NIN" title="${message(code: 'customer.NIN.label', default: 'NIN')}"/>

            <g:sortableColumn property="name" title="${message(code: 'customer.name.label', default: 'Name')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${customerInstanceList}" status="i" var="customerInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${customerInstance.id}">${fieldValue(bean: customerInstance, field: "NIN")}</g:link></td>

                <td>${fieldValue(bean: customerInstance, field: "name")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${customerInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>
