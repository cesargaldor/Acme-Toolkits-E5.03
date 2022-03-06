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
	<acme:input-textbox code="employer.job.form.label.reference" path="reference"/>
	<acme:input-textbox code="employer.job.form.label.title" path="title"/>
	<acme:input-moment code="employer.job.form.label.deadline" path="deadline"/>
	<acme:input-money code="employer.job.form.label.salary" path="salary"/>
	<acme:input-double code="employer.job.form.label.score" path="score" placeholder="employer.job.form.placeholder.score"/>
	<acme:input-url code="employer.job.form.label.more-info" path="moreInfo"/>
	<acme:input-textarea code="employer.job.form.label.description" path="description"/>

	<jstl:choose>	 
		<jstl:when test="${acme:anyOf(command, 'show') && draftMode == false}">
			<acme:button code="employer.job.form.button.duties" action="/employer/duty/list?masterId=${id}"/>			
		</jstl:when>
		<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish') && draftMode == true}">
			<acme:button code="employer.job.form.button.duties" action="/employer/duty/list?masterId=${id}"/>
			<acme:submit code="employer.job.form.button.update" action="/employer/job/update"/>
			<acme:submit code="employer.job.form.button.delete" action="/employer/job/delete"/>
			<acme:submit code="employer.job.form.button.publish" action="/employer/job/publish"/>
		</jstl:when>
		<jstl:when test="${acme:anyOf(command, 'create')}">
			<acme:submit code="employer.job.form.button.create" action="/employer/job/create"/>
		</jstl:when>		
	</jstl:choose>
</acme:form>
