
package acme.features.anonymous.patronage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousPatronageCreateService implements AbstractCreateService {

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

		request.bind(entity, errors, "moment", "title", "author", "body", "email");
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "title", "author", "body", "email");
	}

	@Override
	public Patronage instantiate(final Request<Patronage> request) {
		assert request != null;

		Patronage result;
		Date moment;

		moment = new Date(System.currentTimeMillis());

		result = new Patronage();
		//			result.setTitle("Prueba creando un Patronage");
		//			result.setAuthor("César Gálvez");
		//			result.setBody("Lorem ipsum!");
		result.setMoment(moment);
		//			result.setEmail("cesgaldor@alum.us.es");

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
