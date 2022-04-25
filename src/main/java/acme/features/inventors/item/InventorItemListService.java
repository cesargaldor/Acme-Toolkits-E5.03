package acme.features.inventors.item;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;
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
		
		request.unbind(entity, model,  "type", "name", "code", "technology", "description", "retailPrice", "optionalLink");
		
	}
	}