<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-moment code="anonymous.chirp.form.label.moment" path="moment"/>
	<acme:input-textbox code="anonymous.chirp.form.label.title" path="title"/>
	<acme:input-textbox code="anonymous.chirp.form.label.author" path="author"/>
	<acme:input-textarea code="anonymous.chirp.form.label.body" path="body"/>
	<acme:input-email code="anonymous.chirp.form.label.email" path="email"/>
	
	<acme:submit code="anonymous.chirp.form.button.create" action="/anonymous/chirp/create"/>
</acme:form>
