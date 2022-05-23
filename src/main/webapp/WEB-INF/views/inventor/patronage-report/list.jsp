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
	<acme:list-column code="inventor.patronageReport.list.label.numSeq" path="numSeq" width="20%"/>
	<acme:list-column code="inventor.patronageReport.list.label.creationMoment" path="creationMoment" width="20%"/>
</acme:list>

<acme:button code="inventor.patronageReport.list.label.button.create" action="/inventor/patronage-report/create"/>
