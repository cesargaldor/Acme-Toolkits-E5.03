package acme.features.inventors.components;

import java.util.Collection;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import acme.entities.components.Component;
import acme.roles.Inventor;

@Service
public class InventorsComponentsListService implements AbstractListService<Inventor, Component>{

	// Internal state ---------------------------------------------------------

			@Autowired
			protected InventorComponentRepository repository;

			// AbstractListService<Administrator, Component> interface --------------


			@Override
			public boolean authorise(final Request<Component> request) {
				assert request != null;

				return true;
			}

			@Override
			public void unbind(final Request<Component> request, final Component entity, final Model model) {
				assert request != null;
				assert entity != null;
				assert model != null;

				request.unbind(entity, model, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
			}

			@Override
			public Collection<Component> findMany(final Request<Component> request) {
				assert request != null;			
				final Integer id = request.getPrincipal().getActiveRoleId();
		        return this.repository.findComponentByInventorId(id);

			}
	}