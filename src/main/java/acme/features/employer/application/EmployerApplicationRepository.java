/*
 * EmployerApplicationRepository.java
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

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerApplicationRepository extends AbstractRepository {

	@Query("select a from Application a where a.id = :id")
	Application findOneApplicationById(int id);

	@Query("select a from Application a where a.job.employer.id = :id")
	Collection<Application> findManyApplicationsByEmployerId(int id);

}
