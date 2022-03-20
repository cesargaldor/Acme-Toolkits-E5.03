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
	<acme:input-textbox code="anonymous.patronage.form.label.status" path="status"/>
	<acme:input-textarea code="anonymous.patronage.form.label.code" path="code"/>
	<acme:input-moment code="anonymous.patronage.form.label.legalStuff" path="legalStuff"/>
	<acme:input-url code="anonymous.patronage.form.label.budget" path="budget"/>
	<acme:input-url code="anonymous.patronage.form.label.moment" path="moment"/>			
	<acme:input-url code="anonymous.patronage.form.label.optionalLink" path="optionalLink"/>
	
	<acme:submit code="anonymous.patronage.form.button.create" action="/anonymous/patronage/create"/>	
</acme:form>

