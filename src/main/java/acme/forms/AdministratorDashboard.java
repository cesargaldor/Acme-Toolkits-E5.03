package acme.forms;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard {


		// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------
				//Las List<Double> significa una lista de calculos, average, deviation, minimun
		 		// and maximun retail price
		
		Integer					totalNumberOfComponents;
		Map<String,List<Double>>		AllComponentsStatsByCurrency;
		Map<String,List<Double>>		AllComponentsStatsByTechnology;
		Integer					totalNumberOfTools;
		Map<String,List<Double>>		AllToolsStatsPerCurrency;
		Map<String,Integer>			totalNumberOfPatronagesByStatus;
		Map<String,List<Double>>		AllPatronagesStatsByStatus;

		// Derived attributes -----------------------------------------------------

		// Relationships ----------------------------------------------------------

}
