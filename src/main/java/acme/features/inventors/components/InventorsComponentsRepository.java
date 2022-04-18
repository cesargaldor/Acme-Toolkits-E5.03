package acme.features.inventors.Component;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Component.Component;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorsComponentRepository extends AbstractRepository{
	
	@Query("select p from Component p")
	Collection<Component> findMany();
	
	@Query("select p from Component p where p.id = :id")
	Component findOneComponentById(int id);
	
	@Query("select p from Inventor p where p.id = ?1")
    Inventor InventorById(int id);
	
	@Query("select p from Component p where p.Inventor.id = ?1")
    Collection<Component> findComponentByInventorId(int id);
}
