package acme.features.authenticated.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.Configuration;
import acme.features.administrator.configuration.AdministratorConfigurationRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedConfigurationShowService implements AbstractShowService<Authenticated,Configuration>{
	
	@Autowired
	protected AdministratorConfigurationRepository repository;
	
	@Override
	public boolean authorise(final Request<Configuration> request) {
		assert request != null;
		return true;
	}

	@Override
	public Configuration findOne(final Request<Configuration> request) {
		assert request != null;
		Configuration result;
		result = this.repository.findConfiguration();
		return result;
	}

	@Override
	public void unbind(final Request<Configuration> request, final Configuration entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "sysCurrency","allowedCurrencies");
		model.setAttribute("confirmation", false);
		model.setAttribute("readonly", true);
	}

	
}
