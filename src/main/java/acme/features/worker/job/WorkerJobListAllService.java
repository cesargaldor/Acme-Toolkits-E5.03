/*
 * WorkerJobListAllService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.worker.job;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Worker;

@Service
public class WorkerJobListAllService implements AbstractListService<Worker, Job> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected WorkerJobRepository repository;

	// AbstractListService<Worker, Job> interface -----------------------------


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "deadline");
	}

	@Override
	public Collection<Job> findMany(final Request<Job> request) {
		assert request != null;

		Collection<Job> result;

		result = this.repository.findManyJobsByAvailability();

		return result;
	}

}
