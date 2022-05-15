package acme.features.patron.patronage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Patron;

@Service
public class PatronPatronagePublishService implements AbstractUpdateService<Patron, Patronage>{

	
	@Autowired
	protected PatronPatronageRepository repository;
	
	
	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		final boolean res;
		final int id = request.getModel().getInteger("id");
		final Patronage patronage = this.repository.findPatronageById(id);
		res = request.getPrincipal().hasRole(Patron.class) && !patronage.isPublished();
		return res;
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
		request.unbind(entity, model, "status", "code", "legalStuff", "budget", "moment", "optionalLink", "isPublished");
		model.setAttribute("confirmation", false);
	}

	@Override
	public Patronage findOne(final Request<Patronage> request) {
		assert request != null;
		final Patronage res;
		int id;
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
		entity.setPublished(false);
		this.repository.save(entity);
	}

}
