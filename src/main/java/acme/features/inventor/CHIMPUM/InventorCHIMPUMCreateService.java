package acme.features.inventor.CHIMPUM;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.CHIMPUMs.CHIMPUM;
import acme.entities.items.Item;
import acme.entities.items.Type;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorCHIMPUMCreateService implements AbstractCreateService<Inventor, CHIMPUM> {

	@Autowired
	protected InventorCHIMPUMRepository						repository;


	
	@Override
	public boolean authorise(final Request<CHIMPUM> request) {
		assert request != null;

		final Type type = Type.COMPONENT; // <------------------------------------------------------------- Cambiar por el del examen ----------------
		int id;
		Item item;

		id = request.getModel().getInteger("id");
		item = this.repository.findOneItemByCHIMPUMId(id);
		return !item.isPublished() && item.getType().equals(type);
	}


	@Override
	public CHIMPUM instantiate(final Request<CHIMPUM> request) {
		assert request != null;
		final CHIMPUM CHIMPUM;

		CHIMPUM = new CHIMPUM();

		return CHIMPUM;
	}

	@Override
	public void bind(final Request<CHIMPUM> request, final CHIMPUM entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "TITLE", "CODE", "DESCRIPTION", "startDate", "endDate", "BUDGET", "optionalLink");

	}
	

	@Override
	public void validate(final Request<CHIMPUM> request, final CHIMPUM entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		final Calendar moment = Calendar.getInstance();
		final String finalCode;

		final Date now = new Date(System.currentTimeMillis() - 1);

		moment.setTime(now);

		finalCode = this.generateCode(entity.getCODE(), moment);
		entity.setCODE(finalCode);
		entity.setCREATION_MOMENT(moment.getTime());

	

		if (!errors.hasErrors("CODE")) {
			final CHIMPUM existing = this.repository.findOneCHIMPUMByCode(entity.getCODE());
			errors.state(request, existing == null, "CODE", "inventor.item.form.error.duplicated");
		}

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
	public void unbind(final Request<CHIMPUM> request, final CHIMPUM entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "TITLE", "CODE", "DESCRIPTION", "startDate", "endDate", "BUDGET", "optionalLink");
	}

	@Override
	public void create(final Request<CHIMPUM> request, final CHIMPUM entity) {
		assert request != null;
		assert entity != null;

		int masterId;
		Item item;

		masterId = request.getModel().getInteger("masterId");
		item = this.repository.findOneItemById(masterId);

		this.repository.save(entity);
		item.setCHIMPUM(entity);
		this.repository.save(item);
	}
	
	private String generateCode(final String code, final Calendar moment) {
		final String yy = String.valueOf(moment.get(Calendar.YEAR));
		final String mm = String.valueOf(moment.get(Calendar.MONTH));
		final String dd = String.valueOf(moment.get(Calendar.DAY_OF_MONTH));

		return code + "-" + yy + "/" + mm + "/" + dd;
	}

	
}


