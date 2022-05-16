
package acme.features.inventors.toolkits;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Toolkit.Toolkit;
import acme.entities.Toolkit.Status;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;
import acme.roles.Inventor;

@Service
public class InventorToolkitCreateService implements AbstractCreateService<Inventor, Toolkit> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronPatronageRepository repository;

	// AbstractCreateService<Administrator, Toolkit> interface --------------


	@Override
	public boolean authorise(final Request<Toolkit> request) {
		//Comprobamos que solo un Inventor tiene autorización
		assert request != null;
		boolean result;
		result = request.getPrincipal().hasRole(Inventor.class);
		return result;
	}

	@Override
	public void bind(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
		final String username = request.getModel().getString("username");
        final Inventor inventor = this.repository.findInventorByUsername(username);
        entity.setInventor(inventor);
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
	}

	@Override
	public Toolkit instantiate(final Request<Toolkit> request) {
		assert request != null;

		Toolkit result;
		Date moment;
		//Sacamos Inventor por id
		final Integer id = request.getPrincipal().getActiveRoleId();
		final Inventor p = this.repository.PatronById(id);
		
		moment = new Date(System.currentTimeMillis());
		result = new Toolkit();
		result.setMoment(moment);
		result.setPatron(p);
		result.setPublished(true);
		result.setStatus(Status.PROPOSED);

		return result;
	}

	@Override
	public void validate(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Toolkit> request, final Toolkit entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}



}
