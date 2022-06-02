package acme.features.inventor.chimpum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chimpums.Chimpum;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;


@Service
public class InventorChimpumListMineService implements AbstractListService<Inventor, Chimpum> {

	
	@Autowired
	protected InventorChimpumRepository repository;

	// AbstractListService<Inventor, Item> interface ---------------------------

	@Override
	public boolean authorise(final Request<Chimpum> request) {
		assert request != null;

		return true;
	}
	
	@Override
	public Collection<Chimpum> findMany(final Request<Chimpum> request) {
		assert request != null;

		Collection<Chimpum> result;
		Principal principal;

		principal = request.getPrincipal();
		result = this.repository.findManyChimpumsByInventorId(principal.getActiveRoleId());

		return result;
	}
	
	
	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "code", "budget");
	}


}
