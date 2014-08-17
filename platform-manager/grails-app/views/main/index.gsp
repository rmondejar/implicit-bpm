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

<div id="list-deployUnit" class="content scaffold-list" role="main">
    <g:if test="${!deployUnitInstanceList?:deployUnitInstanceList.empty}">
        <div class="alert alert-${flash.messagetype?:'info'} message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>No Deployment Units Performed Yet...</div>
    </g:if>
    <g:else>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>

            <g:sortableColumn property="deployedProcess" title="${message(code: 'deployUnit.processName.label', default: 'Deployed Process')}" />

            <g:sortableColumn property="processOk" title="${message(code: 'deployUnit.deployed.label', default: 'Process Ok')}" />

            <g:sortableColumn property="running" title="${message(code: 'deployUnit.running.label', default: 'Running')}" />

        </tr>
        </thead>
        <tbody>
        <g:each in="${deployUnitInstanceList}" status="i" var="deployUnitInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show" id="${deployUnitInstance.id}">${fieldValue(bean: deployUnitInstance, field: "processName")}</g:link></td>

                <td><g:formatBoolean boolean="${deployUnitInstance.processOk}" /></td>

                <td><g:formatBoolean boolean="${deployUnitInstance.running}" /></td>

            </tr>
        </g:each>
        </tbody>
    </table>
    </g:else>
</div>

<div id="list-remoteApp" class="content scaffold-list" role="main">
    <g:if test="${!remoteAppInstanceList?:remoteAppInstanceList.empty}">
        <div class="alert alert-${flash.messagetype?:'info'} message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>No Remote Apps Synchronized Yet...</div>
    </g:if>
    <g:else>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>

            <g:sortableColumn property="name" title="${message(code: 'remoteApp.name.label', default: 'Name')}" />

            <g:sortableColumn property="location" title="${message(code: 'remoteApp.location.label', default: 'Location')}" />

        </tr>
        </thead>
        <tbody>
        <g:each in="${remoteAppInstanceList}" status="i" var="remoteAppInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show" id="${remoteAppInstance.id}">${fieldValue(bean: remoteAppInstance, field: "name")}</g:link></td>

                <td>${fieldValue(bean: remoteAppInstance, field: "location")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>
    </g:else>
</div>

</body>
</html>
