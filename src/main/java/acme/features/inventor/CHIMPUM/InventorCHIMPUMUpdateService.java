package acme.features.inventor.CHIMPUM;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.CHIMPUMs.CHIMPUM;
import acme.entities.items.Item;
import acme.features.administrator.configuration.AdministratorConfigurationRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorCHIMPUMUpdateService implements AbstractUpdateService<Inventor, CHIMPUM> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorCHIMPUMRepository						repository;

	@Autowired
	protected AdministratorConfigurationRepository	scRepo;

	// AbstractUpdateService<Inventor,Item> interface -----------------

	@Override
	public void validate(final Request<CHIMPUM> request, final CHIMPUM entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;


		if (!errors.hasErrors("startDate")) {
			errors.state(request, entity.getStartDate().after(entity.getCREATION_MOMENT()), "startDate", "inventor.CHIMPUM.form.error.past-start-date");
		}
		
		if (!errors.hasErrors("startDate")) {
			final Date oneMonthAfterCreationDate = DateUtils.addMonths(entity.getCREATION_MOMENT(), 1);
			errors.state(request, entity.getStartDate().equals(oneMonthAfterCreationDate) || entity.getStartDate().after(oneMonthAfterCreationDate), "startDate", "inventor.CHIMPUM.form.error.too-close");
		}

		if (!errors.hasErrors("endDate")) {
			errors.state(request, entity.getEndDate().after(entity.getCREATION_MOMENT()), "endDate", "inventor.CHIMPUM.form.error.past-end-date");
		}
		if (!errors.hasErrors("endDate")) {
			errors.state(request, entity.getEndDate().after(entity.getStartDate()), "endDate", "inventor.CHIMPUM.form.error.end-date-previous-to-start-date");
		}
		if (!errors.hasErrors("endDate")) {
			final Date oneWeekAfterStartDate = DateUtils.addWeeks(entity.getStartDate(), 1);
			errors.state(request, entity.getEndDate().equals(oneWeekAfterStartDate) || entity.getEndDate().after(oneWeekAfterStartDate), "endDate", "inventor.CHIMPUM.form.error.insufficient-duration");
		}

		if (!errors.hasErrors("BUDGET")) {
			final Money BUDGET = entity.getBUDGET();
			final boolean BUDGETPositive = BUDGET.getAmount() > 0.;
			errors.state(request, BUDGETPositive, "BUDGET", "inventor.CHIMPUM.form.error.BUDGET-positive");

		}

	}

	@Override
	public boolean authorise(final Request<CHIMPUM> request) {
		assert request != null;
		boolean result = false;

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
	public void bind(final Request<CHIMPUM> request, final CHIMPUM entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "TITLE", "DESCRIPTION", "startDate", "endDate", "BUDGET", "optionalLink");
	}

	@Override
	public void unbind(final Request<CHIMPUM> request, final CHIMPUM entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "TITLE", "DESCRIPTION","CREATION_MOMENT", "startDate", "endDate", "BUDGET", "optionalLink");
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
	public void update(final Request<CHIMPUM> request, final CHIMPUM entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}
	
	


}