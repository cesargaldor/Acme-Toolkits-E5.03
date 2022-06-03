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
	<acme:input-textbox code="inventor.item.form.label.name" path="name"/>
	<acme:input-textbox code="inventor.item.form.label.code" path="code"/>
	<acme:input-textbox code="inventor.item.form.label.technology" path="technology"/>
	<acme:input-textbox code="inventor.item.form.label.description" path="description"/>
	<acme:input-money code="inventor.item.form.label.retailPrice" path="retailPrice"/>
	<acme:input-url code="inventor.item.form.label.optionalLink" path="optionalLink"/>
	
	
	
	<jstl:if test="${command == 'create'}">
		<acme:submit code="inventor.item.form.button.create" action="/inventor/item/create?type=${type}"/>
	</jstl:if>
	
	
	<jstl:if test="${acme:anyOf(command, 'show, update, delete, publish') && published == 'false'}">
		<acme:submit code="inventor.item.form.button.update" action="/inventor/item/update"/>
		<acme:submit code="inventor.item.form.button.publish" action="/inventor/item/publish"/>
		<acme:submit code="inventor.item.form.button.delete" action="/inventor/item/delete"/>
		<jstl:if test="${chimpum eq null}">
				<acme:button code="inventor.item.form.button.create-chimpum" action="/inventor/chimpum/create?masterId=${id}" />
		</jstl:if>
	</jstl:if>
	
	<jstl:if test="${command == 'show'}">
		<jstl:if test="${!(chimpum eq null)}">
			<acme:button code="inventor.item.form.button.chimpum" action="/inventor/chimpum/show?id=${chimpum.id}"/>
		</jstl:if>
	</jstl:if>
	
</acme:form> 

