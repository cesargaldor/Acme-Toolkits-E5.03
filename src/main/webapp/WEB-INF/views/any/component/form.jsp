<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="any.component.form.label.name" path="name"/>
	<acme:input-textbox code="any.component.form.label.code" path="code"/>
	<acme:input-textbox code="any.component.form.label.technology" path="technology"/>
	<acme:input-textarea code="any.component.form.label.description" path="description"/>
	<acme:input-double code="any.component.form.label.retailPrice" path="retailPrice"/>
	<acme:input-url code="any.component.form.label.optionalLink" path="optionalLink"/>
	<!--<acme:input-textbox code="any.component.form.label.inventor" path="component.inventor"/>-->
	
	<jstl:if test="${!onlyInventor}">
		<acme:submit code="any.component.form.button.create" action="/any/component/create"/>
	</jstl:if>
</acme:form>
