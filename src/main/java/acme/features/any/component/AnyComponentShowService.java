package acme.features.any.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.components.Component;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyComponentShowService implements AbstractShowService<Any, Component>{

	@Autowired
	protected AnyComponentRepository repository;
	
	@Override
	public boolean authorise(final Request<Component> request) {
		assert request != null;

		return true;
	}

	@Override
	public Component findOne(final Request<Component> request) {
		assert request != null;
		
		Component result;
		final Integer id = request.getModel().getInteger("id");
		result = this.repository.findOneComponentById(id);
		
		System.out.println("Resultado " + result);

		return result;
	}

	@Override
	public void unbind(final Request<Component> request, final Component entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "name", "code", "technology", "description", "retailPrice", "optionalLink", "component.inventor");
		model.setAttribute("onlyInventor", true);
	}

}
