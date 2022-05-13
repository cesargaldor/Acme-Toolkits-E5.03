package acme.features.patron.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.Patronage;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;
import acme.roles.Patron;

@Repository
public interface PatronPatronageRepository extends AbstractRepository{
	@Query("select p from Patronage p")
	Collection<Patronage> findMany();
	
	@Query("select p from Patron p where p.id = ?1")
    Patron PatronById(int id);
	
	@Query("select p from Patronage p where p.id = :id")
	Patronage findPatronageById(int id);
	
	@Query("select p from Patronage p where p.patron.id = :id")
    Collection<Patronage> findPatronagesByPatronId(int id);
	
	//Consulta que devuelve un inventor dado su username
	@Query("select i from Inventor i where i.userAccount.username = :username")
	Inventor findInventorByUsername(String username);
}
