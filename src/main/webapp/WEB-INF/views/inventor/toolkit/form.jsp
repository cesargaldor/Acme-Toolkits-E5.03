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

<%-- 
	<acme:input-textbox code="Inventor.Toolkit.form.label.legalStuff" path="legalStuff"/>
	<acme:input-money code="Inventor.Toolkit.form.label.budget" path="budget"/>
	<acme:input-moment code="Inventor.Toolkit.form.label.moment" path="moment"/>			
	<acme:input-url code="Inventor.Toolkit.form.label.optionalLink" path="optionalLink"/>
	<jstl:choose>
		<jstl:when test="${command == 'create'}">
			<acme:input-textarea code="Inventor.Toolkit.form.label.code" path="code"/>
			<acme:input-textbox code="Inventor.Toolkit.form.label.legalStuff" path="legalStuff"/>
			<acme:input-money code="Inventor.Toolkit.form.label.budget" path="budget"/>
			<acme:input-moment code="Inventor.Toolkit.form.label.moment" path="moment"/>			
			<acme:input-url code="Inventor.Toolkit.form.label.optionalLink" path="optionalLink"/>
			<acme:input-textbox code="Inventor.Toolkit.form.label.inventor.username" path="username"/>
			<acme:input-email code="Inventor.Toolkit.form.label.inventor.email" path="email"/>
			<acme:input-textbox code="Inventor.Toolkit.form.label.inventor.fullName" path="fullName"/>
			<acme:input-select code="Inventor.Toolkit.form.label.status" path="status" readonly="true">
				<acme:input-option code="Inventor.Toolkit.form.label.status.PROPOSED" value="PROPOSED"/>
				<acme:input-option code="Inventor.Toolkit.form.label.status.ACCEPTED" value="ACCEPTED"/>
				<acme:input-option code="Inventor.Toolkit.form.label.status.DENIED" value="DENIED"/>
			</acme:input-select>
			<acme:submit code="Inventor.Toolkit.form.label.button.create" action="/Inventor/Toolkit/create"/>
		</jstl:when>
		
		<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish')}">		
			<acme:input-textarea code="Inventor.Toolkit.form.label.code" path="code" readonly="true"/>
			<acme:input-textbox code="Inventor.Toolkit.form.label.inventor.username" path="username" readonly="true"/>
			<acme:input-email code="Inventor.Toolkit.form.label.inventor.email" path="email" readonly="true"/>
			<acme:input-textbox code="Inventor.Toolkit.form.label.inventor.fullName" path="fullName" readonly="true"/>
			<acme:input-select code="Inventor.Toolkit.form.label.status" path="status" readonly="true">
				<acme:input-option code="Inventor.Toolkit.form.label.status.PROPOSED" value="PROPOSED"/>
				<acme:input-option code="Inventor.Toolkit.form.label.status.ACCEPTED" value="ACCEPTED"/>
				<acme:input-option code="Inventor.Toolkit.form.label.status.DENIED" value="DENIED"/>
			</acme:input-select>
			<acme:submit code="Inventor.Toolkit.form.label.button.update" action="/Inventor/Toolkit/update"/>
			<acme:submit code="Inventor.Toolkit.form.label.button.delete" action="/Inventor/Toolkit/delete"/>
			
		</jstl:when>
	
    	<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish') && !isPublished}">
    		<acme:submit code="Inventor.Toolkit.form.button.update" action="/Inventor/Toolkit/update"/>
    		<acme:submit code="Inventor.Toolkit.form.button.delete" action="/Inventor/Toolkit/delete"/>
    		<acme:submit code="Inventor.Toolkit.form.button.publish" action="/Inventor/Toolkit/publish"/>
    	</jstl:when>
    	
    	
	
		
		
	</jstl:choose>
	

	
--%>

<jstl:choose>
	<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish')}">
		<acme:input-select code="Inventor.Toolkit.form.label.status" path="status" readonly="${true}">
			<acme:input-option code="PROPOSED" value="PROPOSED" selected="${status == 'PROPOSED'}"/>
			<acme:input-option code="ACCEPTED" value="ACCEPTED" selected="${status == 'ACCEPTED'}"/>
			<acme:input-option code="DENIED" value="DENIED" selected="${status == 'DENIED'}"/>
		</acme:input-select>
	</jstl:when>
</jstl:choose>

<jstl:choose>
	<jstl:when test="${command == 'create'}">	
    	<acme:input-textbox code="Inventor.Toolkit.form.label.code" path="code"/>
    </jstl:when>
    
    <jstl:when test="${acme:anyOf(command, 'show, update, delete, publish')}">
    	<acme:input-textbox code="Inventor.Toolkit.form.label.code" path="code" readonly="${true}"/>
    </jstl:when>
</jstl:choose>
<acme:input-textbox code="Inventor.Toolkit.form.label.legalStuff" path="legalStuff"/>
<acme:input-money code="Inventor.Toolkit.form.label.budget" path="budget"/>
<acme:input-moment code="Inventor.Toolkit.form.label.moment" path="moment"/>			
<acme:input-url code="Inventor.Toolkit.form.label.optionalLink" path="optionalLink"/>
<jstl:choose>
	<jstl:when test="${command == 'create'}">		
		<acme:input-textbox code="Inventor.Toolkit.form.label.inventor.username" path="username"/>
	</jstl:when>
	<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish')}">
		<acme:input-textbox code="Inventor.Toolkit.form.label.inventor.username" path="username" readonly="${true}"/>
	  	<acme:input-textbox code="Inventor.Toolkit.form.label.inventor.name" path="fullName" readonly="${true}"/>
	    <acme:input-email code="Inventor.Toolkit.form.label.inventor.email" path="email" readonly="${true}"/>
	</jstl:when>
</jstl:choose>

<jstl:choose>
	<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish') && !isPublished}">
    	<acme:submit code="Inventor.Toolkit.form.label.button.update" action="/Inventor/Toolkit/update"/>
    		<acme:submit code="Inventor.Toolkit.form.label.button.delete" action="/Inventor/Toolkit/delete"/>
    		<acme:submit code="Inventor.Toolkit.form.label.button.publish" action="/Inventor/Toolkit/publish"/>
    </jstl:when>
    <jstl:when test="${command == 'create'}">
    		<acme:submit code="Inventor.Toolkit.form.label.button.create" action="/Inventor/Toolkit/create"/>
    </jstl:when>
</jstl:choose>

	
</acme:form>

