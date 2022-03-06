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

<acme:form readonly="true">
	<acme:input-textbox code="administrator.announcement.form.label.title" path="title"/>	
	<acme:input-select code="administrator.announcement.form.label.status" path="status">
		<acme:input-option code="INFO" value="INFO" selected="${status == 'INFO'}"/>
		<acme:input-option code="WARNING" value="WARNING" selected="${status == 'WARNING'}"/>
		<acme:input-option code="IMPORTANT" value="IMPORTANT" selected="${status == 'IMPORTANT'}"/>
	</acme:input-select>
	<acme:input-textarea code="administrator.announcement.form.label.text" path="text"/>
	<acme:input-textbox code="administrator.announcement.form.label.info" path="info"/>
</acme:form>
