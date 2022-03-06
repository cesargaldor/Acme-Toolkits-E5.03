/*
 * WorkerApplicationRepository.java
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

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Application;
import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Worker;

@Repository
public interface WorkerApplicationRepository extends AbstractRepository {

	@Query("select a from Application a where a.id = :id")
	Application findOneApplicationById(int id);

	@Query("select j from Job j where j.id = :id")
	Job findOneJobById(int id);

	@Query("select w from Worker w where w.id = :id")
	Worker findOneWorkerById(int id);

	@Query("select a from Application a where a.worker.id = :id")
	Collection<Application> findManyApplicationsByWorkerId(int id);

}
