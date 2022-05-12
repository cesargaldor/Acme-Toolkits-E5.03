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
	<acme:list-column code="inventor.item.list.label.type" path="type" width="20%"/>
	<acme:list-column code="inventor.item.list.label.name" path="name" width="20%"/>
	<acme:list-column code="inventor.item.list.label.code" path="code" width="20%"/>
	<acme:list-column code="inventor.item.list.label.technology" path="technology" width="20%"/>
    <acme:list-column code="inventor.item.list.label.retailPrice" path="retailPrice" width="10%"/>
    <acme:list-column code="inventor.item.list.label.published" path="published" width="10%"/>
	
	
</acme:list>

<!-- 
<jstl:if test="${!readonly}">
	<acme:button code="any.component.list.button.create" action="/any/component/create"/>
</jstl:if>
 -->
