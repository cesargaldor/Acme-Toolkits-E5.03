package acme.features.inventor.item;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import acme.entities.items.Item;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorItemShowMineService implements AbstractShowService<Inventor, Item> {

	//Internal State

	@Autowired
	protected InventorItemRepository repository;

	//AbstractShowService<Inventor, Item> interface


	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;

		boolean result;
		int id;
		Item item;
		Inventor inventor;
		Principal principal;

		id = request.getModel().getInteger("id");
		item = this.repository.findOneItemById(id);
		inventor = item.getInventor();
		principal = request.getPrincipal();
		result = inventor.getUserAccount().getId() == principal.getAccountId();

		return result;
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

		request.unbind(entity, model, "name", "type", "code", "technology", "description", "retailPrice", "optionalLink", "published","gussmo");
	}
}
