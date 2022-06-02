package acme.features.any.item;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.entities.items.Type;
import acme.entities.moneyExchangeCache.MoneyExchangeCache;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyItemRepository extends AbstractRepository {
	
	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);
	
	@Query("select i from Item i, Quantity iq where i.type=:type AND iq.toolkit.id = :masterId AND i.id=iq.item.id")
    Collection<Item> findManyItemsByMasterId(Type type, int masterId);
	
	@Query("select i from Item i where i.type = :type and published=true")
	Collection<Item> findManyItemsByAvailability(Type type);
	
	@Query("select c from MoneyExchangeCache c where c.source = :sourceCurrency and c.target=:targetCurrency")
	Optional<MoneyExchangeCache> findCacheBySourceAndTarget(String sourceCurrency, String targetCurrency);
	

}
