<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="administrator.configuration.form.label.default-currency" path="sysCurrency"/>
    <acme:input-textbox code="administrator.configuration.form.label.accepted-currencies" path="allowedCurrencies"/>
    <acme:input-textbox code="administrator.configuration.form.label.strong-spam-terms" path="strongSpam"/>
    <acme:input-double code="administrator.configuration.form.label.strong-spam-threshold" path="strongThreshold"/>
    <acme:input-textbox code="administrator.configuration.form.label.weak-spam-words" path="weakSpam"/>
    <acme:input-double code="administrator.configuration.form.label.weak-spam-threshold" path="weakThreshold"/>
	<acme:submit code="administrator.configuration.form.button.update" action="/administrator/configuration/update"/>

<%-- 

	<jstl:choose>
		<jstl:when test="${acme:anyOf(command, 'show, update')}">
		
			<acme:submit code="administrator.Configuration.form.button.update" action="/administrator/configuration/update"/>
		
		</jstl:when>
	
	
	
	</jstl:choose>

	<acme:submit test="${acme:anyOf(command, 'show, update')}" code="administrator.Configuration.form.button.update" 
	action="/administrator/configuration/update"/>
--%>

</acme:form>