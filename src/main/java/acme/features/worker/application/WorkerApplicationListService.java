/*
 * WorkerApplicationListService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.worker.application;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Application;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Worker;

@Service
public class WorkerApplicationListService implements AbstractListService<Worker, Application> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected WorkerApplicationRepository repository;

	// AbstractListService<Worker, Application> interface ---------------------


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "status");
		model.setAttribute("title", entity.getJob().getTitle());
	}

	@Override
	public Collection<Application> findMany(final Request<Application> request) {
		assert request != null;

		Collection<Application> result;
		int workerId;

		workerId = request.getPrincipal().getActiveRoleId();
		result = this.repository.findManyApplicationsByWorkerId(workerId);

		return result;
	}

}
