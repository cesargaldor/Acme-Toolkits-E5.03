
package acme.features.inventors.item;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item.Item;
import acme.entities.Item.Status;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;
import acme.roles.Inventor;

@Service
public class InventorItemCreateService implements AbstractCreateService<Inventor, Item> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorItemRepository repository;

	// AbstractCreateService<Administrator, Item> interface --------------


	@Override
	public boolean authorise(final Request<Item> request) {
		//Comprobamos que solo un Inventor tiene autorización
		assert request != null;
		boolean result;
		result = request.getPrincipal().hasRole(Inventor.class);
		return result;
	}

	@Override
	public void bind(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
		final String username = request.getModel().getString("username");
        final Inventor inventor = this.repository.findInventorByUsername(username);
        entity.setInventor(inventor);
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
		Date moment;
		//Sacamos Inventor por id
		final Integer id = request.getPrincipal().getActiveRoleId();
		final Inventor p = this.repository.InventorById(id);
		
		moment = new Date(System.currentTimeMillis());
		result = new Item();
		result.setMoment(moment);
		result.setInventor(p);
		result.setPublished(true);
		result.setStatus(Status.PROPOSED);

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
