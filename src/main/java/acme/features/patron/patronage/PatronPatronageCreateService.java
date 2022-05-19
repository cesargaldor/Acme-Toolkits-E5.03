
package acme.features.patron.patronage;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.entities.patronage.Status;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;
import acme.roles.Patron;

@Service
public class PatronPatronageCreateService implements AbstractCreateService<Patron, Patronage> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronPatronageRepository repository;

	// AbstractCreateService<Administrator, Patronage> interface --------------


	@Override
	public boolean authorise(final Request<Patronage> request) {
		//Comprobamos que solo un Patron tiene autorización
		assert request != null;
		boolean result;
		result = request.getPrincipal().hasRole(Patron.class);
		return result;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
		final String username = request.getModel().getString("username");
        final Inventor inventor = this.repository.findInventorByUsername(username);
        entity.setInventor(inventor);
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
	}

	@Override
	public Patronage instantiate(final Request<Patronage> request) {
		assert request != null;

		Patronage result;
		Date moment;
		//Sacamos patron por id
		final Integer id = request.getPrincipal().getActiveRoleId();
		final Patron p = this.repository.PatronById(id);
		
		moment = new Date(System.currentTimeMillis());
		result = new Patronage();
		result.setMoment(moment);
		result.setPatron(p);
		result.setPublished(true);
		result.setStatus(Status.PROPOSED);

		return result;
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if (!errors.hasErrors("code")) {
			Patronage p;
			p = this.repository.findPatronageByCode(entity.getCode());
			errors.state(request, p == null, "code", "patron.patronage.form.error.duplicatedCode");
		}
	}

	@Override
	public void create(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}



}
