
<%@ page import="accounting.Customer" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-customer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<ul class="nav nav-pills breadcrumb">
			<li><a class="home" href="${createLink(uri: '/')}"><i class="icon-home"></i> <g:message code="default.home.label"/></a></li>
			<li><g:link class="list" action="list"><i class="icon-list"></i> <g:message code="default.list.label" args="[entityName]" /></g:link></li>
			<li><g:link class="create" action="create"><i class="icon-plus-sign"/></i> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
		</ul>		
		<div id="show-customer" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">				
				<div class="alert alert-info message" role="status"><button data-dismiss="alert" class="close" type="button">×</button>${flash.message}</div>
			</g:if>		
			<div class="form-horizontal">
				<fieldset>

                    <g:if test="${customerInstance?.name}">
                        <div class="control-group">
                            <label class="property-key"><g:message code="customer.name.label" default="Name" /></label>

                            <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${customerInstance}" field="name"/></span>

                        </div>
                    </g:if>

				<g:if test="${customerInstance?.surname}">
					<div class="control-group">
					<label class="property-key"><g:message code="customer.surname.label" default="Surname" /></label>					
					
						<span class="property-value" aria-labelledby="surname-label"><g:fieldValue bean="${customerInstance}" field="surname"/></span>
					
					</div>
				</g:if>


                    <g:if test="${customerInstance?.nin}">
                        <div class="control-group">
                            <label class="property-key"><g:message code="customer.nin.label" default="Nin" /></label>

                            <span class="property-value" aria-labelledby="nin-label"><g:fieldValue bean="${customerInstance}" field="nin"/></span>

                        </div>
                    </g:if>

                    <g:if test="${customerInstance?.email}">
                        <div class="control-group">
                            <label class="property-key"><g:message code="customer.email.label" default="Email" /></label>

                            <span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${customerInstance}" field="email"/></span>

                        </div>
                    </g:if>


                    <g:if test="${customerInstance?.address}">
                        <div class="control-group">
                            <label class="property-key"><g:message code="customer.address.label" default="Address" /></label>

                            <span class="property-value" aria-labelledby="address-label"><g:fieldValue bean="${customerInstance}" field="address"/></span>

                        </div>
                    </g:if>
			
				<g:if test="${customerInstance?.phone}">
					<div class="control-group">
					<label class="property-key"><g:message code="customer.phone.label" default="Phone" /></label>
					
						<span class="property-value" aria-labelledby="phone-label"><g:fieldValue bean="${customerInstance}" field="phone"/></span>
					
					</div>
				</g:if>

                    <g:if test="${customerInstance?.purchase}">
                        <div class="control-group">
                            <label class="property-key"><g:message code="customer.purchase.label" default="Purchase" /></label>

                            <g:each in="${customerInstance.purchase}" var="p">
                                <span class="property-value" aria-labelledby="purchase-label"><g:link controller="purchase" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
                            </g:each>

                        </div>
                    </g:if>
			
				</fieldset>
			</div>
			<g:form>		
				<div class="form-actions">
					<g:hiddenField name="id" value="${customerInstance?.id}" />
					<g:link class="edit btn" action="edit" id="${customerInstance?.id}">
						<i class="icon-trash icon-pencil"></i> 
						<g:message code="default.button.edit.label" default="Edit" />					
					</g:link>
					<button type="submit" name="_action_delete" class="btn btn-danger delete" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">
						<i class="icon-trash icon-white"></i> 
						${message(code: 'default.button.delete.label', default: 'Delete')}
					</button>					
				</div>
			</g:form>
		</div>
	</body>
</html>
