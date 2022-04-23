<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
    <acme:input-textbox code="inventor.toolkit.form.label.code" path="code"/>
    <acme:input-textbox code="inventor.toolkit.form.label.title" path="title"/>
    <acme:input-textarea code="inventor.toolkit.form.label.description" path="description"/>
    <acme:input-textarea code="inventor.toolkit.form.label.assembleNotes" path="assemblyNotes"/>
    <acme:input-url code="inventor.toolkit.form.label.link" path="optionalLink"/>
    <acme:button code="inventor.toolkit.form.button.items" action="/inventor/item/list-toolkit?id=${id}"/>

</acme:form>
