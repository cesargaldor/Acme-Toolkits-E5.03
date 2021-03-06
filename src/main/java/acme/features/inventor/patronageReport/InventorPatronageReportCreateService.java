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
		final boolean res;
		res = request.getPrincipal().hasRole(Inventor.class);
		return res;
	}

	@Override
	public void bind(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
        request.bind(entity, errors, "numSeq","creationMoment","memorandum", "optionalLink");	
	    
        final Integer id = Integer.parseInt(request.getModel().getAttribute("id").toString());
        final Patronage patronage = this.repository.findPatronageById(id);
        final String link = entity.getOptionalLink();
	    final String numSeq = entity.getNumSeq();
	    final Date moment = entity.getCreationMoment();
	    entity.setPatronage(patronage);
	    entity.setCreationMoment(moment);
	    entity.setNumSeq(numSeq);
	    entity.setOptionalLink(link);
		
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;		
		request.unbind(entity, model, "numSeq","creationMoment","memorandum","optionalLink");
		
	}

	@Override
	public PatronageReport instantiate(final Request<PatronageReport> request) {
		assert request != null;
		PatronageReport res;
		res = new PatronageReport();
		Date moment;
		moment = new Date(System.currentTimeMillis());
		res.setCreationMoment(moment);	
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
