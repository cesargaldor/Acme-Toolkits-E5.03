package acme.features.inventor.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.Patronage;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Patron;

@Repository
public interface InventorPatronageRepository extends AbstractRepository{

	@Query("select p from Patronage p")
	Collection<Patronage> findMany();
	
	@Query("select i from Inventor i where i.id = ?1")
    Patron InventorById(int id);
	
	@Query("select p from Patronage p where p.id = :id")
	Patronage findPatronageById(int id);
	
	@Query("select p from Patronage p where p.inventor.id = :id")
    Collection<Patronage> findPatronagesByInventorId(int id);
	
}
