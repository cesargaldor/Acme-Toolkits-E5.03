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
	<acme:input-textbox code="anonymous.job.form.label.reference" path="reference"/>
	<acme:input-textbox code="anonymous.job.form.label.title" path="title"/>
	<acme:input-moment code="anonymous.job.form.label.deadline" path="deadline"/>
	<acme:input-money code="anonymous.job.form.label.salary" path="salary"/>
	<acme:input-money code="anonymous.job.form.label.score" path="score"/>
	<acme:input-url code="anonymous.job.form.label.more-info" path="moreInfo"/>
	<acme:input-textarea code="anonymous.job.form.label.description" path="description"/>
	
	<acme:button code="anonymous.job.form.button.duties" action="/anonymous/duty/list?masterId=${id}"/>
</acme:form>
