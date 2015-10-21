<%@ page import="net.sf.bpm.implicit.Weaver" %>


%{--<div class="control-group ${hasErrors(bean: weaverInstance, field: 'act.appName', 'error')}  col-xs-12">--}%
    %{--<label class="control-label" for="appName">--}%
        %{--<g:message code="application.label" default="Application" />--}%
        %{--<span class="required-indicator">*</span>--}%
    %{--</label>--}%
    %{--<div class="controls">--}%
        %{--<g:textField name="appName" maxlength="50" required="" value="${weaverInstance?.appName}" />--}%

    %{--</div>--}%
%{--</div>--}%

<div class="control-group ${hasErrors(bean: weaverInstance, field: 'inputDSL', 'error')} required col-xs-12">
    <label class="control-label" for="inputDSL">
        <g:message code="weaver.inputDSL" default="DSL Input" />
        <span class="required-indicator">*</span>
    </label>
    <div class="controls">
        <g:textArea name="inputDSL" rows="10" value="${weaverInstance?.inputDSL}"/>
    </div>
</div>