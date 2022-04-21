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

<h2>
	<acme:message code="patron.dashboard.form.title.general-indicators"/>
</h2>

<table class="table table-sm">


	<tr>
		<th scope="row">
			<acme:message code="patron.dashboard.form.label.number-of-proposed-patronages"/>
		</th>
		<td>
			<acme:print value="${numberOfProposedPatronages}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="patron.dashboard.form.label.number-of-accepted-patronages" />
		</th>
		<td>
			<acme:print value="${numberOfAcceptedPatronages}" /></td>
	</tr>
	
	<tr>
		<th scope="row">
			<acme:message code="patron.dashboard.form.label.number-of-denied-patronages" />
		</th>
		<td>
			<acme:print value="${numberOfDeniedPatronages}" /></td>
	</tr>
	
	
	<tr>
		<th scope="row">
			<acme:message code="patron.dashboard.form.label.average-of-proposed-patronages" />
		</th>
		<td>
			<acme:print value="${averageOfProposedPatronages}" /></td>
	</tr>
	
	<tr>
		<th scope="row">
			<acme:message code="patron.dashboard.form.label.average-of-accepted-patronages" />
		</th>
		<td>
			<acme:print value="${averageOfAcceptedPatronages}" /></td>
	</tr>
	
	<tr>
		<th scope="row">
			<acme:message code="patron.dashboard.form.label.average-of-denied-patronages" />
		</th>
		<td>
			<acme:print value="${averageOfDeniedPatronages}" /></td>
	</tr>
	
	
	<%-- 
	<tr>
		<th scope="row">
			<acme:message code="patron.dashboard.form.label.average-number-applications-worker"/>
		</th>
		<td>
			<acme:print value="${averageNumberOfApplicationsPerWorker}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="patron.dashboard.form.label.average-number-applications-employer"/>
		</th>
		<td>
			<acme:print value="${avegageNumberOfApplicationsPerEmployer}"/>
		</td>
	</tr>	
	--%>
	
</table>

<h2>
	<acme:message code="patron.dashboard.form.title.patronages-statuses"/>
</h2>

<div>
	<canvas id="canvas"></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		var data = {
			labels : [
					"PROPOSED", "ACCEPTED", "DENIED"
			],
			datasets : [
				{
					data : [
						<jstl:out value="${numberOfProposedPatronages}"/>, 
						<jstl:out value="${numberOfAcceptedPatronages}"/>, 
						<jstl:out value="${numberOfDeniedPatronages}"/>
					]
				}
			]
		};
		var options = {
			scales : {
				yAxes : [
					{
						ticks : {
							suggestedMin : 0.0,
							suggestedMax : 1.0
						}
					}
				]
			},
			legend : {
				display : false
			}
		};
	
		var canvas, context;
	
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "bar",
			data : data,
			options : options
		});
	});
</script>

<acme:return/>

