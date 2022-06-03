package acme.features.inventor.chimpum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.chimpums.Chimpum;
import acme.entities.items.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorChimpumShowMineService implements AbstractShowService<Inventor, Chimpum> {

	
	@Autowired
	protected InventorChimpumRepository repository;

	// AbstractShowService<Inventor, Item> interface ---------------------------

	@Override
	public boolean authorise(final Request<Chimpum> request) {
		assert request != null;

		int id;
		Item item;
		Inventor inventor;

		id = request.getModel().getInteger("id");
		item = this.repository.findOneItemByChimpumId(id);
		inventor = item.getInventor();

		return request.isPrincipal(inventor);
	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		Item item;
		int id;
		final int masterId;
		id=request.getModel().getInteger("id");
		item=this.repository.findOneItemByChimpumId(id);
		masterId=item.getId();	
		request.unbind(entity, model, "title", "code", "description", "startDate", "endDate", "budget", "optionalLink");
		model.setAttribute("masterId", masterId);
		model.setAttribute("published", item.isPublished());
	}
	
	@Override
	public Chimpum findOne(final Request<Chimpum> request) {
		assert request != null;
		Chimpum result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneChimpumById(id);

		return result;
	}



}