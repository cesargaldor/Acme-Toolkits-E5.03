package acme.features.inventor.patronageReport;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronageReport.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportListService implements AbstractListService<Inventor, PatronageReport>{

	@Autowired
	protected InventorPatronageReportRepository repository;
	 
	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;
		boolean res;
		res = request.getPrincipal().hasRole(Inventor.class);
		return res;
	}

	@Override
	public Collection<PatronageReport> findMany(final Request<PatronageReport> request) {
		assert request != null;
		
		Collection<PatronageReport> result;
		Principal principal;

		principal = request.getPrincipal();
        result = this.repository.findPatronagesReports(principal.getUsername());
		return result;
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		model.setAttribute("numSeq", entity.getNumSeq());
		request.unbind(entity, model, "numSeq","creationMoment", "memorandum","optionalLink");
		
	}

}
