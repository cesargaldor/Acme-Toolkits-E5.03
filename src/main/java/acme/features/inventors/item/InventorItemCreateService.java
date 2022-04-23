package acme.features.inventors.item;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;
@Service
public class InventorItemCreateService implements AbstractCreateService<Inventor, Item> {


	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorItemRepository repository;

	// AbstractCreateService<Administrator, Item> interface --------------


	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
	}

	@Override
	public Item instantiate(final Request<Item> request) {
		assert request != null;

		Item result;
		//SACAR USER REGISTRADO
		final Integer id = request.getPrincipal().getActiveRoleId();
		final Inventor p = this.repository.InventorById(id);
		
		result = new Item();
		result.setInventor(p);

		return result;
	}

	@Override
	public void validate(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Item> request, final Item entity) {

		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}



}