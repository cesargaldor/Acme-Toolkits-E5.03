package acme.features.inventor.chimpum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chimpums.Chimpum;
import acme.entities.items.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;


@Service
public class InventorChimpumDeleteService implements  AbstractDeleteService<Inventor, Chimpum> {

		@Autowired
		protected InventorChimpumRepository repository;


		@Override
		public boolean authorise(final Request<Chimpum> request) {
			assert request != null;
			boolean result;	
			int id;
			Item item;
			Inventor inventor;
			id = request.getModel().getInteger("id");
			item = this.repository.findOneItemByChimpumId(id);
			inventor = item.getInventor();
			result = item.isPublished(); 
			return !result && request.isPrincipal(inventor);
		}

		@Override
		public Chimpum findOne(final Request<Chimpum> request) {
			assert request != null;
			Chimpum result;
			int id;
			id = request.getModel().getInteger("id");
			result = this.repository.findOneChimpumById(id);
			return result;
		}

		@Override
		public void bind(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;

			request.bind(entity, errors, "title", "code", "description", "startDate", "endDate", "budget", "optionalLink");
		}

		@Override
		public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "title", "code", "description", "startDate", "endDate", "budget", "optionalLink");
		}

		@Override
		public void validate(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;
		}
		@Override
		public void delete(final Request<Chimpum> request, final Chimpum entity) {
			assert request != null;
			assert entity != null;
			Item item;
			
			item = this.repository.findOneItemByChimpumId(entity.getId());
			item.setChimpum(null);
			
			this.repository.save(item);
			this.repository.delete(entity);
		}

}
