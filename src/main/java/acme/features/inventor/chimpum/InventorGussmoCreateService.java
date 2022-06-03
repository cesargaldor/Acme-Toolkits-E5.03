package acme.features.inventor.gussmo;


import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import acme.entities.chimpums.Gussmo;
import acme.entities.items.Item;
import acme.entities.items.Type;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorGussmoCreateService implements AbstractCreateService<Inventor, Gussmo> {

	@Autowired
	protected InventorGussmoRepository						repository;


	
	@Override
	public boolean authorise(final Request<Gussmo> request) {
		assert request != null;

		final Type type = Type.COMPONENT; 
		int id;
		Item item;
		Inventor inventor;

		id = request.getModel().getInteger("masterId");
		item = this.repository.findOneItemById(id);
		inventor = item.getInventor();

		return request.isPrincipal(inventor) && !item.isPublished() && item.getGussmo() == null && item.getType().equals(type);
	}


	@Override
	public Gussmo instantiate(final Request<Gussmo> request) {
		assert request != null;
		final Gussmo result;
		Date moment;
		Date startDate, endDate;

		result = new Gussmo();

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
	public void bind(final Request<Gussmo> request, final Gussmo entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "name", "code", "explanation", "startDate", "endDate", "ration", "optionalLink");

	}
	

	@Override
	public void validate(final Request<Gussmo> request, final Gussmo entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		final Calendar moment = Calendar.getInstance();
	

		final Date now = new Date(System.currentTimeMillis() - 1);
		moment.setTime(now);
		entity.setCreationMoment(moment.getTime());

		

	}

	@Override
	public void unbind(final Request<Gussmo> request, final Gussmo entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Item item;
		final int masterId;

		masterId = request.getModel().getInteger("masterId");
		item = this.repository.findOneItemById(masterId);

		request.unbind(entity, model, "name", "code", "explanation", "startDate", "endDate", "ration", "optionalLink");

		model.setAttribute("masterId", masterId);
		model.setAttribute("published", item.isPublished());
	}

	@Override
	public void create(final Request<Gussmo> request, final Gussmo entity) {
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
		item.setGussmo(entity);
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


