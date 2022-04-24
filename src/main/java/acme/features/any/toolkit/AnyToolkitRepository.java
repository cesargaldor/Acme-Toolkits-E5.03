package acme.features.any.toolkit;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.quantity.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.framework.repositories.AbstractRepository;


@Repository
public interface AnyToolkitRepository extends AbstractRepository {

	@Query("select t from Toolkit t where t.id = :id")
	Toolkit findOneToolkitById(int id);

	@Query("select t from Toolkit t where t.draft = false")
	Collection<Toolkit> findManyToolkitsByAvailability();
	
	@Query("select iq from Quantity iq where iq.toolkit.id = :masterId")
    Collection<Quantity> findItemQuantitiesOfToolkit(int masterId);
}
