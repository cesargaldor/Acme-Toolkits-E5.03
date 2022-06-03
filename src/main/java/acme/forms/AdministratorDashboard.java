package acme.forms;

import java.util.List;
import java.util.Map;

import org.springframework.data.util.Pair;

import acme.framework.datatypes.Money;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard {
	// Serialisation identifier -----------------------------------------------

    protected static final long    serialVersionUID    = 1L;

 // Attributes 
    
    Integer								totalNumComponents;
	Integer								totalNumTools;
	Map<String,Integer>					numberOfPatronages;
	
	Map<String,List<Pair<Double,String>>>			priceOfComponentsStats;
	Map<String,List<Money>>				priceOfToolsStats;
	Map<String,Double>					patronagesStats;
	
//Control CHECK
	Double 						ratioOfChimpums;
	Map<String,List<Money>>			chimpumStats;
}
