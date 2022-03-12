
package acme.features.anonymous.patronage;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousPatronageCreateService implements AbstractCreateService<Anonymous, Patronage> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnonymousPatronageRepository repository;

	// AbstractCreateService<Administrator, Patronage> interface --------------


	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
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

		moment = new Date(System.currentTimeMillis());
		result = new Patronage();
		result.setMoment(moment);

		return result;
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}



}
