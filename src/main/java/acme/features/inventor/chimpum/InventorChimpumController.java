package acme.features.inventor.chimpum;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.chimpums.Chimpum;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorChimpumController extends AbstractController<Inventor, Chimpum> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorChimpumListMineService	listMineService;

	@Autowired
	protected InventorChimpumShowMineService	showMineService;
	
	@Autowired
	protected InventorChimpumUpdateService 		updateService;

	@Autowired
	protected InventorChimpumCreateService 		createService;
	
	@Autowired
	protected InventorChimpumDeleteService		deleteService;
	
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list","list",this.listMineService);
		super.addCommand("show","show",this.showMineService);
		super.addCommand("create","create",this.createService);
		super.addCommand("update",this.updateService);
		super.addCommand("delete",this.deleteService);
	}

}