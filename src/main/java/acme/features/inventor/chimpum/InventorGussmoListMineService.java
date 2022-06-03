package acme.features.inventor.gussmo;

import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import acme.entities.chimpums.Gussmo;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;


@Service
public class InventorGussmoListMineService implements AbstractListService<Inventor, Gussmo> {

	
	@Autowired
	protected InventorGussmoRepository repository;

	// AbstractListService<Inventor, Item> interface ---------------------------

	@Override
	public boolean authorise(final Request<Gussmo> request) {
		assert request != null;

		return true;
	}
	
	@Override
	public Collection<Gussmo> findMany(final Request<Gussmo> request) {
		assert request != null;

		Collection<Gussmo> result;
		Principal principal;

		principal = request.getPrincipal();
		result = this.repository.findManyGussmosByInventorId(principal.getActiveRoleId());

		return result;
	}
	
	
	@Override
	public void unbind(final Request<Gussmo> request, final Gussmo entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "code", "ration");
	}


}
