package acme.features.inventor.gussmo;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import acme.entities.gussmos.Gussmo;
import acme.entities.items.Item;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorGussmoUpdateService implements AbstractUpdateService<Inventor, Gussmo> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorGussmoRepository						repository;


	// AbstractUpdateService<Inventor,Item> interface -----------------

	@Override
	public void validate(final Request<Gussmo> request, final Gussmo entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;


		if (!errors.hasErrors("startDate")) {
			errors.state(request, entity.getStartDate().after(entity.getCreationMoment()), "startDate", "inventor.gussmo.form.error.past-start-date");
		}
		
		if (!errors.hasErrors("startDate")) {
			final Date oneMonthAfterCreationDate = DateUtils.addMonths(entity.getCreationMoment(), 1);
			errors.state(request, entity.getStartDate().equals(oneMonthAfterCreationDate) || entity.getStartDate().after(oneMonthAfterCreationDate), "startDate", "inventor.gussmo.form.error.too-close");
		}

		if (!errors.hasErrors("endDate")) {
			errors.state(request, entity.getEndDate().after(entity.getCreationMoment()), "endDate", "inventor.gussmo.form.error.past-end-date");
		}
		if (!errors.hasErrors("endDate")) {
			errors.state(request, entity.getEndDate().after(entity.getStartDate()), "endDate", "inventor.gussmo.form.error.end-date-previous-to-start-date");
		}
		

	

	}

	@Override
	public boolean authorise(final Request<Gussmo> request) {
		assert request != null;
		boolean result = false;

		int id;
		Item item;
		Inventor inventor;

		id = request.getModel().getInteger("id");
		item = this.repository.findOneItemByGussmoId(id);
		result = item.isPublished(); 
		inventor = item.getInventor();
		
		
		return !result && request.isPrincipal(inventor);
	}

	@Override
	public void bind(final Request<Gussmo> request, final Gussmo entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "name", "explanation", "startDate", "endDate", "ration", "optionalLink");
	}

	@Override
	public void unbind(final Request<Gussmo> request, final Gussmo entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		final int id;
		final Item item;
		boolean published;

		id = request.getModel().getInteger("id");
		item = this.repository.findOneItemByGussmoId(id);
		published = item.isPublished();
		
		request.unbind(entity, model, "name", "explanation","creationMoment", "startDate", "endDate", "ration", "optionalLink");
		model.setAttribute("published", published);
		
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
	public void update(final Request<Gussmo> request, final Gussmo entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}
	
	


}