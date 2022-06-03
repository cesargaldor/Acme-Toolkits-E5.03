package acme.features.inventor.gussmo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import acme.entities.gussmos.Gussmo;
import acme.entities.items.Item;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorGussmoShowMineService implements AbstractShowService<Inventor, Gussmo> {

	
	@Autowired
	protected InventorGussmoRepository repository;

	// AbstractShowService<Inventor, Item> interface ---------------------------

	@Override
	public boolean authorise(final Request<Gussmo> request) {
		assert request != null;

		int id;
		Item item;
		Inventor inventor;

		id = request.getModel().getInteger("id");
		item = this.repository.findOneItemByGussmoId(id);
		inventor = item.getInventor();

		return request.isPrincipal(inventor);
	}

	@Override
	public void unbind(final Request<Gussmo> request, final Gussmo entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		Item item;
		int id;
		final int masterId;
		id=request.getModel().getInteger("id");
		item=this.repository.findOneItemByGussmoId(id);
		masterId=item.getId();	
		request.unbind(entity, model, "name", "code", "explanation", "startDate", "endDate", "ration", "optionalLink");
		model.setAttribute("masterId", masterId);
		model.setAttribute("published", item.isPublished());
	}
	
	@Override
	public Gussmo findOne(final Request<Gussmo> request) {
		assert request != null;
		Gussmo result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneGussmoById(id);

		return result;
	}



}