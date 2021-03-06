
package acme.features.any.userAccount;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyUserAccountListInventorService implements AbstractListService<Any, UserAccount> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyUserAccountRepository repository;


	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "username", "identity.name", "identity.surname", "identity.email");

	}

	@Override
	public Collection<UserAccount> findMany(final Request<UserAccount> request) {
		assert request != null;

		final Collection<UserAccount> result = new ArrayList<UserAccount>();
		final Collection<UserAccount> allUserAccounts = this.repository.findAllUserAccounts();

		for (final UserAccount userAccount : allUserAccounts) {
			userAccount.getRoles().forEach(r -> {
				if (r.getUserAccount().isEnabled() && r.getAuthorityName().equals("Inventor")) {
					result.add(userAccount);
				}
			});

		}
		return result;
	}
}
