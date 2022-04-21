package acme.features.patron.patronage;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Patron;

@Service
public class PatronPatronageListService implements AbstractListService<Patron, Patronage>{

	// Internal state ---------------------------------------------------------

		@Autowired
		protected PatronPatronageRepository repository;

		// AbstractListService<Administrator, Patronage> interface --------------


		@Override
		public boolean authorise(final Request<Patronage> request) {
			assert request != null;

			return true;
		}

		@Override
		public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
		}

		@Override
		public Collection<Patronage> findMany(final Request<Patronage> request) {
			assert request != null;			
			final Integer id = request.getPrincipal().getActiveRoleId();
			//Filtramos patronages por ID de patron
	        return this.repository.findMany().stream().filter(p -> p.getPatron().getId() == id).collect(Collectors.toList());

		}
}
