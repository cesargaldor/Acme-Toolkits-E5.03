
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
 <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

 <acme:form>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.totalNumComponents" path="totalNumComponents"/>
 	<br>
 	<acme:message code="administrator.administratordashboard.form.label.maxPriceOfComponents"/>
	<table class="table small-table">
		<caption>Maximum Price of Components</caption>	
 		<jstl:forEach items="${maxPriceOfComponents}" var="i">
 		<jstl:set var = "split" value = "${fn:split(i,'->')}"/>
		<jstl:set var = "value" value = "${split[0]}" />
		<jstl:set var = "string" value = "${split[1]}" />   
 			<tr>	
				<th scope="row">	
					<acme:print value="${string}"/>
				</th>
				<td>				
					<acme:print value="${value}"/>				
				</td>		
			</tr>
 		</jstl:forEach>
 	</table>
 	<br><br>
 	<acme:message code="administrator.administratordashboard.form.label.minPriceOfComponents"/>
	<table class="table small-table">
		<caption>Minimun Price of Components</caption>	
 		<jstl:forEach items="${minPriceOfComponents}" var="i">
 		<jstl:set var = "split" value = "${fn:split(i,'->')}"/>
		<jstl:set var = "value" value = "${split[0]}" />
		<jstl:set var = "string" value = "${split[1]}" />   
 			<tr>	
				<th scope="row">	
					<acme:print value="${string}"/>
				</th>
				<td>				
					<acme:print value="${value}"/>				
				</td>		
			</tr>
 		</jstl:forEach>
 	</table>
 	<br><br>
 	<acme:message code="administrator.administratordashboard.form.label.averagePriceOfComponents"/>
	<table class="table small-table">
		<caption>Average Price of Components</caption>	
 		<jstl:forEach items="${averagePriceOfComponents}" var="i">
 		<jstl:set var = "split" value = "${fn:split(i,'->')}"/>
		<jstl:set var = "value" value = "${split[0]}" />
		<jstl:set var = "string" value = "${split[1]}" />   
 			<tr>	
				<th scope="row">	
					<acme:print value="${string}"/>
				</th>
				<td>				
					<acme:print value="${value}"/>				
				</td>		
			</tr>
 		</jstl:forEach>
 	</table>
 	<br><br>
 	<acme:message code="administrator.administratordashboard.form.label.deviationPriceOfComponents"/>
	<table class="table small-table">
		<caption>Deviation of the Price of Components</caption>
 		<jstl:forEach items="${deviationPriceOfComponents}" var="i">
 		<jstl:set var = "split" value = "${fn:split(i,'->')}"/>
		<jstl:set var = "value" value = "${split[0]}" />
		<jstl:set var = "string" value = "${split[1]}" />   
 			<tr>	
				<th scope="row">	
					<acme:print value="${string}"/>
				</th>
				<td>				
					<acme:print value="${value}"/>				
				</td>		
			</tr>
 		</jstl:forEach>
 	</table>
 	<br><br><br><br>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.totalNumTools" path="totalNumTools"/>
 	<br>
 	<acme:message code="administrator.administratordashboard.form.label.maxPriceOfTools"/>
	<table class="table small-table">
		<caption>Maximum Price of Tools</caption>	
 		<jstl:forEach items="${maxPriceOfTools}" var="i"> 
 			<tr>	
				<th scope="row">	
					<acme:print value="${i.currency}"/>
				</th>
				<td>				
					<acme:print value="${i.amount}"/>				
				</td>		
			</tr>
 		</jstl:forEach>
 	</table>
 	<br><br>
 	<acme:message code="administrator.administratordashboard.form.label.minPriceOfTools"/>
 	<table class="table small-table">
 		<caption>Minimum Price of Tools</caption>	
 		<jstl:forEach items="${minPriceOfTools}" var="i"> 
 			<tr>	
				<th scope="row">	
					<acme:print value="${i.currency}"/>
				</th>
				<td>				
					<acme:print value="${i.amount}"/>				
				</td>		
			</tr>
 		</jstl:forEach>
 	</table>
 	<br><br>
 	<acme:message code="administrator.administratordashboard.form.label.averagePriceOfTools"/>
 	<table class="table small-table">
 		<caption>Average Price of Tools</caption>	
 		<jstl:forEach items="${averagePriceOfTools}" var="i"> 
 			<tr>	
				<th scope="row">	
					<acme:print value="${i.currency}"/>
				</th>
				<td>				
					<acme:print value="${i.amount}"/>				
				</td>		
			</tr>
 		</jstl:forEach>
 	</table>
 	<br><br>
 	<acme:message code="administrator.administratordashboard.form.label.deviationPriceOfTools"/>
 	<table class="table small-table">
 		<caption>Deviation of the Price of Tools</caption>	
 		<jstl:forEach items="${deviationPriceOfTools}" var="i"> 
 			<tr>	
				<th scope="row">	
					<acme:print value="${i.currency}"/>
				</th>
				<td>				
					<acme:print value="${i.amount}"/>				
				</td>		
			</tr>
 		</jstl:forEach>
 	</table>
 	<br><br><br><br>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.numberOfAcceptedPatronages" path="numberOfAcceptedPatronages"/>
 	<acme:input-money code="administrator.administratordashboard.form.label.maxAcceptedPatronages" path="maxAcceptedPatronages"/>
 	<acme:input-money code="administrator.administratordashboard.form.label.minAcceptedPatronages" path="minAcceptedPatronages"/>
 	<acme:input-money code="administrator.administratordashboard.form.label.averageAcceptedPatronages" path="averageAcceptedPatronages"/>
 	<acme:input-money code="administrator.administratordashboard.form.label.deviationAcceptedPatronages" path="deviationAcceptedPatronages"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.numberOfDeniedPatronages" path="numberOfDeniedPatronages"/>
 	<acme:input-money code="administrator.administratordashboard.form.label.maxDeniedPatronages" path="maxDeniedPatronages"/>
 	<acme:input-money code="administrator.administratordashboard.form.label.minDeniedPatronages" path="minDeniedPatronages"/>
 	<acme:input-money code="administrator.administratordashboard.form.label.averageDeniedPatronages" path="averageDeniedPatronages"/>
 	<acme:input-money code="administrator.administratordashboard.form.label.deviationDeniedPatronages" path="deviationDeniedPatronages"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.numberOfProposedPatronages" path="numberOfProposedPatronages"/>
 	<acme:input-money code="administrator.administratordashboard.form.label.maxProposedPatronages" path="maxProposedPatronages"/>
 	<acme:input-money code="administrator.administratordashboard.form.label.minProposedPatronages" path="minProposedPatronages"/>
 	<acme:input-money code="administrator.administratordashboard.form.label.averageProposedPatronages" path="averageProposedPatronages"/>
 	<acme:input-money code="administrator.administratordashboard.form.label.deviationProposedPatronages" path="deviationProposedPatronages"/>
 </acme:form> 