<div class="sidebar sidebar-fixed" id="sidebar">
	<ul class="nav nav-list">
		<li class="sidebar-app-title sidebar-appsti" id="app-title">Manager</li>
		<li><a href="${createLink(uri: '/')}"><i class="icon-dashboard"></i> <span class="menu-text"><g:message code="default.home.label" /></span></a></li>
		<li><g:link controller="remoteApp" action="index"><i class="icon-check"></i> <span class="menu-text">Remote Apps</span></g:link></li>
        <li><g:link controller="deployUnit" action="index"><i class="icon-cloud-upload"></i> <span class="menu-text">Deploy Units</span></g:link></li>
 	</ul>
    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
    </div>
</div>

