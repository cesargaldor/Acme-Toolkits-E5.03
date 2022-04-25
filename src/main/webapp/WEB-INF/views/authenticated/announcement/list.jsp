<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
    <acme:list-column code="authenticated.announcement.list.label.creation" path="moment" width="30%"/>
    <acme:list-column code="authenticated.announcement.list.label.title" path="title" width="50%"/>
    <acme:list-column code="authenticated.announcement.list.label.criticalFlag" path="flag" width="20%"/>
   
</acme:list>