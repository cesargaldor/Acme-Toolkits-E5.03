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
	
		<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish')}">
			<acme:input-select code="patron.patronage.form.label.status" path="status">
				<acme:input-option code="PROPOSED" value="PROPOSED" selected="${status == 'PROPOSED'}" />
				<acme:input-option code="ACCEPTED" value="ACCEPTED" selected="${status == 'ACCEPTED'}" />
				<acme:input-option code="DENIED" value="DENIED" selected="${status == 'DENIED'}" />
			</acme:input-select>	    
		</jstl:when>
	</jstl:choose>
	
	<jstl:choose>
		<jstl:when test="${command == 'create'}">	
	    	<acme:input-textbox code="patron.patronage.form.label.code" path="code"/>
	    </jstl:when>
	    
	    <jstl:when test="${acme:anyOf(command, 'show, update, delete, publish')}">
	    	<acme:input-textbox code="patron.patronage.form.label.code" path="code" readonly="${true}"/>
	    </jstl:when>
	</jstl:choose>
	
	<acme:input-textbox code="patron.patronage.form.label.legalStuff" path="legalStuff"/>
	<acme:input-money code="patron.patronage.form.label.budget" path="budget"/>
	<acme:input-moment code="patron.patronage.form.label.moment" path="moment"/>			
	<acme:input-url code="patron.patronage.form.label.optionalLink" path="optionalLink"/>
	<jstl:choose>
		<jstl:when test="${command == 'create'}">		
			<acme:input-textbox code="patron.patronage.form.label.inventor.username" path="username"/>
		</jstl:when>
		
		<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish')}">
			<acme:input-textbox code="patron.patronage.form.label.inventor.username" path="username" readonly="${true}"/>
		  	<acme:input-textbox code="patron.patronage.form.label.inventor.name" path="fullName" readonly="${true}"/>
		    <acme:input-email code="patron.patronage.form.label.inventor.email" path="email" readonly="${true}"/>
		</jstl:when>
	</jstl:choose>
	<acme:submit code="patron.patronage.form.label.button.delete" action="/patron/patronage/delete"/>
	<jstl:choose>
		<jstl:when test="${command == 'create'}">
	    	<acme:submit code="patron.patronage.form.label.button.create" action="/patron/patronage/create"/>
	    </jstl:when>
	</jstl:choose>
	
	<jstl:if test="${!readonly}">
		<acme:submit code="patron.patronage.form.label.button.update" action="/patron/patronage/update"/>
	</jstl:if>
		 <%--
	
	<jstl:choose>
		<jstl:when test="${acme:anyOf(command, 'show') && !isPublish}">
	    	<acme:submit code="patron.patronage.form.label.button.publish" action="/patron/patronage/publish"/>
		</jstl:when>
	</jstl:choose>
	 	 --%>
	 

	<jstl:if test="${!isPublish && !readonly}">
		<acme:submit code="patron.patronage.form.label.button.publish" action="/patron/patronage/publish"/>
	</jstl:if>

	
</acme:form>

