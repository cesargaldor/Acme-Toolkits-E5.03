package acme.features.inventor.CHIMPUM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.CHIMPUMs.CHIMPUM;
import acme.entities.items.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;


@Service
public class InventorCHIMPUMDeleteService implements  AbstractDeleteService<Inventor, CHIMPUM> {

		@Autowired
		protected InventorCHIMPUMRepository repository;


		@Override
		public boolean authorise(final Request<CHIMPUM> request) {
			assert request != null;
			boolean result;
			
			int id;
			Item item;
			Inventor inventor;

			id = request.getModel().getInteger("id");
			item = this.repository.findOneItemByCHIMPUMId(id);
			inventor = item.getInventor();
			result = item.isPublished(); 
			return !result && request.isPrincipal(inventor);
		}

		@Override
		public CHIMPUM findOne(final Request<CHIMPUM> request) {
			assert request != null;
			CHIMPUM result;
			int id;
			id = request.getModel().getInteger("id");
			result = this.repository.findOneCHIMPUMById(id);
			return result;
		}

		@Override
		public void bind(final Request<CHIMPUM> request, final CHIMPUM entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;

			request.bind(entity, errors, "TITLE", "CODE", "DESCRIPTION", "startDate", "endDate", "BUDGET", "optionalLink");
		}

		@Override
		public void unbind(final Request<CHIMPUM> request, final CHIMPUM entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "TITLE", "CODE", "DESCRIPTION", "startDate", "endDate", "BUDGET", "optionalLink");
		}

		@Override
		public void validate(final Request<CHIMPUM> request, final CHIMPUM entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;
		}
		@Override
		public void delete(final Request<CHIMPUM> request, final CHIMPUM entity) {
			assert request != null;
			assert entity != null;
			this.repository.delete(entity);
		}

}
