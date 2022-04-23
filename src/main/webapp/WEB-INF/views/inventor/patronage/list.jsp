<%--
- list.jsp
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

<acme:list readonly="false">
	<acme:list-column code="inventor.patronage.list.label.status" path="status" width="14%"/>
	<acme:list-column code="inventor.patronage.list.label.code" path="code" width="14%"/>
	<acme:list-column code="inventor.patronage.list.label.legalStuff" path="legalStuff" width="14%"/>
	<acme:list-column code="inventor.patronage.list.label.budget" path="budget" width="14%"/>
	<acme:list-column code="inventor.patronage.list.label.moment" path="moment" width="14%"/>
	<acme:list-column code="inventor.patronage.list.label.optionalLink" path="optionalLink" width="14%"/>
	<acme:list-column code="patron.patronage.list.label.inventor" path="inventor" width="14%"/>-->
</acme:list>
<!-- <acme:button code="inventor.patronage.list.label.button.create" action="/inventor/patronage/create"/> -->
