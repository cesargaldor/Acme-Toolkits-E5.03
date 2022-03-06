/*
 * EmployerApplicationShowService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.employer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Application;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Employer;

@Service
public class EmployerApplicationShowService implements AbstractShowService<Employer, Application> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected EmployerApplicationRepository repository;

	// AbstractShowService<Employer, Application> interface -------------------


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		boolean result;
		int applicationId;
		Application application;

		applicationId = request.getModel().getInteger("id");
		application = this.repository.findOneApplicationById(applicationId);
		result = application != null && application.getJob().getEmployer().getId() == request.getPrincipal().getActiveRoleId();

		return result;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "moment", "status", "statement", "skills", "qualifications");
		model.setAttribute("masterId", entity.getJob().getId());
	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;

		Application result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneApplicationById(id);

		return result;
	}

}
