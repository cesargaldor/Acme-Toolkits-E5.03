<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>


<h2><acme:message code="administrator.dashboard.form.title.components"/></h2>

<table class="table table-sm">
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.number-of-components"/>
		</th>
		<td>
			<acme:print value="${numberOfComponents}"/>
		</td>
	</tr>
</table>

<h3><acme:message code="administrator.dashboard.form.title.stats"/></h3>

<table class="table table-sm">
	<jstl:forEach var="entry" items="${statsRetailPriceOfComponents}">
		<tr>
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.technology"/>
			</th>
			<td>
				<acme:print value="${entry.key.first}"/>
			</td>
		
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.currency"/>
			</th>
			<td>
				<acme:print value="${entry.key.second}"/>
			</td>
		
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.average-value"/>
			</th>
			<td>
				<acme:print value="${entry.value.average}"/>
			</td>
			
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.deviation-value"/>
			</th>
			<td>
				<acme:print value="${entry.value.deviation}"/>
			</td>
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.minimum-value"/>
			</th>
			<td>
				<acme:print value="${entry.value.minumun}"/>
			</td>
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.maximum-value"/>
			</th>
			<td>
				<acme:print value="${entry.value.maximun}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>


<h2>
	<acme:message code="administrator.dashboard.form.title.tools"/>
</h2>

<table class="table table-sm">
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.number-of-tools"/>
		</th>
		<td>
			<acme:print value="${numberOfTools}"/>
		</td>
	</tr>
</table>

<h3><acme:message code="administrator.dashboard.form.title.stats"/></h3>

<table class="table table-sm">
	<jstl:forEach var="entry" items="${statsRetailPriceOfTools}">
		<tr>
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.technology"/>
			</th>
			<td>
				<acme:print value="${entry.key.first}"/>
			</td>
		
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.currency"/>
			</th>
			<td>
				<acme:print value="${entry.key.second}"/>
			</td>
		
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.average-value"/>
			</th>
			<td>
				<acme:print value="${entry.value.average}"/>
			</td>
			
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.deviation-value"/>
			</th>
			<td>
				<acme:print value="${entry.value.deviation}"/>
			</td>
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.minimum-value"/>
			</th>
			<td>
				<acme:print value="${entry.value.minumun}"/>
			</td>
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.maximum-value"/>
			</th>
			<td>
				<acme:print value="${entry.value.maximun}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>




<h2>
	<acme:message code="administrator.dashboard.form.title.patronages"/>
</h2>

<table class="table table-sm">
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.proposed-patronages"/>
		</th>
		<td>
			<acme:print value="${numberOfPropsedPatronages}"/>
		</td>
		
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.accepted-patronages"/>
		</th>
		<td>
			<acme:print value="${numberOfAcceptedPatronages}"/>
		</td>
		
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.denied-patronages"/>
		</th>
		<td>
			<acme:print value="${numberOfDeniedPatronages}"/>
		</td>
	</tr>
</table>

<h3><acme:message code="administrator.dashboard.form.title.stats"/></h3>

<table class="table table-sm">
	<jstl:forEach var="entry" items="${statsBudgetOfStatusPatronages}">
		<tr>
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.status"/>
			</th>
			<td>
				<acme:print value="${entry.key}"/>
			</td>
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.average-value"/>
			</th>
			<td>
				<acme:print value="${entry.value.average}"/>
			</td>
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.deviation-value"/>
			</th>
			<td>
				<acme:print value="${entry.value.deviation}"/>
			</td>
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.minimum-value"/>
			</th>
			<td>
				<acme:print value="${entry.value.minumun}"/>
			</td>
			<th scope="row">
				<acme:message code="administrator.dashboard.form.label.maximum-value"/>
			</th>
			<td>
				<acme:print value="${entry.value.maximun}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>
