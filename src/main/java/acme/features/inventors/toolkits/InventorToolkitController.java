package acme.features.inventors.toolkits;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.AbstractController;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Inventor;

@Controller
public class InventorToolkitController extends AbstractController<Inventor, Toolkit>{
	
	//Internal state 
	
	@Autowired
	protected InventorToolkitListService	listService;
	
	@Autowired
	protected InventorToolkitShowService	showService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list-mine-toolkits","list", this.listService);
	}
	
}