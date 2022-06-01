<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="any.userAccount.list.label.roles"  path="roles" width="30%"/>
	<acme:list-column code="any.userAccount.list.label.username" path="username" width="30%"/>
	<acme:list-column code="any.userAccount.list.label.email" path="identity.email" width="30%"/>
</acme:list>