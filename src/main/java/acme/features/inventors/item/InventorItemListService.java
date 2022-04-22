package acme.features.inventors.item;


import java.util.Collection;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import acme.entities.Items.Item;
import acme.roles.Inventor;

@Service
public class InventorItemListService implements AbstractListService<Inventor, Item>{

	//Internal State
	
	@Autowired
	protected InventorItemRepository repository;
	
	//AbstractListService<Inventor, Item> interface 
	
	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		
		return true; 
	}

	@Override
	public Collection<Item> findMany(final Request<Item> request){
		assert request != null;
		
		Collection<Item> result;
		Principal principal;
		
		
		principal = request.getPrincipal();
		result = this.repository.findMyItems(principal.getUsername());
		
		return result;
	}
	
	@Override
	public void unbind (final Request<Item> request, final Item entity, final Model model) {
		
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "name", "itemType", "code", "technology", "retailPrice");
		
	}
	}