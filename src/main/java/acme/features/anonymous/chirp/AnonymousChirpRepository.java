package acme.features.anonymous.chirp;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.chirps.Chirp;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousChirpRepository extends AbstractRepository {

	@Query("select c from Chirp c")
	Collection<Chirp> findMany();

}
