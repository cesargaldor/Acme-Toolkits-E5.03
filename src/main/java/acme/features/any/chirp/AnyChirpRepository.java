package acme.features.any.chirp;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.chirps.Chirp;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyChirpRepository extends AbstractRepository {

	@Query("select c from Chirp c")
	List<Chirp> findMany();
	
	@Query("select c from Chirp c where c.id=?1")
	Chirp findChirpById(int id);
	

}
