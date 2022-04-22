package acme.features.inventors.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.roles.Inventor;

@Service
public class InventorItemShowService implements AbstractShowService<Inventor, Item>{


	//Internal State
	
	@Autowired
	protected InventorItemRepository repository;
		
	//AbstractShowService<Inventor, Item> interface
	
	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		 boolean result;
		 int itemId;
		 Item item;
		 
		 itemId = request.getModel().getInteger("id");
		 item = this.repository.findOneItemById(itemId);
		 result = item.getInventor().getId()==request.getPrincipal().getActiveRoleId();
		
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
	public void unbind (final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "name","itemType", "code", "technology", "description", "retailPrice", "optionalLink");
	}
}