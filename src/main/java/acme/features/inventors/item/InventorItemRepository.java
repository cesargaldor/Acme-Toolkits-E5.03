package acme.features.inventors.item;


import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorItemRepository extends AbstractRepository{
	
	@Query("select p from Item p")
	Collection<Item> findMany();
	
	@Query("select i from Item i where i.inventor.userAccount.username = :username")
	Collection<Item> findMyItems(String username);
	
	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);
	
	
	@Query("select p from Item p where p.inventor.id = ?1")
    Collection<Item> findItemByInventorId(int id);
	
	
	
	
	
}
