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

<jstl:if test="${onlyInventor}">	

	<acme:form readonly="${readonly}">
		<acme:input-textarea code="patron.patronage.form.label.code" path="code"/>
		<acme:input-textbox code="patron.patronage.form.label.legalStuff" path="legalStuff"/>
		<acme:input-money code="patron.patronage.form.label.budget" path="budget"/>
		<acme:input-moment code="patron.patronage.form.label.moment" path="moment"/>			
		<acme:input-url code="patron.patronage.form.label.optionalLink" path="optionalLink"/>
		<acme:input-select code="patron.patronage.form.label.status" path="status">
			<acme:input-option code="patron.patronage.form.label.status.PROPOSED" value="PROPOSED"/>
			<acme:input-option code="patron.patronage.form.label.status.ACCEPTED" value="ACCEPTED"/>
			<acme:input-option code="patron.patronage.form.label.status.DENIED" value="DENIED"/>
		</acme:input-select>
	</acme:form>		
</jstl:if>

	 


