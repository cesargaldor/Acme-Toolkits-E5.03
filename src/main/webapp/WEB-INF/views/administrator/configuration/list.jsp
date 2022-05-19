<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">

	<acme:list-column code="administrator.systemConfiguration.list.label.systemCurrency" path="sysCurrency" width="10%"/>
	<acme:list-column code="administrator.systemConfiguration.list.label.acceptedCurrencies" path="allowedCurrencies" width="10%"/>
	<acme:list-column code="administrator.systemConfiguration.list.label.strongSpam" path="strongSpam" width="40%"/>
	<acme:list-column code="administrator.systemConfiguration.list.label.strongThreshold" path="strongThreshold" width="40%"/>
	<acme:list-column code="administrator.systemConfiguration.list.label.weakSpam" path="weakSpam" width="40%"/>
	<acme:list-column code="administrator.systemConfiguration.list.label.weakThreshold" path="weakThreshold" width="40%"/>

</acme:form>