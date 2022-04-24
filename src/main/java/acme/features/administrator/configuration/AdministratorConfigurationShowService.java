package acme.features.administrator.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.Configuration;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorConfigurationShowService  implements AbstractShowService<Administrator, Configuration>{

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
		result = this.repository.findConfiguration().stream().findFirst().get();
		return result;
	}
	
	
	@Override
	public void unbind(final Request<Configuration> request, final Configuration entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "sysCurrency","allowedCurrencies","strongSpam","strongThreshold","weakSpam","weakThreshold");
		model.setAttribute("confirmation", false);
        model.setAttribute("readonly", true);
	}


	
}
