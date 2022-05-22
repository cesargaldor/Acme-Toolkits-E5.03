package acme.features.patron.patronage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronPatronageShowService implements AbstractShowService<Patron, Patronage>{

	@Autowired
	protected PatronPatronageRepository repository;
	
	
	@Override
	public boolean authorise(final Request<Patronage> request) {
		//Comprobamos que solo un usuario con rol Patron tiene autorización.
		assert request != null;
		boolean result;
		result = request.getPrincipal().hasRole(Patron.class);
		return result;
	}

	@Override
	public Patronage findOne(final Request<Patronage> request) {
		assert request != null;
		final Patronage result;
		int id;
		id = request.getModel().getInteger("id");
		result= this.repository.findPatronageById(id);
		return result;
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;		
		assert entity != null;
		assert model != null;
		
		final String username = entity.getInventor().getUserAccount().getUsername();
		final String email = entity.getInventor().getUserAccount().getIdentity().getEmail();
		final String fullName = entity.getInventor().getUserAccount().getIdentity().getFullName();
		model.setAttribute("username", username);
		model.setAttribute("email", email);
		model.setAttribute("fullName", fullName);
		request.unbind(entity, model, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
		model.setAttribute("readonly", entity.isPublished());
	}

		
	
	
}
