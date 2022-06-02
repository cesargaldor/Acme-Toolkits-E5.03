package acme.features.inventor.chimpum;


import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Chimpums.Chimpum;
import acme.entities.items.Item;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;



@Repository
public interface  InventorChimpumRepository extends AbstractRepository {

	
	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);
	
	@Query("select i from Item i where i.Chimpum.id = :id")
	Item findOneItemByChimpumId(int id);
	
	@Query("select c from Chimpum c where c.id = :id")
	Chimpum findOneChimpumById(int id);
	
	@Query("select c from Chimpum c join Item i where i.chimpum.id=c.id AND i.inventor.id = :inventorId")
	Collection<Chimpum> findManyChimpumsByInventorId(int inventorId);
	
	@Query("select i.inventor from Item i where i.inventor.id = :inventorId")
	Inventor findInventorById(int inventorId);
	
	@Query("select c from Chimpum c WHERE c.code = :code")
	Chimpum findOneChimpumByCode(String code);	

}
