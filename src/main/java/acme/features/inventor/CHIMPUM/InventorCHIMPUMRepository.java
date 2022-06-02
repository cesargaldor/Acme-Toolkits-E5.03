package acme.features.inventor.CHIMPUM;


import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.CHIMPUMs.CHIMPUM;
import acme.entities.items.Item;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;



@Repository
public interface  InventorCHIMPUMRepository extends AbstractRepository {

	
	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);
	
	@Query("select i from Item i where i.CHIMPUM.id = :id")
	Item findOneItemByCHIMPUMId(int id);
	
	@Query("select c from CHIMPUM c where c.id = :id")
	CHIMPUM findOneCHIMPUMById(int id);
	
	@Query("select c from CHIMPUM c join Item i where i.CHIMPUM.id=c.id AND i.inventor.id = :inventorId")
	Collection<CHIMPUM> findManyCHIMPUMsByInventorId(int inventorId);
	
	@Query("select i.inventor from Item i where i.inventor.id = :inventorId")
	Inventor findInventorById(int inventorId);
	
	@Query("select c from CHIMPUM c WHERE c.CODE = :CODE")
	CHIMPUM findOneCHIMPUMByCode(String code);	

}
