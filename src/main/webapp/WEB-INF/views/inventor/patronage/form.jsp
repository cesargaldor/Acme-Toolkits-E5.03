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
	<acme:input-textarea code="inventor.patronage.form.label.code" path="code" readonly="${true}"/>
	<acme:input-textbox code="inventor.patronage.form.label.legalStuff" path="legalStuff" readonly="${true}"/>
	<acme:input-money code="inventor.patronage.form.label.budget" path="budget" readonly="${true}"/>
	<acme:input-moment code="inventor.patronage.form.label.moment" path="moment" readonly="${true}"/>
	<acme:input-textbox code="inventor.patronage.form.label.patron.username" path="username" readonly="${true}"/>
	<acme:input-email code="inventor.patronage.form.label.patron.email" path="email" readonly="${true}"/>			
	<acme:input-textbox code="inventor.patronage.form.label.patron.fullName" path="username" readonly="${true}"/>			
	<acme:input-url code="inventor.patronage.form.label.optionalLink" path="optionalLink" readonly="${true}"/>
	
	
	<jstl:choose>
		<jstl:when test="${acme:anyOf(command, 'show, update')}">
			<acme:input-select code="inventor.patronage.form.label.status" path="status">
				<acme:input-option code="inventor.patronage.form.label.status.ACCEPTED" value="ACCEPTED"/>
				<acme:input-option code="inventor.patronage.form.label.status.DENIED" value="DENIED"/>
			</acme:input-select>		
			<acme:submit code="inventor.patronage.form.label.button.update" action="/inventor/patronage/update"/>					
		</jstl:when>
	</jstl:choose>	
			
	
	
	<%-- 
	<jstl:if test="${}">
	
	
	
	</jstl:if>
	
	--%>
</acme:form>

