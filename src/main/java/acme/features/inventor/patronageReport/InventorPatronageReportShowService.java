package acme.features.inventor.patronageReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronageReport.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportShowService implements AbstractShowService<Inventor, PatronageReport>{

	
	@Autowired
	protected InventorPatronageReportRepository repository;
	
	
	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;
		Boolean res;
		res = request.getPrincipal().hasRole(Inventor.class);
		return res;
	}

	@Override
	public PatronageReport findOne(final Request<PatronageReport> request) {
	assert request != null;
		
		PatronageReport result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOnePatronageReport(id);
		
		return result;
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "numSeq","creationMoment","memorandum","optionalLink");	
	
		model.setAttribute("readonly", true);
	}

}
