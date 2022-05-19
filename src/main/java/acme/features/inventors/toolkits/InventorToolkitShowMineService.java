package acme.features.inventors.toolkits;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.quantity.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolkitShowMineService implements AbstractShowService<Inventor, Toolkit>{
	
	//Internal State
	
	@Autowired
	protected InventorToolkitRepository repository;
		
	//AbstractShowService<Inventor, Toolkit> interface
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
	
		assert request != null;
		
		final boolean result;
		int id;
		int inventorId;
		Toolkit toolkit;
		Principal principal;
		Collection<Toolkit> ownedToolkits;
		 
		 id = request.getModel().getInteger("id");
		 toolkit = this.repository.findOneToolkitById(id);
		 principal = request.getPrincipal();
		 inventorId = principal.getActiveRoleId();
		 ownedToolkits = this.repository.findToolkitsByInventorId(inventorId);
		 result = ownedToolkits.contains(toolkit);
		
		 return result; 
	}
	
	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request != null;
		
		Toolkit result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneToolkitById(id);
		final Money totalPrice = this.calculateTotalPrice(result);
		result.setTotalPrice(totalPrice);
		this.repository.save(result);
		
		return result;
	}
	
	private Money calculateTotalPrice(final Toolkit t) {
		final Money money = new Money();
		money.setCurrency("EUR"); 
		Double sum=0.;
		final Collection<Quantity> quantities = this.repository.findItemQuantitiesOfToolkit(t.getId());
		for(final Quantity quantity: quantities) {
			sum+=quantity.getItem().getRetailPrice().getAmount()*quantity.getNumber();
		}
		money.setAmount(sum);
		return money;
	
	}

	@Override
	public void unbind (final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "optionalLink", "totalPrice");
	}

}