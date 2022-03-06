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
	<acme:input-textbox code="employer.application.form.label.reference" path="reference" readonly="true"/>
	<acme:input-textbox code="employer.application.form.label.moment" path="moment" readonly="true"/>
	<acme:input-textarea code="employer.application.form.label.statement" path="statement" readonly="true"/>
	<acme:input-textarea code="employer.application.form.label.skills" path="skills" readonly="true"/>
	<acme:input-textarea code="employer.application.form.label.qualifications" path="qualifications" readonly="true"/>
	
	<jstl:if test="${status != 'PENDING'}">
		<acme:input-textbox code="employer.application.form.label.status" path="status" readonly="true"/>
	</jstl:if>
	
	<jstl:if test="${status == 'PENDING'}">
		<acme:input-select path="status" code="employer.application.form.label.new-status">
			<acme:input-option code="PENDING" value="PENDING" selected="true"/>
			<acme:input-option code="ACCEPTED" value="ACCEPTED"/>
			<acme:input-option code="REJECTED" value="REJECTED"/>
		</acme:input-select>		
	</jstl:if>
			
	<acme:submit test="${command == 'show' && status == 'PENDING'}" code="employer.application.form.button.update" action="/employer/application/update"/>
</acme:form>


