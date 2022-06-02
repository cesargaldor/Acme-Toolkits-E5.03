package acme.features.any.item;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.entities.items.Type;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyItemListMasterService implements AbstractListService<Any, Item> {


	@Autowired
	protected AnyItemRepository repository;


	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;

		return true;
	}
	@Override
	public Collection<Item> findMany(final Request<Item> request) {
		assert request != null;

		Collection<Item> result;
		int masterId;
		Type type;
		
		masterId = request.getModel().getInteger("masterId");
		type = Type.valueOf((String)request.getModel().getAttribute("type"));
		
		result = this.repository.findManyItemsByMasterId(type, masterId);

		return result;
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "code", "technology", "description");
	}
}
