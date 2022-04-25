package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.patronage.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard implements Serializable {
	// Serialisation identifier -----------------------------------------------

    protected static final long    serialVersionUID    = 1L;

 // Attributes 
	
	int										numberOfComponents;
	int										numberOfTools;
	
	// <Technology,Currency>
	Map<Pair<String,String>, Stats>         statsRetailPriceOfComponents;
	Map<Pair<String,String>, Stats>         statsRetailPriceOfTools;
	
	// Patronages
	
	int										numberOfPropsedPatronages;
	int										numberOfAcceptedPatronages;
	int										numberOfDeniedPatronages;
	
	Map<Status,Stats>						statsBudgetOfStatusPatronages;
}
