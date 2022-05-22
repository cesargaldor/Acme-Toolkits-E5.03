
package acme.features.inventor.patronage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.entities.patronage.Status;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorPatronageUpdateService implements AbstractUpdateService<Inventor, Patronage> {

	@Autowired
	protected InventorPatronageRepository repository;


	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		boolean res;
		//Buscamos patronage por id y solo permitimos acceso a un inventor
		final Integer id = request.getModel().getInteger("id");
		final Patronage patronage = this.repository.findPatronageById(id);
		//Comprobamos que además el status del patronage es PROPOSED
		res = request.getPrincipal().hasRole(Inventor.class) && patronage.getStatus().equals(Status.PROPOSED);
		return res;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity ,errors, "status");

	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.bind(model, null, "status", "code", "legalStuff", "budget", "moment","optionalLink");
		final String fullName = entity.getPatron().getUserAccount().getIdentity().getFullName();
		final String email = entity.getPatron().getUserAccount().getIdentity().getEmail();
		model.setAttribute("fullName", fullName);
		model.setAttribute("email", email);
		model.setAttribute("readonly", false);
		model.setAttribute("confirmation", false);
	}

	@Override
	public Patronage findOne(final Request<Patronage> request) {
		assert request != null;
		Patronage res;
		final Integer id;
		id = request.getModel().getInteger("id");
		res = this.repository.findPatronageById(id);
		return res;
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void update(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);
	}

}
