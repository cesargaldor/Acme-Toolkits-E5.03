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

	<jstl:choose>
		<jstl:when test="${command == 'create'}">
			<acme:input-textbox code="inventor.chimpum.form.label.code"
				path="code" placeholder="ABC-123-A" />
		</jstl:when>
		<jstl:otherwise>
			<acme:input-textbox code="inventor.chimpum.form.label.code"
				path="code" placeholder="ABC-123-A" readonly="true" />
		</jstl:otherwise>
	</jstl:choose>

	<acme:input-textbox code="inventor.chimpum.form.label.title"
		path="title" />
	<acme:input-textarea code="inventor.chimpum.form.label.description"
		path="description" />
	<jstl:if test="${command == 'update'}">
		<acme:input-moment code="inventor.chimpum.form.label.creationMoment"
		path="creationMoment" readonly="true"/>
	</jstl:if>
	<acme:input-moment code="inventor.chimpum.form.label.startDate"
		path="startDate" />
	<acme:input-moment code="inventor.chimpum.form.label.endDate"
		path="endDate" />
	<acme:input-money code="inventor.chimpum.form.label.budget"
		path="budget" />
	<acme:input-url code="inventor.chimpum.form.label.optionalLink"
		path="optionalLink" />

	<jstl:choose>
		<jstl:when
			test="${acme:anyOf(command, 'show, update, delete, publish') && published == false}">
			<acme:submit code="inventor.chimpum.form.button.update"
				action="/inventor/chimpum/update" />
			<acme:submit code="inventor.chimpum.form.button.delete"
				action="/inventor/chimpum/delete" />
		</jstl:when>
		<jstl:when test="${command == 'create'}">
			<acme:submit code="inventor.chimpum.form.button.create"
				action="/inventor/chimpum/create?masterId=${masterId}" />
		</jstl:when>
	</jstl:choose>
	<jstl:when test="${command == 'show'}">
		<acme:button code="inventor.chimpum.form.button.item"
			action="/inventor/item/show?id=${masterId}" />
	</jstl:when>
	
</acme:form>