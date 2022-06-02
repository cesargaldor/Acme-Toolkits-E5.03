package acme.features.inventor.CHIMPUM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.CHIMPUMs.CHIMPUM;
import acme.entities.items.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorCHIMPUMShowMineService implements AbstractShowService<Inventor, CHIMPUM> {

	
	@Autowired
	protected InventorCHIMPUMRepository repository;

	// AbstractShowService<Inventor, Item> interface ---------------------------

	@Override
	public boolean authorise(final Request<CHIMPUM> request) {
		assert request != null;
		boolean result;
		int id;
		Item item;
		Inventor inventor;
		Principal principal;
		id = request.getModel().getInteger("id");
		item = this.repository.findOneItemByCHIMPUMId(id);
		inventor = item.getInventor();
		principal = request.getPrincipal();
		result = inventor.getUserAccount().getId() == principal.getAccountId();
		return result;
	}

	@Override
	public void unbind(final Request<CHIMPUM> request, final CHIMPUM entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		Item item;
		int id;
		final int masterId;
		
		id=request.getModel().getInteger("id");
		item=this.repository.findOneItemByCHIMPUMId(id);
		masterId=item.getId();
		
		request.unbind(entity, model, "TITLE", "CODE", "DESCRIPTION", "startDate", "endDate", "BUDGET", "optionalLink");
		model.setAttribute("masterId", masterId);
		model.setAttribute("published", item.isPublished());
	}
	
	@Override
	public CHIMPUM findOne(final Request<CHIMPUM> request) {
		assert request != null;
		CHIMPUM result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneCHIMPUMById(id);

		return result;
	}



}