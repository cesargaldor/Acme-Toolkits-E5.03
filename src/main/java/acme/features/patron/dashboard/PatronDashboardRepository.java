/*
 * AdministratorDashboardRepository.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.patron.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronDashboardRepository extends AbstractRepository {

//	Number of patronages by status
	
	@Query("select count(p) from Patronage p where p.status= acme.entities.patronage.Status.PROPOSED")
	Double NumOfProposedPatronages();

	@Query("select count(p) from Patronage p where p.status= acme.entities.patronage.Status.ACCEPTED")
	Double NumbOfAcceptedPatronages();

	@Query("select count(p) from Patronage p where p.status= acme.entities.patronage.Status.DENIED")
	Double NumbOfDeniedPatronages();

// Average
		
	@Query("select avg(p.budget) from Patronage p group by acme.entities.patronage.Status.PROPOSED")
	Double avgBudgetProposedPatronages();

	@Query("select avg(p.budget) from Patronage p group by acme.entities.patronage.Status.ACCEPTED")
	Double avgBudgetAcceptedPatronages();

	@Query("select avg(p.budget) from Patronage p group by acme.entities.patronage.Status.DENIED")
	Double avgBudgetDeniedPatronages();
	
// Deviation
		
	@Query("select stdev(p.budget) from Patronage p group by acme.entities.patronage.Status.PROPOSED")
	Double devBudgetProposedPatronages();

	@Query("select stdev(p.budget) from Patronage p group by acme.entities.patronage.Status.ACCEPTED")
	Double devBudgetAcceptedPatronages();

	@Query("select stdev(p.budget) from Patronage p group by acme.entities.patronage.Status.DENIED")
	Double devBudgetDeniedPatronages();
	
	
// Min
		
	@Query("select min(p.budget) from Patronage p group by acme.entities.patronage.Status.PROPOSED")
	Double minBudgetProposedPatronages();
	
	@Query("select min(p.budget) from Patronage p group by acme.entities.patronage.Status.ACCEPTED")
	Double minBudgetAcceptedPatronages();
	
	@Query("select min(p.budget) from Patronage p group by acme.entities.patronage.Status.DENIED")
	Double minBudgetDeniedPatronages();
	
// Max
	
	@Query("select max(p.budget) from Patronage p group by acme.entities.patronage.Status.PROPOSED")
	Double maxBudgetProposedPatronages();
	
	@Query("select max(p.budget) from Patronage p group by acme.entities.patronage.Status.ACCEPTED")
	Double maxBudgetAcceptedPatronages();
	
	@Query("select max(p.budget) from Patronage p group by acme.entities.patronage.Status.DENIED")
	Double maxBudgetDeniedPatronages();
	
	
	
	/* 
	@Query("select avg(select count(j) from Job j where j.employer.id = e.id) from Employer e")
    Double averageNumberOfJobsPerEmployer();
    @Query("select avg(select count(a) from Application a where a.worker.id = w.id) from Worker w")
    Double averageNumberOfApplicationsPerWorker();
    @Query("select avg(select count(a) from Application a where exists(select j from Job j where j.employer.id = e.id and a.job.id = j.id)) from Employer e")
    Double averageNumberOfApplicationsPerEmployer();
    @Query("select 1.0 * count(a) / (select count(b) from Application b) from Application a where a.status = acme.entities.jobs.ApplicationStatus.PENDING")
    Double ratioOfPendingApplications();
    @Query("select 1.0 * count(a) / (select count(b) from Application b) from Application a where a.status = acme.entities.jobs.ApplicationStatus.ACCEPTED")
    Double ratioOfAcceptedApplications();
    @Query("select 1.0 * count(a) / (select count(b) from Application b) from Application a where a.status = acme.entities.jobs.ApplicationStatus.REJECTED")
    Double ratioOfRejectedApplications();
    
    
    //Parte del entregable
    @Query("select t from Task t")
    Collection<Task> findTasks();
    
    
    @Query("select 1.0 * count(t) from Task t  where t.isPublic= 1")
    Double numberPublicTask();
    
    @Query("select 1.0 * count(t) from Task t  where t.isPublic = 0")
    Double numberPrivateTask();
    
    @Query("select avg(t.workloadInHours) from Task t")
    Double averageWorkloadTasks();
    
    @Query("select stddev(t.workloadInHours) from Task t")
    Double deviationWorkloadTasks();
    
    @Query("select min(t.workloadInHours) from Task t")
    Double minimumWorkloadTasks();
    
    @Query("select max(t.workloadInHours) from Task t")
    Double maximumWorkloadTasks();*/
	


}


