
package acme.features.any.chirp;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.chirps.Chirp;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyChirpListService implements AbstractListService<Any, Chirp> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyChirpRepository repository;

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

		model.setAttribute("readonly", true);
		request.unbind(entity, model, "title", "author", "body", "moment", "email");
	}

	@Override
	public Collection<Chirp> findMany(final Request<Chirp> request) {
		assert request != null;

		final List<Chirp> res;
		final List<Chirp> res2 = new ArrayList<Chirp>();

		res = this.repository.findMany();

		for(int i = 0; i<res.size();i++) {
			final Timestamp d = (Timestamp) res.get(i).getMoment();
			final Duration duration = Duration.between(d.toLocalDateTime(), LocalDateTime.now());
			final long diff = duration.toDays();
			if(diff <= 30) {
				res2.add(res.get(i));
			}
			
		}
		return res2;

	}

}
