
package acme.features.inventor.toolkit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.toolkits.Toolkit;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorToolkitController extends AbstractController<Inventor, Toolkit> {

	//Internal state 

	@Autowired
	protected InventorToolkitListMineService	listMineService;

	@Autowired
	protected InventorToolkitShowMineService	showMineService;

	@Autowired
	protected InventorToolkitCreateService		createService;

	@Autowired
	protected InventorToolkitUpdateService		updateService;

	@Autowired
	protected InventorToolkitDeleteService		deleteService;


	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listMineService);
		super.addCommand("show", this.showMineService);
		super.addCommand("create", this.createService);
		super.addCommand("update", this.updateService);
		super.addCommand("delete", this.deleteService);
	}

}
