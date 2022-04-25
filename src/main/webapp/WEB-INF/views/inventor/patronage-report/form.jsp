<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
    <acme:input-textbox code="inventor.patronageReport.form.label.numSeq" path="numSeq"/>
    <acme:input-textarea code="inventor.patronageReport.form.label.creationMoment" path="creationMoment"/>
    <acme:input-money code="inventor.patronageReport.form.label.memorandum" path="memorandum"/>
    <acme:input-url code="inventor.patronageReport.form.label.optionalLink" path="link"/>
</acme:form>