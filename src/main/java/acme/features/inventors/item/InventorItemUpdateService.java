package acme.features.inventors.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorItemUpdateService implements AbstractUpdateService<Inventor, Item>{

	
	@Autowired
	protected InventorItemRepository repository;
	
	
	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		final boolean res;
		
		Item item;
		int id;
		
		id = request.getModel().getInteger("id");
		item = this.repository.findOneItemById(id);
		res = request.getPrincipal().hasRole(Inventor.class);
		return res;
	}

	@Override
	public void bind(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "type", "name", "code", "technology","description","retailPrice","optionalLink");
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "type", "name", "code", "technology","description","retailPrice","optionalLink");
		
	}

	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;
		Item res;
		int id;
		id = request.getModel().getInteger("id");
		res = this.repository.findOneItemById(id);
		return res;
	}

	@Override
	public void validate(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void update(final Request<Item> request, final Item entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);
	}

}
