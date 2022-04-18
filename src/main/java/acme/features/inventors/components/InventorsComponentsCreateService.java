
package acme.features.inventors.components;

import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import acme.entities.components.Component;
import acme.roles.Inventor;

@Service
public class InventorsComponentsCreateService implements AbstractCreateService<Inventor, Component> {


	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorComponentsRepository repository;

	// AbstractCreateService<Administrator, Components> interface --------------


	@Override
	public boolean authorise(final Request<Components> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Components> request, final Components entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
	}

	@Override
	public void unbind(final Request<Components> request, final Components entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
	}

	@Override
	public Components instantiate(final Request<Components> request) {
		assert request != null;

		Components result;
		Date moment;
		//SACAR USER REGISTRADO
		final Integer id = request.getPrincipal().getActiveRoleId();
		final Inventor p = this.repository.InventorById(id);
		
		moment = new Date(System.currentTimeMillis());
		result = new Components();
		result.setMoment(moment);
		result.setInventor(p);

		return result;
	}

	@Override
	public void validate(final Request<Components> request, final Components entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Components> request, final Components entity) {

		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}



}