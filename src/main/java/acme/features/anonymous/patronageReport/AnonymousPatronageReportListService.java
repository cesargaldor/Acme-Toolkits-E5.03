package acme.features.anonymous.patronageReport;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.patronage.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Anonymous;
import acme.framework.services.AbstractListService;

public class AnonymousPatronageReportListService implements AbstractListService<Anonymous, Patronage>{

	// Internal state ---------------------------------------------------------

		@Autowired
		protected AnonymousPatronageReportRepository repository;

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

			Collection<Patronage> result;

			result = this.repository.findMany();

			return result;
		}
}
