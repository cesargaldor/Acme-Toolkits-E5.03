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
	<acme:input-textbox code="Inventor.Item.form.label.legalStuff" path="legalStuff"/>
	<acme:input-money code="Inventor.Item.form.label.budget" path="budget"/>
	<acme:input-moment code="Inventor.Item.form.label.moment" path="moment"/>			
	<acme:input-url code="Inventor.Item.form.label.optionalLink" path="optionalLink"/>
	<jstl:choose>
		<jstl:when test="${command == 'create'}">
			<acme:input-textarea code="Inventor.Item.form.label.code" path="code"/>
			<acme:input-textbox code="Inventor.Item.form.label.legalStuff" path="legalStuff"/>
			<acme:input-money code="Inventor.Item.form.label.budget" path="budget"/>
			<acme:input-moment code="Inventor.Item.form.label.moment" path="moment"/>			
			<acme:input-url code="Inventor.Item.form.label.optionalLink" path="optionalLink"/>
			<acme:input-textbox code="Inventor.Item.form.label.inventor.username" path="username"/>
			<acme:input-email code="Inventor.Item.form.label.inventor.email" path="email"/>
			<acme:input-textbox code="Inventor.Item.form.label.inventor.fullName" path="fullName"/>
			<acme:input-select code="Inventor.Item.form.label.status" path="status" readonly="true">
				<acme:input-option code="Inventor.Item.form.label.status.PROPOSED" value="PROPOSED"/>
				<acme:input-option code="Inventor.Item.form.label.status.ACCEPTED" value="ACCEPTED"/>
				<acme:input-option code="Inventor.Item.form.label.status.DENIED" value="DENIED"/>
			</acme:input-select>
			<acme:submit code="Inventor.Item.form.label.button.create" action="/Inventor/Item/create"/>
		</jstl:when>
		
		<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish')}">		
			<acme:input-textarea code="Inventor.Item.form.label.code" path="code" readonly="true"/>
			<acme:input-textbox code="Inventor.Item.form.label.inventor.username" path="username" readonly="true"/>
			<acme:input-email code="Inventor.Item.form.label.inventor.email" path="email" readonly="true"/>
			<acme:input-textbox code="Inventor.Item.form.label.inventor.fullName" path="fullName" readonly="true"/>
			<acme:input-select code="Inventor.Item.form.label.status" path="status" readonly="true">
				<acme:input-option code="Inventor.Item.form.label.status.PROPOSED" value="PROPOSED"/>
				<acme:input-option code="Inventor.Item.form.label.status.ACCEPTED" value="ACCEPTED"/>
				<acme:input-option code="Inventor.Item.form.label.status.DENIED" value="DENIED"/>
			</acme:input-select>
			<acme:submit code="Inventor.Item.form.label.button.update" action="/Inventor/Item/update"/>
			<acme:submit code="Inventor.Item.form.label.button.delete" action="/Inventor/Item/delete"/>
			
		</jstl:when>
	
    	<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish') && !isPublished}">
    		<acme:submit code="Inventor.Item.form.button.update" action="/Inventor/Item/update"/>
    		<acme:submit code="Inventor.Item.form.button.delete" action="/Inventor/Item/delete"/>
    		<acme:submit code="Inventor.Item.form.button.publish" action="/Inventor/Item/publish"/>
    	</jstl:when>
    	
    	
	
		
		
	</jstl:choose>
	

	
--%>

<jstl:choose>
	<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish')}">
		<acme:input-select code="Inventor.Item.form.label.status" path="status" readonly="${true}">
			<acme:input-option code="PROPOSED" value="PROPOSED" selected="${status == 'PROPOSED'}"/>
			<acme:input-option code="ACCEPTED" value="ACCEPTED" selected="${status == 'ACCEPTED'}"/>
			<acme:input-option code="DENIED" value="DENIED" selected="${status == 'DENIED'}"/>
		</acme:input-select>
	</jstl:when>
</jstl:choose>

<jstl:choose>
	<jstl:when test="${command == 'create'}">	
    	<acme:input-textbox code="Inventor.Item.form.label.code" path="code"/>
    </jstl:when>
    
    <jstl:when test="${acme:anyOf(command, 'show, update, delete, publish')}">
    	<acme:input-textbox code="Inventor.Item.form.label.code" path="code" readonly="${true}"/>
    </jstl:when>
</jstl:choose>
<acme:input-textbox code="Inventor.Item.form.label.legalStuff" path="legalStuff"/>
<acme:input-money code="Inventor.Item.form.label.budget" path="budget"/>
<acme:input-moment code="Inventor.Item.form.label.moment" path="moment"/>			
<acme:input-url code="Inventor.Item.form.label.optionalLink" path="optionalLink"/>
<jstl:choose>
	<jstl:when test="${command == 'create'}">		
		<acme:input-textbox code="Inventor.Item.form.label.inventor.username" path="username"/>
	</jstl:when>
	<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish')}">
		<acme:input-textbox code="Inventor.Item.form.label.inventor.username" path="username" readonly="${true}"/>
	  	<acme:input-textbox code="Inventor.Item.form.label.inventor.name" path="fullName" readonly="${true}"/>
	    <acme:input-email code="Inventor.Item.form.label.inventor.email" path="email" readonly="${true}"/>
	</jstl:when>
</jstl:choose>

<jstl:choose>
	<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish') && !isPublished}">
    	<acme:submit code="Inventor.Item.form.label.button.update" action="/Inventor/Item/update"/>
    		<acme:submit code="Inventor.Item.form.label.button.delete" action="/Inventor/Item/delete"/>
    		<acme:submit code="Inventor.Item.form.label.button.publish" action="/Inventor/Item/publish"/>
    </jstl:when>
    <jstl:when test="${command == 'create'}">
    		<acme:submit code="Inventor.Item.form.label.button.create" action="/Inventor/Item/create"/>
    </jstl:when>
</jstl:choose>

	
</acme:form>

