/*
 * AdministratorDashboardShowService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.patron.dashboard;

import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronDashboardShowService implements AbstractShowService<Patron, Dashboard> {

	@Override
	public boolean authorise(final Request<Dashboard> request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		// TODO Auto-generated method stub
		return null;
	}

//	// Internal state ---------------------------------------------------------
//
//	@Autowired
//	protected PatronDashboardRepository repository;
//
//	// AbstractShowService<Administrator, Dashboard> interface ----------------
//
//
//	@Override
//	public boolean authorise(final Request<Dashboard> request) {
//		assert request != null;
//
//		return true;
//	}
//
//	@Override
//	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
//		assert request != null;
//		assert entity != null;
//		assert model != null;
//
//		request.unbind(entity, model, 
//			"ratioOfProposedStatus", "ratioOfAcceptedStatus", "ratioOfDeniedStatus");
//	}
//
//	@Override
//	public Dashboard findOne(final Request<Dashboard> request) {
//		assert request != null;
//
//		Dashboard result;
//		
//		final Double ratioOfProposedStatus;
//		final Double ratioOfAcceptedStatus;
//		final Double ratioOfDeniedStatus;
//
//		
//		ratioOfProposedStatus = this.repository.ratioOfProposedStatus();
//		ratioOfAcceptedStatus = this.repository.ratioOfAcceptedStatus();
//		ratioOfDeniedStatus = this.repository.ratioOfDeniedStatus();
//
//		result = new Dashboard();
//		
////		result.setRatioOfProposedStatus(ratioOfProposedStatus);
////		result.setRatioOfAcceptedStatus(ratioOfAcceptedStatus);
////		result.setRatioOfDeniedStatus(ratioOfDeniedStatus);
//
//		return result;
//	}

}
