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
		
		Map<Component,Integer>		totalNumberOfComponents;
		Map<Currency,List<Double>>		AllComponentsPerCurrency;
		Map<Technology,List<Double>>	AllComponentsPerTechnology;
		Map<Tool,Integer>			totalNumberOfTools;
		Map<Currency,List<Double>>		AllToolsPerCurrency;
		Map<Patronage,Integer>		totalNumberOfPatronages;
		Map<Patronage,List<Double>>		AllPatronagesPerProposedPatronage;

		// Derived attributes -----------------------------------------------------

		// Relationships ----------------------------------------------------------

}
