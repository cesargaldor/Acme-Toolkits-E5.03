package acme.features.patron.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.Patronage;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Patron;

@Repository
public interface PatronPatronageRepository extends AbstractRepository{
	@Query("select p from Patronage p")
	Collection<Patronage> findMany();
	
	@Query("select p from Patron p where p.id = ?1")
    Patron PatronById(int id);
	
	@Query("select p from Patronage p where p.patron.id = ?1")
	Patronage findPatronageByPatronId(int id);
	
	@Query("select p from Patronage p where p.patron.id = ?1")
    Collection<Patronage> findPatronagesByPatronId(int id);
}
