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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronDashboardShowService implements AbstractShowService<Patron, Dashboard> {


//	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronDashboardRepository repository;

	// AbstractShowService<Administrator, Dashboard> interface ----------------


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	
	/*total number of proposed/accepted/denied patronages; average, deviation, minimum, and maximum budget 
	 * of proposed /accepted/denied patronages grouped by currency.*/
	
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, 
			"numberOfProposedPatronages", "numberOfAcceptedPatronages", "numberOfDeniedPatronages",
			"averageOfProposedPatronages", "averageOfAcceptedPatronages", "averageOfDeniedPatronages"/*,
			
			"deviationOfProposedPatronages", "deviationOfAcceptedPatronages", "deviationOfDeniedPatronages",
			
			"minimunBudgetOfProposedPatronages", "maximunBudgetOfProposedPatronages", 
			"minimunBudgetOfAcceptedPatronages" ,"maximunBudgetOfAcceptedPatronages", 
			"minimunBudgetOfDeniedPatronages", "maximunBudgetOfDeniedPatronages"*/);
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result;
		
		final Double numberOfProposedPatronages;
		final Double numberOfAcceptedPatronages;
		final Double numberOfDeniedPatronages;
		final Double averageOfProposedPatronages;
//		final Double averageOfAcceptedPatronages;
//		final Double averageOfDeniedPatronages;
//		final Double deviationOfProposedPatronages;
//		final Double deviationOfAcceptedPatronages;
//		final Double deviationOfDeniedPatronages;
//		final Double minimunBudgetOfProposedPatronages;
//		final Double maximunBudgetOfProposedPatronages;
//		final Double minimunBudgetOfAcceptedPatronages;
//		final Double maximunBudgetOfAcceptedPatronages;
//		final Double minimunBudgetOfDeniedPatronages;
//		final Double maximunBudgetOfDeniedPatronages;


		
		numberOfProposedPatronages = this.repository.numberOfProposedPatronages();
		numberOfAcceptedPatronages = this.repository.numberOfAcceptedPatronages();
		numberOfDeniedPatronages = this.repository.numberOfDeniedPatronages();
//		averageOfProposedPatronages = this.repository.averageOfProposedPatronages();
//		averageOfAcceptedPatronages = this.repository.averageOfAcceptedPatronages();
//		averageOfDeniedPatronages = this.repository.averageOfDeniedPatronages();
//		deviationOfProposedPatronages = this.repository.deviationOfProposedPatronages();
//		deviationOfAcceptedPatronages = this.repository.deviationOfAcceptedPatronages();
//		deviationOfDeniedPatronages = this.repository.deviationOfDeniedPatronages();
//		minimunBudgetOfProposedPatronages = this.repository.minimunBudgetOfProposedPatronages();
//		maximunBudgetOfProposedPatronages = this.repository.maximunBudgetOfProposedPatronages();
//		minimunBudgetOfAcceptedPatronages = this.repository.minimunBudgetOfAcceptedPatronages();
//		maximunBudgetOfAcceptedPatronages = this.repository.maximunBudgetOfAcceptedPatronages();
//		minimunBudgetOfDeniedPatronages = this.repository.minimunBudgetOfDeniedPatronages();
//		maximunBudgetOfDeniedPatronages = this.repository.maximunBudgetOfDeniedPatronages();

		

		result = new Dashboard();
		
		result.setNumberOfProposedPatronages(numberOfProposedPatronages);
		result.setNumberOfAcceptedPatronages(numberOfAcceptedPatronages);
		result.setNumberOfDeniedPatronages(numberOfDeniedPatronages);
//		result.setAverageOfProposedPatronages(averageOfProposedPatronages);
//		result.setAverageOfAcceptedPatronages(averageOfAcceptedPatronages);
//		result.setAverageOfDeniedPatronages(averageOfDeniedPatronages);
//		result.setRatioOfProposedStatus(deviationOfProposedPatronages);
//		result.setRatioOfProposedStatus(deviationOfAcceptedPatronages);
//		result.setRatioOfProposedStatus(deviationOfDeniedPatronages);
//		result.setRatioOfProposedStatus(minimunBudgetOfProposedPatronages);
//		result.setRatioOfProposedStatus(maximunBudgetOfProposedPatronages);
//		result.setRatioOfProposedStatus(minimunBudgetOfAcceptedPatronages);
//		result.setRatioOfProposedStatus(maximunBudgetOfAcceptedPatronages);
//		result.setRatioOfProposedStatus(minimunBudgetOfDeniedPatronages);
//		result.setRatioOfProposedStatus(maximunBudgetOfDeniedPatronages);


		return result;
	}

}
