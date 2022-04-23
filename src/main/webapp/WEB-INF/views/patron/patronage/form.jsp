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
	<acme:input-textarea code="patron.patronage.form.label.code" path="code" readonly="true"/>
	<acme:input-textbox code="patron.patronage.form.label.legalStuff" path="legalStuff" readonly="true"/>
	<acme:input-money code="patron.patronage.form.label.budget" path="budget" readonly="true"/>
	<acme:input-moment code="patron.patronage.form.label.moment" path="moment" readonly="true"/>			
	<acme:input-url code="patron.patronage.form.label.optionalLink" path="optionalLink" readonly="true"/>
	
	<!--<acme:submit code="patron.patronage.form.label.button.create" action="/patron/patronage/create"/>-->
	
	<!--<jstl:if test="${onlyPatron}">-->	
		<acme:input-select code="patron.patronage.form.label.status" path="status" readonly="true">
			<acme:input-option code="patron.patronage.form.label.status.PROPOSED" value="PROPOSED"/>
			<acme:input-option code="patron.patronage.form.label.status.ACCEPTED" value="ACCEPTED"/>
			<acme:input-option code="patron.patronage.form.label.status.DENIED" value="DENIED"/>
		</acme:input-select>
	<!--</jstl:if>-->
</acme:form>

