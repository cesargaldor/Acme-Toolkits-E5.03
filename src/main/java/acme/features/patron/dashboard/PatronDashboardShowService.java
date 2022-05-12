package acme.features.patron.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.PatronDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronDashboardShowService implements AbstractShowService<Patron, PatronDashboard> {
	
	//Internal State
	
		@Autowired
		protected PatronDashboardRepository repository;


		@Override
		public boolean authorise(final Request<PatronDashboard> request) {
			//Comprobamos que solo puede acceder el rol Patron
			assert request != null;
			boolean result;
			result = request.getPrincipal().hasRole(Patron.class);
			return result;
		}
		
		@Override
		public PatronDashboard findOne(final Request<PatronDashboard> request) {
			assert request != null;
			final PatronDashboard result = new PatronDashboard();
	
			final int numberOfProposedPatronages = this.repository.numberOfStatusPatronages("PROPOSED");
			final int numberOfAcceptedPatronages = this.repository.numberOfStatusPatronages("ACCEPTED");
			final int numberOfDeniedPatronages =  this.repository.numberOfStatusPatronages("DENIED");
			
			result.setNumberOfProposedPatronages(numberOfProposedPatronages);
			result.setNumberOfAcceptedPatronages(numberOfAcceptedPatronages);
			result.setNumberOfDeniedPatronages(numberOfDeniedPatronages);
			
//			final Map<Pair<Status,String>, Stats> statsBudgetOfStatusPatronages = new HashMap<>();
//			final List<Object[]> listStatsBudgetOfStatusPatronages = this.repository.statsBudgetOfStatusPatronages();
//			
//			for (int i=0; i<listStatsBudgetOfStatusPatronages.size(); i++) {
//				final Object[] line = listStatsBudgetOfStatusPatronages.get(i);
//				final Pair<Status, String> pareja = Pair.of((Status)(line[0]), (String)(line[1]));
//				final Stats stat = new Stats();
//				stat.setAverage((Double)(line[2]));
//				stat.setDeviation((Double)(line[3]));
//				stat.setMinumun((Double)(line[4]));
//				stat.setMaximun((Double)(line[5]));
//				
//				statsBudgetOfStatusPatronages.put(pareja, stat);
//			}
			
//			result.setStatsBudgetOfStatusPatronages(statsBudgetOfStatusPatronages);
			
			return result;
		}
		@Override
		public void unbind (final Request<PatronDashboard> request, final PatronDashboard entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;
			
			request.unbind(entity, model, 	"numberOfProposedPatronages", 
											"numerOfAcceptedPatronages",
											"numberOfDeniedPatronages"/*,
											"statsBudgetOfStatusPatronages"*/);
		}
}


