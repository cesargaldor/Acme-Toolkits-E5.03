package acme.features.inventors.toolkits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorToolkitUpdateService implements AbstractUpdateService<Inventor, Toolkit>{

	
	@Autowired
	protected InventorToolkitRepository repository;
	
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void bind(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "code", "title", "description", "assemblyNotes", "moreInfo", "totalPrice");
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "moreInfo", "totalPrice");
		model.setAttribute("readonly", false);
	}

	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request != null;
		Toolkit res;
		int id;
		id = request.getModel().getInteger("id");
		res = this.repository.findOneToolkitById(id);
		return res;
	}

	@Override
	public void validate(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void update(final Request<Toolkit> request, final Toolkit entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);
	}

}
