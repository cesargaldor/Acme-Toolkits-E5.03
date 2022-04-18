package acme.features.inventors.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.roles.Inventor;

@Service
public class InventorsComponentsShowService {

	@Autowired
	protected InventorComponentRepository repository;
	
	
	@Override
	public boolean authorise(final Request<Component> request) {
		assert request != null;
		return true;
	}

	@Override
	public Component findOne(final Request<Component> request) {
		assert request != null;
		Component result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneComponentById(id);
		return result;
	}

	@Override
	public void unbind(final Request<Component> request, final Component entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
		model.setAttribute("readonly", true);
		model.setAttribute("confirmation", false);
		
	}

}