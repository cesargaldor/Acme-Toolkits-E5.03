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

	
	@Query("select 1.0 * count(p) from Patronage p where p.status = acme.entities.patronage.Status.PROPOSED")
	Double numberOfProposedPatronages();
	
	@Query("select 1.0 * count(p) from Patronage p where p.status = acme.entities.patronage.Status.ACCEPTED")
	Double numberOfAcceptedPatronages();
	
	@Query("select 1.0 * count(p) from Patronage p where p.status = acme.entities.patronage.Status.DENIED")
	Double numberOfDeniedPatronages();
	
    //@Query("")
    //Double averageOfProposedPatronages();
    
   // @Query("select 1.0 * avg(select count(p) from Patronage p where p.status = acme.entities.patronage.Status.ACCEPTED)")
   //Double averageOfAcceptedPatronages();
    
   // @Query("select 1.0 * avg(select count(p) from Patronage p where p.status = acme.entities.patronage.Status.DENIED)")
   // Double averageOfDeniedPatronages();

}
