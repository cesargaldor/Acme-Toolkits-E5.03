<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="any.userAccount.form.label.username" path="username"/>
	<acme:input-textbox code="any.userAccount.form.label.name" path="identity.name"/>	
	<acme:input-textbox code="any.userAccount.form.label.surname" path="identity.surname"/>	
	<acme:input-email code="any.userAccount.form.label.email" path="identity.email"/>	
</acme:form>
