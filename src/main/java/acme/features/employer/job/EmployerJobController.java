/*
 * EmployerJobController.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.employer.job;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.jobs.Job;
import acme.framework.controllers.AbstractController;
import acme.roles.Employer;

@Controller
@RequestMapping("/employer/job/")
public class EmployerJobController extends AbstractController<Employer, Job> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected EmployerJobShowService		showService;

	@Autowired
	protected EmployerJobCreateService		createService;

	@Autowired
	protected EmployerJobUpdateService		updateService;

	@Autowired
	protected EmployerJobDeleteService		deleteService;

	@Autowired
	protected EmployerJobListAllService		listAllService;

	@Autowired
	protected EmployerJobListMineService	listMineService;

	@Autowired
	protected EmployerJobPublishService		publishService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("create", this.createService);
		super.addCommand("update", this.updateService);
		super.addCommand("delete", this.deleteService);

		super.addCommand("list-all", "list", this.listAllService);
		super.addCommand("list-mine", "list", this.listMineService);
		super.addCommand("publish", "update", this.publishService);
	}

}
