package acme.features.inventors.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.entities.items.Type;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorItemRepository extends AbstractRepository {

	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);

	@Query("select i from Item i where i.type=:type AND i.inventor.id = :inventorId")
	Collection<Item> findManyItemsByTypeAndInventorId(Type type, int inventorId);

	@Query("select i.inventor from Item i where i.inventor.id = :inventorId")
	Inventor findInventorById(int inventorId);

}
