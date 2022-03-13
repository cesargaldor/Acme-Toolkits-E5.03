
package acme.features.administrator.configuration;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.configuration.Configuration;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractListService;

public class AdministratorConfigurationListService implements AbstractListService<Administrator, Configuration> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorConfigurationRepository repository;

	// AbstractListService<Administrator, Chirp> interface --------------


	@Override
	public boolean authorise(final Request<Configuration> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Configuration> request, final Configuration entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "author", "body", "moment", "email");
	}

	@Override
	public Collection<Configuration> findMany(final Request<Configuration> request) {
		assert request != null;

		Collection<Configuration> result;

		result = this.repository.findManySpamWord();

		return result;
	}
}
