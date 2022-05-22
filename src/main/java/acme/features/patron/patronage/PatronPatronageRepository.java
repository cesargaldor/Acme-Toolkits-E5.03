
package acme.features.patron.patronage;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.Patronage;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;
import acme.roles.Patron;

@Repository
public interface PatronPatronageRepository extends AbstractRepository {

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

	//Consulta para buscar un patronage dado un code
	@Query("select p from Patronage p where p.code like :code")
	Patronage findPatronageByCode(String code);

	@Query("select t from Inventor t")
	List<Inventor> getAllInventors();
	
	@Query("Select i from Inventor i where i.id = :id") 
	Inventor getInventorById(int id); 
}
