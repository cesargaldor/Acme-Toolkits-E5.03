package acme.features.inventor.gussmo;


import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.chimpums.Gussmo;
import acme.entities.items.Item;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;



@Repository
public interface  InventorGussmoRepository extends AbstractRepository {

	
	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);
	
	@Query("select i from Item i where i.gussmo.id = :id")
	Item findOneItemByGussmoId(int id);
	
	@Query("select g from Gussmo g where g.id = :id")
	Gussmo findOneGussmoById(int id);
	
	@Query("select g from Gussmo g left join Item i on g.id=i.gussmo.id where i.inventor.id = :inventorId")    
	Collection<Gussmo> findManyGussmosByInventorId(int inventorId);
	
	@Query("select i.inventor from Item i where i.inventor.id = :inventorId")
	Inventor findInventorById(int inventorId);
	
	@Query("select g from Gussmo g WHERE g.code = :code")
	Gussmo findOneGussmoByCode(String code);	

}
