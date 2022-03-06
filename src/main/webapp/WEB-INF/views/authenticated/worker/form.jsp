<%--
- form.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textarea code="authenticated.worker.worker.form.label.qualifications" path="qualifications"/>
	<acme:input-textarea code="authenticated.worker.worker.form.label.skills" path="skills"/>
	
	<acme:submit test="${command == 'create'}" code="authenticated.worker.worker.form.button.create" action="/authenticated/worker/create"/>
	<acme:submit test="${command == 'update'}" code="authenticated.worker.worker.form.button.update" action="/authenticated/worker/update"/>
</acme:form>
