<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
    <jstl:choose>
    	
    	<jstl:when test="${command == 'show'}">
    		<acme:input-textbox code="inventor.patronageReport.form.label.numSeq" path="numSeq" readonly="true"/>
    		<acme:input-textarea code="inventor.patronageReport.form.label.creationMoment" path="creationMoment" readonly="true"/>
    		<acme:input-money code="inventor.patronageReport.form.label.memorandum" path="memorandum" readonly="true"/>
    		<acme:input-url code="inventor.patronageReport.form.label.optionalLink" path="optionalLink" readonly="true"/>
    	</jstl:when>
    
        
        <jstl:when test="${command == 'create'}">
	        <acme:input-textbox code="inventor.patronageReport.form.label.numSeq" path="numSeq"/>
	    	<acme:input-textarea code="inventor.patronageReport.form.label.creationMoment" path="creationMoment"/>
	    	<acme:input-textarea code="inventor.patronageReport.form.label.memorandum" path="memorandum"/>
	    	<acme:input-url code="inventor.patronageReport.form.label.optionalLink" path="optionalLink"/>
	   		<acme:input-checkbox code="inventor.patronage-report.form.label.confirmation" path="confirmation" />
	   		<acme:submit code="inventor.patronageReport.form.label.button.create" action="/inventor/patronage-report/create"/>
	    </jstl:when>
    	
    </jstl:choose>
    		
</acme:form>