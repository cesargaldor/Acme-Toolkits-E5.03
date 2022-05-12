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

package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Type;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {
	//Consulta para mostrar cantidad de items de un tipo dado
	@Query("select count(i) from Item i where i.type = :type")
	int numberOfItem(Type type);
	
	//Consulta para mostrar la cantidad de cada patronage segun su status
	/*@Query("select count(p) from Patronage p where p.status = :status")
	int numberOfStatusPatronages(Status status);
	
	@Query("select i.technology, i.retailPrice.currency, avg(i.retailPrice.amount),"
		+ " stddev(i.retailPrice.amount), min(i.retailPrice.amount),"
		+ " max(i.retailPrice.amount) from Item i where i.type = :type group by i.technology,"
		+ " i.retailPrice.currency")
	List<Object[]> statsRetailPriceOfItem(Type type);*/
	
//	@Query("select p.status, avg(p.budget.amount),stddev(p.budget.amount), min(p.budget.amount),max(p.budget.amount) from Patronage p group by p.status")
//	List<Object[]> statsBudgetOfStatusPatronages();
	 
}