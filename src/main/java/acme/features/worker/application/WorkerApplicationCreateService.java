/*
 * WorkerApplicationCreateService.java
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

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Application;
import acme.entities.jobs.ApplicationStatus;
import acme.entities.jobs.Job;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Worker;

@Service
public class WorkerApplicationCreateService implements AbstractCreateService<Worker, Application> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected WorkerApplicationRepository repository;

	// AbstractCreateService<Worker, Application> interface -------------------


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		boolean result;
		int masterId;
		Job job;
		Date currentDate;

		masterId = request.getModel().getInteger("masterId");
		job = this.repository.findOneJobById(masterId);
		currentDate = new Date();
		result = job != null && !job.isDraftMode() && job.getDeadline().after(currentDate);

		return result;
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "reference", "statement", "skills", "qualifications");
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "statement", "skills", "qualifications");
		model.setAttribute("masterId", entity.getJob().getId());
	}

	@Override
	public Application instantiate(final Request<Application> request) {
		assert request != null;

		Application result;
		Worker worker;
		Job job;
		String reference;
		Date moment;
		Calendar calendar;

		worker = this.repository.findOneWorkerById(request.getPrincipal().getActiveRoleId());
		job = this.repository.findOneJobById(request.getModel().getInteger("masterId"));
		reference = UUID.randomUUID().toString();

		moment = new Date();
		calendar = Calendar.getInstance();
		calendar.setTime(moment);
		calendar.add(Calendar.SECOND, -1);
		moment = calendar.getTime();

		result = new Application();
		result.setReference(reference);
		result.setMoment(moment);
		result.setStatus(ApplicationStatus.PENDING);
		result.setStatement("");
		result.setSkills(worker.getSkills());
		result.setQualifications(worker.getQualifications());
		result.setJob(job);
		result.setWorker(worker);

		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		Calendar calendar;

		moment = new Date();
		calendar = Calendar.getInstance();
		calendar.setTime(moment);
		calendar.add(Calendar.SECOND, -1);
		moment = calendar.getTime();

		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
