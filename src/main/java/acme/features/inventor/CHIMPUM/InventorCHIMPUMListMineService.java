package acme.features.inventor.CHIMPUM;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.CHIMPUMs.CHIMPUM;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;


@Service
public class InventorCHIMPUMListMineService implements AbstractListService<Inventor, CHIMPUM> {

	
	@Autowired
	protected InventorCHIMPUMRepository repository;

	// AbstractListService<Inventor, Item> interface ---------------------------

	@Override
	public boolean authorise(final Request<CHIMPUM> request) {
		assert request != null;

		return true;
	}
	
	@Override
	public Collection<CHIMPUM> findMany(final Request<CHIMPUM> request) {
		assert request != null;

		Collection<CHIMPUM> result;
		Principal principal;

		principal = request.getPrincipal();
		result = this.repository.findManyCHIMPUMsByInventorId(principal.getActiveRoleId());

		return result;
	}
	
	
	@Override
	public void unbind(final Request<CHIMPUM> request, final CHIMPUM entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "TITLE", "CODE", "BUDGET");
	}


}
