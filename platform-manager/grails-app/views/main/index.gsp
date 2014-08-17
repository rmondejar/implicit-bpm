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
    <g:if test="${deployUnitInstanceCount==0}">
        <div class="alert alert-${flash.messagetype?:'info'} message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>No Deployment Units Performed Yet...</div>
    </g:if>
    <g:else>

        <span class="label label-lg label-info arrowed">Deploy Units</span>
        <table class="table table-striped table-bordered">
            <thead>
            <tr>

                <g:sortableColumn property="processName" title="${message(code: 'deployUnit.processName.label', default: 'Process Name')}" />

                <g:sortableColumn property="deployed" title="${message(code: 'deployUnit.deployed.label', default: 'Deployed')}" />

                <g:sortableColumn property="running" title="${message(code: 'deployUnit.running.label', default: 'Running')}" />

            </tr>
            </thead>
            <tbody>
            <g:each in="${deployUnitInstanceList}" status="i" var="deployUnitInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                    <td><g:link controller="deployUnit" action="show" id="${deployUnitInstance.id}">${fieldValue(bean: deployUnitInstance, field: "processName")}</g:link></td>

                    <td><g:formatBoolean boolean="${deployUnitInstance.deployed}" /></td>

                    <td><g:formatBoolean boolean="${deployUnitInstance.running}" /></td>

                </tr>
            </g:each>
            </tbody>
        </table>
    </g:else>
</div>

<div id="list-remoteApp" class="content scaffold-list" role="main">
    <g:if test="${remoteAppInstanceCount==0}">
        <div class="alert alert-${flash.messagetype?:'info'} message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>No Remote Apps Synchronized Yet...</div>
    </g:if>
    <g:else>
        <span class="label label-lg label-info arrowed">Remote Apps</span>

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

                <td><g:link controller="remoteApp" action="show" id="${remoteAppInstance.id}">${fieldValue(bean: remoteAppInstance, field: "name")}</g:link></td>

                <td>${fieldValue(bean: remoteAppInstance, field: "location")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>
    </g:else>
</div>

</body>
</html>
