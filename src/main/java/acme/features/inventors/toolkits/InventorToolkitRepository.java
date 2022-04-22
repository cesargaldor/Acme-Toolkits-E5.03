package acme.features.inventors.toolkits;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.entities.quantity.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorToolkitRepository extends AbstractRepository{
	
	@Query("select t from Toolkit t where t.id = :id")
	Toolkit findOneToolkitById(int id);
	
	@Query("select t from Toolkit t where t.inventor.userAccount.username = :username")
	Collection<Toolkit> findToolkitsByInventorUsername(String username);
	
	 @Query("select q from Quantity q where q.toolkit.id = :id")
	 Collection<Quantity> findManyQuantitiesByToolkitId(int id);

	 @Query("select q.item from Quantity q where q.id = :id")
	 Collection<Item> findManyItemsByQuantityId(int id);
	
	
}