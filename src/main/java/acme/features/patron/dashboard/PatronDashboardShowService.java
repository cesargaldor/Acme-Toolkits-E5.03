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
	
			final int numberOfPropsedPatronages = this.repository.numberOfStatusPatronages("PROPOSED");
//			final int numberOfAcceptedPatronages = this.repository.numberOfStatusPatronages(Status.ACCEPTED);
//			final int numberOfDeniedPatronages =  this.repository.numberOfStatusPatronages(Status.DENIED);
//			
//			final Map<Pair<String,String>, Stats> statsRetailPriceOfComponents = new HashMap<>();
//			final List<Object[]> listStatsRetailPriceOfComponents = this.repository.statsRetailPriceOfItem(Type.COMPONENT);
//			
//			for (int i=0; i<listStatsRetailPriceOfComponents.size(); i++) {
//				final Object[] linea = listStatsRetailPriceOfComponents.get(i);
//				final Pair<String, String> pareja = Pair.of((String)(linea[0]), (String)(linea[1]));
//				final Stats stat = new Stats();
//				stat.setAverage((Double)(linea[2]));
//				stat.setDeviation((Double)(linea[3]));
//				stat.setMinumun((Double)(linea[4]));
//				stat.setMaximun((Double)(linea[5]));
//				
//				statsRetailPriceOfComponents.put(pareja, stat);
//			}
//			
//			final Map<Pair<String,String>, Stats> statsRetailPriceOfTools = new HashMap<>();
//			final List<Object[]> listStatsRetailPriceOfTools = this.repository.statsRetailPriceOfItem(Type.TOOL);
//			
//			for (int i=0; i<listStatsRetailPriceOfTools.size(); i++) {
//				final Object[] linea = listStatsRetailPriceOfTools.get(i);
//				final Pair<String, String> pareja = Pair.of((String)linea[0], (String)linea[1]);
//				final Stats stat = new Stats();
//				stat.setAverage((Double)(linea[2]));
//				stat.setDeviation((Double)(linea[3]));
//				stat.setMinumun((Double)(linea[4]));
//				stat.setMaximun((Double)(linea[5]));
//				
//				statsRetailPriceOfTools.put(pareja, stat);
//			}
//			final EnumMap<Status,Stats> statsBudgetOfStatusPatronages = new EnumMap<>(Status.class);
//			final List<Object[]> listStatsBudgetOfStatusPatronages = this.repository.statsBudgetOfStatusPatronages();
//			
//			for (int i=0; i<listStatsBudgetOfStatusPatronages.size(); i++) {
//				final Object[] arrayList = listStatsBudgetOfStatusPatronages.get(i);
//				final Stats stat = new Stats();
//				stat.setAverage((Double)(arrayList[1]));
//				stat.setDeviation((Double)(arrayList[2]));
//				stat.setMinumun((Double)(arrayList[3]));
//				stat.setMaximun((Double)(arrayList[4]));
//				
//				statsBudgetOfStatusPatronages.put((Status)arrayList[0], stat);
//			}
//			

//			result.setStatsRetailPriceOfComponents(statsRetailPriceOfComponents);
//			result.setStatsRetailPriceOfTools(statsRetailPriceOfTools);
//			
//			result.setNumberOfAcceptedPatronages(numberOfAcceptedPatronages);
			result.setNumberOfProposedPatronages(numberOfPropsedPatronages);
//			result.setNumberOfDeniedPatronages(numberOfDeniedPatronages);
//			result.setStatsBudgetOfStatusPatronages(statsBudgetOfStatusPatronages);
			
			return result;
		}
		@Override
		public void unbind (final Request<PatronDashboard> request, final PatronDashboard entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;
			
			request.unbind(entity, model, 	"numberOfProposedPatronages"/*, 
											"numberOfTools", 
											"statsRetailPriceOfComponents", 
											"statsRetailPriceOfTools", 
											"numberOfPropsedPatronages", 
											"numberOfAcceptedPatronages", 
											"numberOfDeniedPatronages", 
											"statsBudgetOfStatusPatronages"*/);
		}
}


