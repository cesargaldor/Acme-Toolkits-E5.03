package acme.features.inventor.patronage;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorPatronageListService implements AbstractListService<Inventor, Patronage>{
	//Internal state ---------------------------------------------
	
	@Autowired
	protected InventorPatronageRepository repository;

	@Override
	public boolean authorise(final Request<Patronage> request) {
		//Comprobamos que solo un usuario con rol Inventor tiene autorización.
		assert request != null;
		boolean result;
		result = request.getPrincipal().hasRole(Inventor.class);
		return result;
	}
	@Override
	public Collection<Patronage> findMany(final Request<Patronage> request) {
		assert request != null;
		final Integer id = request.getPrincipal().getActiveRoleId();
		return this.repository.findMany().stream().filter(p -> p.getInventor().getId() == id).collect(Collectors.toList());
	}


	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
//		model.setAttribute("inventor", entity.getInventor().getUserAccount().getUsername());
		request.unbind(entity, model, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
///		final Status status = entity.getStatus();
//		model.setAttribute("status", status);

	}
}
