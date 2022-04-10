package acme.features.any.userAccount;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.roles.Any;
import acme.framework.roles.UserRole;
import acme.framework.services.AbstractShowService;

@Service
public class AnyUserAccountShowService implements AbstractShowService<Any, UserAccount>{

	@Autowired
	protected AnyUserAccountRepository repository;
	
	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;

		return true;
	}

	@Override
	public UserAccount findOne(final Request<UserAccount> request) {
		assert request != null;
		
		UserAccount result;
		final Integer id = request.getModel().getInteger("id");
				
		result = this.repository.findUserAccountById(id);
		
		final boolean containsRoles = result.getRoles().stream().anyMatch(r->(r.getAuthorityName().equals("Patron"))||r.getAuthorityName().equals("Inventor"));
		
		if(!containsRoles) {
			result = null;
		}
		
		return result;
	}

	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "username", "identity.name", "identity.surname", "identity.email");
		
		final Collection<UserRole> roles = entity.getRoles();
		final StringBuilder sb = new StringBuilder();
		
		for (final UserRole role : roles) {
			sb.append(role.getAuthorityName().equals("Patron") || role.getAuthorityName().equals("Inventor") ? role.getAuthorityName() : "");
		}

		model.setAttribute("roles", sb.toString());
		model.setAttribute("onlyInventor", true);
		
		//Este canUpdate se modificará más adelante para que, si el rol logeado es administrador, esté a true
		model.setAttribute("canUpdate", false);
	}

}
