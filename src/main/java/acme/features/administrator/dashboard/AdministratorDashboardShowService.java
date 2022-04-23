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

package acme.features.administrator.dashboard;

import org.springframework.stereotype.Service;

@Service
public class AdministratorDashboardShowService /*implements AbstractShowService<Administrator, Dashboard>*/ {

//	// Internal state ---------------------------------------------------------
//
//	@Autowired
//	protected AdministratorDashboardRepository repository;
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
//		request.unbind(entity, model, //
//			"averageNumberOfJobsPerEmployer", "averageNumberOfApplicationsPerWorker", // 
//			"avegageNumberOfApplicationsPerEmployer", "ratioOfPendingApplications", //
//			"ratioOfRejectedApplications", "ratioOfAcceptedApplications");
//	}
//
//	@Override
//	public Dashboard findOne(final Request<Dashboard> request) {
//		assert request != null;
//
//		Dashboard result;
//		Double averageNumberOfApplicationsPerEmployer;
//		Double averageNumberOfApplicationsPerWorker;
//		Double averageNumberOfJobsPerEmployer;
//		Double ratioOfPendingApplications;
//		Double ratioOfAcceptedApplications;
//		Double ratioOfRejectedApplications;
//
//		averageNumberOfApplicationsPerEmployer = this.repository.averageNumberOfApplicationsPerEmployer();
//		averageNumberOfApplicationsPerWorker = this.repository.averageNumberOfApplicationsPerWorker();
//		averageNumberOfJobsPerEmployer = this.repository.averageNumberOfJobsPerEmployer();
//		ratioOfPendingApplications = this.repository.ratioOfPendingApplications();
//		ratioOfAcceptedApplications = this.repository.ratioOfAcceptedApplications();
//		ratioOfRejectedApplications = this.repository.ratioOfRejectedApplications();
//
//		result = new Dashboard();
//		result.setAvegageNumberOfApplicationsPerEmployer(averageNumberOfApplicationsPerEmployer);
//		result.setAverageNumberOfApplicationsPerWorker(averageNumberOfApplicationsPerWorker);
//		result.setAverageNumberOfJobsPerEmployer(averageNumberOfJobsPerEmployer);
//		result.setRatioOfPendingApplications(ratioOfPendingApplications);
//		result.setRatioOfAcceptedApplications(ratioOfAcceptedApplications);
//		result.setRatioOfRejectedApplications(ratioOfRejectedApplications);
//
//		return result;
//	}

}
