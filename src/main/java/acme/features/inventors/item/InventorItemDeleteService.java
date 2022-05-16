package acme.features.inventors.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorItemDeleteService implements AbstractDeleteService<Inventor, Item>{

	
	@Autowired
	protected InventorsComponentsRepository repository;

	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		final boolean res;
		final int id = request.getModel().getInteger("id");
		final Item Item = this.repository.findPatronageById(id);
		res = request.getPrincipal().hasRole(Inventor.class) && Item.isPublished();
		return res;
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
		request.unbind(entity, model, "status", "code", "legalStuff", "budget", "moment", "optionalLink", "isPublished");
		final String username = entity.getInventor().getUserAccount().getUsername();
		model.setAttribute("username", username);
		final String fullName = entity.getInventor().getUserAccount().getIdentity().getFullName();
		model.setAttribute("fullName", fullName);
		final String email = entity.getInventor().getUserAccount().getIdentity().getEmail();
		model.setAttribute("email", email);	}

	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;
		Item res;
		int id;
		id = request.getModel().getInteger("id");
		res = this.repository.findPatronageById(id);
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
