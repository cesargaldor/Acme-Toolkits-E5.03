package acme.forms;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AdministratorDashboard implements Serializable {
	// Serialisation identifier -----------------------------------------------

			protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
			//Las List<Double> significa una lista de calculos, average, deviation, minimun y maximun retail price
			
			private	Integer							totalNumberOfComponents;
			private Map<String,List<Double>>		allComponentsStatsByCurrency;
			private Map<String,List<Double>>		allComponentsStatsByTechnology;
			private Integer							totalNumberOfTools;
			private Map<String,List<Double>>		allToolsStatsPerCurrency;
			private Map<String,Integer>				totalNumberOfPatronagesByStatus;
			private Map<String,List<Double>>		allPatronagesStatsByStatus;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
