package acme.features.inventor.chimpum;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chimpums.Chimpum;
import acme.entities.items.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorChimpumCreateService implements AbstractCreateService<Inventor, Chimpum> {

	@Autowired
	protected InventorChimpumRepository						repository;


	
	@Override
	public boolean authorise(final Request<Chimpum> request) {
		assert request != null;

		//final ItemType type = ItemType.COMPONENT; //  <----------------------CAMBIAR POR EL DEL EXAMEN
		int id;
		Item item;
		Inventor inventor;

		id = request.getModel().getInteger("masterId");
		item = this.repository.findOneItemById(id);
		inventor = item.getInventor();

		return request.isPrincipal(inventor) && !item.isPublished() && item.getChimpum() == null; //&& item.getType().equals(type); //<----------------------CAMBIAR POR EL DEL EXAMEN
	}


	@Override
	public Chimpum instantiate(final Request<Chimpum> request) {
		assert request != null;
		final Chimpum result;
		Date moment;
		Date startDate, endDate;

		result = new Chimpum();

		moment = new Date(System.currentTimeMillis() - 1);

		final Calendar cal = Calendar.getInstance();
		cal.setTime(moment);
		cal.add(Calendar.MONTH, 2);
		startDate = cal.getTime();

		cal.add(Calendar.MONTH, 2);
		endDate = cal.getTime();

		result.setStartDate(startDate);
		result.setEndDate(endDate);
		result.setCreationMoment(moment);

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
	public void validate(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		final Calendar moment = Calendar.getInstance();
	

		final Date now = new Date(System.currentTimeMillis() - 1);
		moment.setTime(now);
		entity.setCreationMoment(moment.getTime());

		if (!errors.hasErrors("code")) {
			final Chimpum existing = this.repository.findOneChimpumByCode(entity.getCode());
			errors.state(request, existing == null, "code", "inventor.item.form.error.duplicated");
		}

		if (!errors.hasErrors("startDate")) {
			errors.state(request, entity.getStartDate().after(entity.getCreationMoment()), "startDate", "inventor.chimpum.form.error.past-start-date");
		}
		if (!errors.hasErrors("startDate")) {
			final Date oneMonthAfterCreationDate = DateUtils.addMonths(entity.getCreationMoment(), 1);
			errors.state(request, entity.getStartDate().equals(oneMonthAfterCreationDate) || entity.getStartDate().after(oneMonthAfterCreationDate), "startDate", "inventor.chimpum.form.error.too-close");
		}

		if (!errors.hasErrors("endDate")) {
			errors.state(request, entity.getEndDate().after(entity.getCreationMoment()), "endDate", "inventor.chimpum.form.error.past-end-date");
		}
		if (!errors.hasErrors("endDate")) {
			errors.state(request, entity.getEndDate().after(entity.getStartDate()), "endDate", "inventor.chimpum.form.error.end-date-previous-to-start-date");
		}
		if (!errors.hasErrors("endDate")) {
			final Date oneWeekAfterStartDate = DateUtils.addWeeks(entity.getStartDate(), 1);
			errors.state(request, entity.getEndDate().equals(oneWeekAfterStartDate) || entity.getEndDate().after(oneWeekAfterStartDate), "endDate", "inventor.chimpum.form.error.insufficient-duration");
		}

		if (!errors.hasErrors("budgedt")) {
			final Money budget = entity.getBudget();
			
			final boolean BUDGETPositive = budget.getAmount() > 0.;
			errors.state(request, BUDGETPositive, "budgedt", "inventor.chimpum.form.error.budget-positive");

		}

	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Item item;
		final int masterId;

		masterId = request.getModel().getInteger("masterId");
		item = this.repository.findOneItemById(masterId);

		request.unbind(entity, model, "title", "code", "description", "startDate", "endDate", "budget", "moreInfo");

		model.setAttribute("masterId", masterId);
		model.setAttribute("published", item.isPublished());
	}

	@Override
	public void create(final Request<Chimpum> request, final Chimpum entity) {
		assert request != null;
		assert entity != null;

		String finalCode;
		int masterId;
		Item item;

		masterId = request.getModel().getInteger("masterId");
		item = this.repository.findOneItemById(masterId);
		finalCode = this.generateCode(entity.getCode(), entity.getCreationMoment());
		entity.setCode(finalCode);

		this.repository.save(entity);
		item.setChimpum(entity);
		this.repository.save(item);
	}
	
	private String generateCode(final String code, final Date date) {
		String result = code;
		final Calendar moment = Calendar.getInstance();
		moment.setTime(date);

		String yy, mm, dd;

		yy = String.valueOf(moment.get(Calendar.YEAR)).substring(2);

		Integer mmnum = moment.get(Calendar.MONTH);
		mmnum += 1;
		if (mmnum < 10) {
			mm = "0" + mmnum.toString();
		}else {
			mm = mmnum.toString();}

		Integer ddnum;
		ddnum = moment.get(Calendar.DAY_OF_MONTH);
		if (ddnum < 10) {
			dd = "0" + ddnum.toString();
		}else {
			dd = ddnum.toString();}
		result += "-" + yy + "/" + mm + "/" + dd;
		return result;
	}

	
}


