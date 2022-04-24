package acme.features.inventors.toolkits;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.toolkits.Toolkit;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorToolkitController extends AbstractController<Inventor, Toolkit>{
	
	//Internal state 
	
	@Autowired
	protected InventorToolkitListService	listMineService;
	
	@Autowired
	protected InventorToolkitShowService	showMineService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showMineService);
		super.addCommand("list-mine-toolkits","list", this.listMineService);
	}
	
}