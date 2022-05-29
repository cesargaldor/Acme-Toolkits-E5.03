
package acme.features.administrator.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;


@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {


	//Components
	
	@Query("select count(i) from Item i where i.type = 'COMPONENT'")
	Integer totalNumOfComponents();
	
	
	@Query("select avg(i.retailPrice.amount),technology,i.retailPrice.currency  from Item i where i.type = 'COMPONENT' GROUP BY i.retailPrice.currency, technology")
	List<Object[]> averagePriceOfComponents();
	
	
	@Query("select max(i.retailPrice.amount),technology,i.retailPrice.currency from Item i where i.type = 'COMPONENT' GROUP BY i.retailPrice.currency, technology")
	List<Object[]> maxPriceOfComponents();
	
	@Query("select min(i.retailPrice.amount),technology,i.retailPrice.currency from Item i where i.type = 'COMPONENT' GROUP BY i.retailPrice.currency, technology")
	List<Object[]> minPriceOfComponents();
	
	@Query("select stddev(i.retailPrice.amount),technology,i.retailPrice.currency from Item i where i.type = 'COMPONENT' GROUP BY i.retailPrice.currency, technology")
	List<Object[]> deviationPriceOfComponents();
	
	

	//Tools
	
	
	@Query("select count(i) from Item i where i.type = 'TOOL'")
	Integer totalNumOfTools();
	
	@Query("select avg(i.retailPrice.amount),i.retailPrice.currency from Item i where i.type = 'TOOL' GROUP BY i.retailPrice.currency")
	List<Object[]> averagePriceOfTools();
	
	@Query("select max(i.retailPrice.amount),i.retailPrice.currency from Item i where i.type = 'TOOL' GROUP BY i.retailPrice.currency")
	List<Object[]> maxPriceOfTools();
	
	@Query("select min(i.retailPrice.amount),i.retailPrice.currency from Item i where i.type = 'TOOL' GROUP BY i.retailPrice.currency")
	List<Object[]> minPriceOfTools();
	
	@Query("select stddev(i.retailPrice.amount),i.retailPrice.currency from Item i where i.type = 'TOOL' GROUP BY i.retailPrice.currency")
	List<Object[]> deviationPriceOfTools();
	
	
	//Patronages
	
	
	@Query("select count(p) from Patronage p where p.status = acme.entities.patronage.Status.PROPOSED ")
	Integer  numberOfProposedPatronages();
		
	@Query("select count(p) from Patronage p where p.status = acme.entities.patronage.Status.ACCEPTED ")
	Integer  numberOfAcceptedPatronages();
		
	@Query("select count(p) from Patronage p where p.status = acme.entities.patronage.Status.DENIED ")
	Integer  numberOfDeniedPatronages();
		
		
	
	@Query("select avg(p.budget.amount) from Patronage p where p.status = acme.entities.patronage.Status.PROPOSED GROUP BY p.status")
	Double averageBudgetProposedPatronages();
		
	@Query("select avg(p.budget.amount) from Patronage p where p.status = acme.entities.patronage.Status.ACCEPTED GROUP BY p.status")
	Double averageBudgetAcceptedPatronages();
		
	@Query("select avg(p.budget.amount) from Patronage p where p.status = acme.entities.patronage.Status.DENIED GROUP BY p.status")
	Double averageBudgetDeniedPatronages();
		
		
		
	@Query("select stddev(p.budget.amount) from Patronage p where p.status = acme.entities.patronage.Status.PROPOSED ")
	Double deviationBudgetProposedPatronages();

	@Query("select stddev(p.budget.amount) from Patronage p where p.status = acme.entities.patronage.Status.ACCEPTED ")
	Double deviationBudgetAcceptedPatronages();
		
	@Query("select stddev(p.budget.amount) from Patronage p where p.status = acme.entities.patronage.Status.DENIED ")
	Double deviationBudgetDeniedPatronages();
		
		
		
	@Query("select min(p.budget.amount) from Patronage p where p.status = acme.entities.patronage.Status.PROPOSED ")
	Double minBudgetProposedPatronages();
		
	@Query("select min(p.budget.amount) from Patronage p where p.status = acme.entities.patronage.Status.ACCEPTED ")
	Double minBudgetAcceptedPatronages();
		
	@Query("select min(p.budget.amount) from Patronage p where p.status = acme.entities.patronage.Status.DENIED ")
	Double minBudgetDeniedPatronages();
		

		
	@Query("select max(p.budget.amount) from Patronage p where p.status = acme.entities.patronage.Status.PROPOSED ")
	Double maxBudgetProposedPatronages();
		
	@Query("select max(p.budget.amount) from Patronage p where p.status = acme.entities.patronage.Status.ACCEPTED ")
	Double maxBudgetAcceptedPatronages();
		
	@Query("select max(p.budget.amount) from Patronage p where p.status = acme.entities.patronage.Status.DENIED ")
	Double maxBudgetDeniedPatronages();
	
}
