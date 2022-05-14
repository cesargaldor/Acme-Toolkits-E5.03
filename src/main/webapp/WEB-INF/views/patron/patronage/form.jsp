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
	<acme:input-textbox code="patron.patronage.form.label.legalStuff" path="legalStuff"/>
	<acme:input-money code="patron.patronage.form.label.budget" path="budget"/>
	<acme:input-moment code="patron.patronage.form.label.moment" path="moment"/>			
	<acme:input-url code="patron.patronage.form.label.optionalLink" path="optionalLink"/>
	<jstl:choose>
		<jstl:when test="${command == 'create'}">
			<acme:input-textarea code="patron.patronage.form.label.code" path="code"/>
			<acme:input-textbox code="patron.patronage.form.label.legalStuff" path="legalStuff"/>
			<acme:input-money code="patron.patronage.form.label.budget" path="budget"/>
			<acme:input-moment code="patron.patronage.form.label.moment" path="moment"/>			
			<acme:input-url code="patron.patronage.form.label.optionalLink" path="optionalLink"/>
			<acme:input-textbox code="patron.patronage.form.label.inventor.username" path="username"/>
			<acme:input-email code="patron.patronage.form.label.inventor.email" path="email"/>
			<acme:input-textbox code="patron.patronage.form.label.inventor.fullName" path="fullName"/>
			<acme:input-select code="patron.patronage.form.label.status" path="status" readonly="true">
				<acme:input-option code="patron.patronage.form.label.status.PROPOSED" value="PROPOSED"/>
				<acme:input-option code="patron.patronage.form.label.status.ACCEPTED" value="ACCEPTED"/>
				<acme:input-option code="patron.patronage.form.label.status.DENIED" value="DENIED"/>
			</acme:input-select>
			<acme:submit code="patron.patronage.form.label.button.create" action="/patron/patronage/create"/>
		</jstl:when>
		
		<jstl:when test="${acme:anyOf(command, 'show, update, delete')}">		
			<acme:input-textarea code="patron.patronage.form.label.code" path="code" readonly="true"/>
			<acme:input-textbox code="patron.patronage.form.label.inventor.username" path="username" readonly="true"/>
			<acme:input-email code="patron.patronage.form.label.inventor.email" path="email" readonly="true"/>
			<acme:input-textbox code="patron.patronage.form.label.inventor.fullName" path="fullName" readonly="true"/>
			<acme:input-select code="patron.patronage.form.label.status" path="status" readonly="true">
				<acme:input-option code="patron.patronage.form.label.status.PROPOSED" value="PROPOSED"/>
				<acme:input-option code="patron.patronage.form.label.status.ACCEPTED" value="ACCEPTED"/>
				<acme:input-option code="patron.patronage.form.label.status.DENIED" value="DENIED"/>
			</acme:input-select>
			<acme:submit code="patron.patronage.form.label.button.update" action="/patron/patronage/update"/>
			<acme:submit code="patron.patronage.form.label.button.delete" action="/patron/patronage/delete"/>
			
		</jstl:when>
		
	
		
		
	</jstl:choose>
	

	

	
</acme:form>

