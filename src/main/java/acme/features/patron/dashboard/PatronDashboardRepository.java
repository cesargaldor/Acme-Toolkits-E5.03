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
	//Consulta para filtrar patronages por el status
	@Query("select count(p) from Patronage p where p.status = ':status'")
	int numberOfStatusPatronages(String status);
	
	//Consulta para seleccionar estadísticas agrupadas por status y currency
//	@Query("select p.status, p.budget.currency, avg(p.budget.amount), stddev(p.budget.amount), min(p.budget.amount), max(p.budget.amount) from Patronage p group by p.status, p.budget.currency")
//	List<Object[]> statsBudgetOfStatusPatronages();

	 
}