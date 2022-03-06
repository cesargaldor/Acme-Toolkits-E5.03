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

<acme:form readonly="true">
	<acme:input-textbox code="worker.job.form.label.reference" path="reference"/>
	<acme:input-textbox code="worker.job.form.label.title" path="title"/>
	<acme:input-moment code="worker.job.form.label.deadline" path="deadline"/>	
	<acme:input-money code="worker.job.form.label.salary" path="salary"/>
	<acme:input-money code="worker.job.form.label.score" path="score"/>
	<acme:input-url code="worker.job.form.label.more-info" path="moreInfo"/>
	<acme:input-textarea code="worker.job.form.label.description" path="description"/>
	
	<acme:button code="worker.job.form.button.duties" action="/worker/duty/list?masterId=${id}"/>
	<acme:button code="worker.job.form.button.apply" action="/worker/application/create?masterId=${id}"/>
</acme:form>

