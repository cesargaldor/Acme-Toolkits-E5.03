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
	<acme:input-textbox code="employer.duty.form.label.title" path="title"/>
	<acme:input-textarea code="employer.duty.form.label.description" path="description"/>
	<acme:input-double code="employer.duty.form.label.work-load" path="workLoad" placeholder="employer.duty.form.placeholder.work-load"/>
	<acme:input-url code="employer.duty.form.label.moreInfo" path="moreInfo"/>
	
	<jstl:choose>	 
		<jstl:when test="${acme:anyOf(command, 'show, update, delete') && draftMode == 'true'}">
			<acme:submit code="employer.duty.form.button.update" action="/employer/duty/update"/>
			<acme:submit code="employer.duty.form.button.delete" action="/employer/duty/delete"/>
		</jstl:when>
		<jstl:when test="${command == 'create'}">
			<acme:submit code="employer.duty.form.button.create" action="/employer/duty/create"/>
		</jstl:when>		
	</jstl:choose>		
</acme:form>

