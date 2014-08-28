<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.home.label"/></title>
</head>

<body>
<div class="page-header">
    <h1>Dashboard</h1>
</div>

<div id="list-process" class="content scaffold-list" role="main">
    <g:if test="${processInstanceCount==0}">
        <div class="alert alert-${flash.messagetype?:'info'} message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>No Deployment Units Performed Yet...</div>
    </g:if>
    <g:else>

        <span class="label label-lg label-info arrowed">Deploy Units</span>
        <table class="table table-striped table-bordered">
            <thead>
            <tr>

                <g:sortableColumn property="name" title="${message(code: 'process.name.label', default: 'Process Name')}" />

                <g:sortableColumn property="deployed" title="${message(code: 'process.deployed.label', default: 'Deployed')}" />

                <g:sortableColumn property="running" title="${message(code: 'process.running.label', default: 'Running')}" />

            </tr>
            </thead>
            <tbody>
            <g:each in="${processInstanceList}" status="i" var="processInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                    <td><g:link controller="process" action="show" id="${processInstance.id}">${fieldValue(bean: processInstance, field: "name")}</g:link></td>

                    <td><g:formatBoolean boolean="${processInstance.deployed}" /></td>

                    <td><g:formatBoolean boolean="${processInstance.running}" /></td>

                </tr>
            </g:each>
            </tbody>
        </table>
    </g:else>
</div>

<div id="list-application" class="content scaffold-list" role="main">
    <g:if test="${applicationInstanceCount==0}">
        <div class="alert alert-${flash.messagetype?:'info'} message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>No Remote Apps Synchronized Yet...</div>
    </g:if>
    <g:else>
        <span class="label label-lg label-info arrowed">Remote Apps</span>

    <table class="table table-striped table-bordered">
        <thead>
        <tr>

            <g:sortableColumn property="name" title="${message(code: 'application.name.label', default: 'Name')}" />

            <g:sortableColumn property="location" title="${message(code: 'application.location.label', default: 'Location')}" />

        </tr>
        </thead>
        <tbody>
        <g:each in="${applicationInstanceList}" status="i" var="applicationInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link controller="application" action="show" id="${applicationInstance.id}">${fieldValue(bean: applicationInstance, field: "name")}</g:link></td>

                <td>${fieldValue(bean: applicationInstance, field: "location")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>
    </g:else>
</div>

</body>
</html>
