package acme.features.administrator.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.Configuration;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractUpdateService;


@Service
public class AdministratorConfigurationUpdateService implements AbstractUpdateService<Administrator, Configuration>{

	@Autowired
	protected AdministratorConfigurationRepository repository;
	
	@Override
	public boolean authorise(final Request<Configuration> request) {
		assert request != null;

		return true;
	}
	
	@Override
	public void bind(final Request<Configuration> request, final Configuration entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "sysCurrency","allowedCurrencies","strongSpam","weakSpam","strongThreshold","weakThreshold");
	}
	
	@Override
	public void unbind(final Request<Configuration> request, final Configuration entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "sysCurrency","allowedCurrencies","strongSpam","weakSpam","strongThreshold","weakThreshold");
	}
	
	@Override
	public Configuration findOne(final Request<Configuration> request) {
		assert request != null;

		Configuration result;
		
		result = this.repository.findConfiguration();

		return result;
	}

	@Override
	public void validate(final Request<Configuration> request, final Configuration entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}
	
	@Override
	public void update(final Request<Configuration> request, final Configuration entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}
	
//	@Override
//	public void onSuccess(final Request<Configuration> request, final Response<Configuration> response) {
//		assert request != null;
//		assert response != null;
//
//		if (request.isMethod(HttpMethod.POST)) {
//			PrincipalHelper.handleUpdate();
//		}
//	}
}
