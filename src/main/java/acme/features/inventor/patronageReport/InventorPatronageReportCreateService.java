package acme.features.inventor.patronageReport;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.entities.patronageReport.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportCreateService implements AbstractCreateService<Inventor, PatronageReport>{

	@Autowired
	protected InventorPatronageReportRepository repository;
	
	
	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;
		boolean res;
		final Integer id;
		final Patronage patronage;
		id = request.getModel().getInteger("id");
		patronage = this.repository.findPatronageById(id);
		res = request.getPrincipal().getActiveRoleId() == patronage.getInventor().getId();
		return res;
	}

	@Override
	public void bind(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "numSeq","creationMoment","memorandum","optionalLink");
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;		
		request.unbind(entity, model, "numSeq","creationMoment","memorandum","optionalLink");
		model.setAttribute("id", request.getModel().getAttribute("id"));
		model.setAttribute("numSeq", entity.getNumSeq());
	}

	@Override
	public PatronageReport instantiate(final Request<PatronageReport> request) {

		assert request != null;
		final PatronageReport res;
		final Patronage patronage;
		final Integer id;
		final Date creationMoment;
		final String numPatronageReports;
		id= request.getModel().getInteger("id");
		patronage = this.repository.findPatronageById(id);
		creationMoment = new Date(System.currentTimeMillis());
		//Sacamos patronage reports por id de patronage
		numPatronageReports = Integer.toString(this.repository.findPatronageReportsByPatronageId(id).size()+1);
		res = new PatronageReport();
		res.setPatronage(patronage);
		res.setCreationMoment(creationMoment);
		res.setNumSeq("ABC-123-A:000" + numPatronageReports);
		return res;
	}

	@Override
	public void validate(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;		
	}

	@Override
	public void create(final Request<PatronageReport> request, final PatronageReport entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);
	}

}
