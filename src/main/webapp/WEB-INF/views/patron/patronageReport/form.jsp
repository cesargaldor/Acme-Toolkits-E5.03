<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
    <acme:input-textbox code="patron.patronageReport.form.label.numSeq" path="sequenceNumber"/>
    <acme:input-textarea code="patron.patronageReport.form.label.creationMoment" path="creationMoment"/>
    <acme:input-money code="patron.patronageReport.form.label.memorandum" path="memorandum"/>
    <acme:input-url code="patron.patronageReport.form.label.optinalLink" path="link"/>
</acme:form>