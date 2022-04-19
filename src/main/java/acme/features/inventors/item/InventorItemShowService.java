package acme.features.inventors.item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.roles.Inventor;

@Service
public class InventorItemShowService {

	@Autowired
	protected InventorItemRepository repository;
	
	
	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		return true;
	}

	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;
		Item result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneItemById(id);
		return result;
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
		model.setAttribute("readonly", true);
		model.setAttribute("confirmation", false);
		
	}

}