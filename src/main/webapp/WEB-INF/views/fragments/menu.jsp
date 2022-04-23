<%--
- menu.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<!-- Anonimo 
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.all-jobs" action="/anonymous/job/list"/>			
			<acme:menu-suboption code="master.menu.anonymous.list-shouts" action="/anonymous/shout/list"/>
			<acme:menu-suboption code="master.menu.anonymous.list-chirps" action="/any/chirp/list"/>
			<acme:menu-suboption code="master.menu.anonymous.list-components" action="/any/component/list"/>
			<acme:menu-suboption code="master.menu.anonymous.list-patronages" action="/anonymous/patronage/list"/>
		</acme:menu-option>
		-->
		
		<!-- Rol any -->
		<acme:menu-option code="master.menu.any" access="isAnonymous() || hasRole('Any')">
			<acme:menu-suboption code="master.menu.any.list-inventors" action="/any/user-account/list-inventor"/>
			<acme:menu-suboption code="master.menu.any.list-patrons" action="/any/user-account/list-patron"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.any.list-chirps" action="/any/chirp/list"/>
			<acme:menu-suboption code="master.menu.any.list-items" action="/any/item/list"/>
		</acme:menu-option>
		
		<!-- Rol autenticado -->
		<acme:menu-option code="master.menu.authenticated" access="hasRole('Authenticated')">
			<acme:menu-suboption code="master.menu.authenticated.announcement.list" action="/authenticated/announcement/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.authenticated.money-exchage" action="/authenticated/money-exchange/perform"/>
		</acme:menu-option>
		
		<!-- Rol administrador -->
		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">			
			<acme:menu-suboption code="master.menu.administrator.announcement.list-all" action="/administrator/announcement/list-all"/>
			<acme:menu-suboption code="master.menu.administrator.announcement.list-recent" action="/administrator/announcement/list-recent"/>			
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.dashboard" action="/administrator/dashboard/show"/>
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.populate-initial" action="/administrator/populate-initial"/>
			<acme:menu-suboption code="master.menu.administrator.populate-sample" action="/administrator/populate-sample"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shut-down" action="/administrator/shut-down"/>
		</acme:menu-option>

		<!-- Rol empleador -->
		<acme:menu-option code="master.menu.employer" access="hasRole('Employer')">			
			<acme:menu-suboption code="master.menu.employer.all-jobs" action="/employer/job/list-all"/>
			<acme:menu-suboption code="master.menu.employer.my-jobs" action="/employer/job/list-mine"/>
			<acme:menu-separator/>			
			<acme:menu-suboption code="master.menu.employer.my-applications" action="/employer/application/list"/>			
		</acme:menu-option>

		<!-- Rol trabajador -->
		<acme:menu-option code="master.menu.worker" access="hasRole('Worker')">
			<acme:menu-suboption code="master.menu.worker.all-jobs" action="/worker/job/list-all"/>
			<acme:menu-separator/>	
			<acme:menu-suboption code="master.menu.worker.my-applications" action="/worker/application/list"/>
		</acme:menu-option>
		
		<!-- Rol patron -->
		<acme:menu-option code="master.menu.patron" access="hasRole('Patron')">
			<acme:menu-suboption code="master.menu.patron.all-patronages" action="/patron/patronage/list"/>
			<acme:menu-suboption code="master.menu.patron.patronageReport.list" action="/patron/patronage-report/list"/>
			<acme:menu-suboption code="master.menu.patron.dashboard" action="/patron/dashboard/show"/>
		</acme:menu-option>
		
		<!-- Rol Inventor -->
		<acme:menu-option code="master.menu.inventor" access="hasRole('Inventor')">
		  	<acme:menu-suboption code="master.menu.inventor.patronage.list" action="/inventor/patronage/list"/>
		  	<acme:menu-suboption code="master.menu.inventor.patronageReport.list" action="/inventor/patronage-report/list"/>
		</acme:menu-option>
		
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-employer" action="/authenticated/employer/create" access="!hasRole('Employer')"/>
			<acme:menu-suboption code="master.menu.user-account.employer" action="/authenticated/employer/update" access="hasRole('Employer')"/>
			<acme:menu-suboption code="master.menu.user-account.become-worker" action="/authenticated/worker/create" access="!hasRole('Worker')"/>
			<acme:menu-suboption code="master.menu.user-account.worker" action="/authenticated/worker/update" access="hasRole('Worker')"/>
	
			<acme:menu-suboption code="master.menu.user-account.become-inventor" action="/authenticated/inventor/create" access="!hasRole('Inventor')"/>
			<acme:menu-suboption code="master.menu.user-account.inventor" action="/authenticated/inventor/update" access="hasRole('Inventor')"/>
			<acme:menu-suboption code="master.menu.user-account.become-patron" action="/authenticated/patron/create" access="!hasRole('Patron')"/>
			<acme:menu-suboption code="master.menu.user-account.patron" action="/authenticated/patron/update" access="hasRole('Patron')"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>

