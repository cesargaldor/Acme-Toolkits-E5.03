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

<acme:form readonly="${readonly}">
	<acme:input-moment code="administrator.announcement.form.label.moment" path="moment"/>	
	<acme:input-textarea code="administrator.announcement.form.label.title" path="title"/>	
	<acme:input-textbox code="administrator.announcement.form.label.body" path="body"/>	
		
	<acme:input-textbox code="administrator.announcement.form.label.optionalLink" path="optionalLink"/>	
	<acme:input-select code="administrator.announcement.form.label.flag" path="flag">
		<acme:input-option code="INFO" value="INFO" selected="${status == 'INFO'}"/>
		<acme:input-option code="WARNING" value="WARNING" selected="${status == 'WARNING'}"/>
		<acme:input-option code="IMPORTANT" value="IMPORTANT" selected="${status == 'IMPORTANT'}"/>
	</acme:input-select>
	
	<jstl:if test="${!readonly}">
		<acme:input-checkbox code="administrator.announcement.form.label.confirmation" path="confirmation"/>
		<acme:submit code="administrator.announcement.form.label.button.create" action="/administrator/announcement/create"/>
	</jstl:if>
</acme:form>
