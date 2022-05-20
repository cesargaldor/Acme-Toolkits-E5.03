package acme.features.inventors.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorItemDeleteService implements AbstractDeleteService<Inventor, Item>{

	
	@Autowired
	protected InventorItemRepository repository;

	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		boolean res;
		
		Item item;
		int id;
		
		id = request.getModel().getInteger("id");
		item = this.repository.findOneItemById(id);
		res = item.isPublished();
		return !res;
	}

	@Override
	public void bind(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "name", "type", "code","technology","description","retailPrice","optionalLink","published");
		
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "name", "type", "code","technology","description","retailPrice","optionalLink","published");
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
		assert request !=null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void delete(final Request<Item> request, final Item entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.delete(entity);
		
	}
	
	
	
	
}
