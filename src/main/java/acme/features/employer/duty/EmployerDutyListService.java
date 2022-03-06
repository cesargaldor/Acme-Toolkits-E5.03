/*
 * EmployertDutyListService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.employer.duty;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Duty;
import acme.entities.jobs.Job;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.helpers.CollectionHelper;
import acme.framework.services.AbstractListService;
import acme.roles.Employer;

@Service
public class EmployerDutyListService implements AbstractListService<Employer, Duty> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected EmployerDutyRepository repository;

	// AbstractListService<Employer, Duty> interface ---------------------------


	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;

		boolean result;
		int masterId;
		Job job;

		masterId = request.getModel().getInteger("masterId");
		job = this.repository.findOneJobById(masterId);
		result = (job != null && (!job.isDraftMode() || request.isPrincipal(job.getEmployer())));

		return result;
	}

	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "workLoad", "moreInfo");
	}

	@Override
	public void unbind(final Request<Duty> request, final Collection<Duty> list, final Model model) {
		assert request != null;
		assert !CollectionHelper.someNull(list);
		assert model != null;

		int masterId;
		Job job;
		boolean draftMode;

		masterId = request.getModel().getInteger("masterId");
		job = this.repository.findOneJobById(masterId);
		draftMode = job.isDraftMode();

		AbstractListService.super.unbind(request, list, model);
		model.setAttribute("masterId", masterId);
		model.setAttribute("draftMode", draftMode);
	}

	@Override
	public Collection<Duty> findMany(final Request<Duty> request) {
		assert request != null;

		Collection<Duty> result;
		int masterId;

		masterId = request.getModel().getInteger("masterId");
		result = this.repository.findManyDutiesByMasterId(masterId);

		return result;
	}

}
