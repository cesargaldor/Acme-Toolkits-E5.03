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
	<acme:hidden-data path="masterId"/>

	<acme:input-textbox code="worker.application.label.reference" path="reference" readonly="true"/>
	<jstl:if test="${command == 'show'}">
		<acme:input-textbox code="worker.application.label.moment" path="moment"/>
		<acme:input-textbox code="worker.application.label.status" path="status"/>
	</jstl:if>	
	<acme:input-textarea code="worker.application.label.statement" path="statement"/>
	<acme:input-textarea code="worker.application.label.qualifications" path="qualifications"/>
	<acme:input-textarea code="worker.application.label.skills" path="skills"/>	
			
	<acme:submit test="${command == 'create'}" code="worker.application.button.create" action="/worker/application/create"/>		
</acme:form>

