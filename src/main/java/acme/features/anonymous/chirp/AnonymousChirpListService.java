
package acme.features.anonymous.chirp;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.chirps.Chirp;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousChirpListService implements AbstractListService<Anonymous, Chirp> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnonymousChirpRepository repository;

	// AbstractListService<Administrator, Chirp> interface --------------


	@Override
	public boolean authorise(final Request<Chirp> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Chirp> request, final Chirp entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "author", "body", "moment", "email");
	}

	@Override
	public Collection<Chirp> findMany(final Request<Chirp> request) {
		assert request != null;

		Collection<Chirp> result;

		result = this.repository.findMany();

		final LocalDate now = LocalDate.now();
		final LocalDate minus30days = now.minusMonths(1);

		final Date date = Date.from(minus30days.atStartOfDay(ZoneId.systemDefault()).toInstant());

		return result.stream().filter(r -> r.getMoment().after(date)).collect(Collectors.toList());

	}

}
