package acme.features.inventor.gussmo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import acme.entities.chimpums.Gussmo;
import acme.entities.items.Item;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;


@Service
public class InventorGussmoDeleteService implements  AbstractDeleteService<Inventor, Gussmo> {

		@Autowired
		protected InventorGussmoRepository repository;


		@Override
		public boolean authorise(final Request<Gussmo> request) {
			assert request != null;
			boolean result;	
			int id;
			Item item;
			Inventor inventor;
			id = request.getModel().getInteger("id");
			item = this.repository.findOneItemByGussmoId(id);
			inventor = item.getInventor();
			result = item.isPublished(); 
			return !result && request.isPrincipal(inventor);
		}

		@Override
		public Gussmo findOne(final Request<Gussmo> request) {
			assert request != null;
			Gussmo result;
			int id;
			id = request.getModel().getInteger("id");
			result = this.repository.findOneGussmoById(id);
			return result;
		}

		@Override
		public void bind(final Request<Gussmo> request, final Gussmo entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;

			request.bind(entity, errors, "name", "code", "explanation", "startDate", "endDate", "ration", "optionalLink");
		}

		@Override
		public void unbind(final Request<Gussmo> request, final Gussmo entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "name", "code", "explanation", "startDate", "endDate", "ration", "optionalLink");
		}

		@Override
		public void validate(final Request<Gussmo> request, final Gussmo entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;
		}
		@Override
		public void delete(final Request<Gussmo> request, final Gussmo entity) {
			assert request != null;
			assert entity != null;
			Item item;
			
			item = this.repository.findOneItemByGussmoId(entity.getId());
			item.setGussmo(null);
			
			this.repository.save(item);
			this.repository.delete(entity);
		}

}
