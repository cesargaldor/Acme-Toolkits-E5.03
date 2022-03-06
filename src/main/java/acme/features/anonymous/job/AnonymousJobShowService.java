/*
 * AnonymousJobShowService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.anonymous.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Anonymous;
import acme.framework.services.AbstractShowService;

@Service
public class AnonymousJobShowService implements AbstractShowService<Anonymous, Job> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnonymousJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		boolean result;
		int id;
		Job job;

		id = request.getModel().getInteger("id");
		job = this.repository.findOneJobById(id);
		result = !job.isDraftMode();

		return result;
	}

	// AbstractShowService<Anonymous, Job> interface --------------------------

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "deadline", "title", "salary");
		request.unbind(entity, model, "score", "moreInfo", "description");
	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		Job result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneJobById(id);

		return result;
	}

}
