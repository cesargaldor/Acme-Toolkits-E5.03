package acme.features.anonymous.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.Patronage;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousPatronageRepository extends AbstractRepository{
	@Query("select p from Patronage p")
	Collection<Patronage> findMany();
}
