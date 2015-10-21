<div class="sidebar sidebar-fixed" id="sidebar">
	<ul class="nav nav-list">
		<li class="sidebar-app-title sidebar-manager" id="app-title">Manager</li>
		<li><a href="${createLink(uri: '/')}"><i class="icon-dashboard"></i> <span class="menu-text"><g:message code="default.home.label" /></span></a></li>
        <li><g:link controller="application" action="index"><i class="icon-cloud"></i> <span class="menu-text">Applications</span></g:link></li>
        <li><g:link controller="process" action="index"><i class="icon-tasks"></i> <span class="menu-text">Models</span></g:link></li>
        <li><g:link controller="weaver" action="index"><i class="icon-random"></i> <span class="menu-text">Weavers</span></g:link></li>

 	</ul>
    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
    </div>
</div>

