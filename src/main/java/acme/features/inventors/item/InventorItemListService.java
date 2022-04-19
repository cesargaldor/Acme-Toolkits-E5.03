package acme.features.inventors.item;

import java.util.Collection;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import acme.entities.Items.Item;
import acme.roles.Inventor;

@Service
public class InventorItemListService implements AbstractListService<Inventor, Item>{

		// Internal state ---------------------------------------------------------

			@Autowired
			protected InventorItemRepository repository;

			// AbstractListService<Administrator, Item> interface --------------


			@Override
			public boolean authorise(final Request<Item> request) {
				assert request != null;

				return true;
			}

			@Override
			public void unbind(final Request<Item> request, final Item entity, final Model model) {
				assert request != null;
				assert entity != null;
				assert model != null;

				request.unbind(entity, model, "status", "code", "legalStuff", "budget", "moment", "optionalLink");
			}

			@Override
			public Collection<Item> findMany(final Request<Item> request) {
				assert request != null;			
				final Integer id = request.getPrincipal().getActiveRoleId();
		        return this.repository.findItemByInventorId(id);

			}
	}