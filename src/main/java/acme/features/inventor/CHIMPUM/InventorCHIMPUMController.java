package acme.features.inventor.CHIMPUM;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.CHIMPUMs.CHIMPUM;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorCHIMPUMController extends AbstractController<Inventor, CHIMPUM> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorCHIMPUMListMineService	listMineService;

	@Autowired
	protected InventorCHIMPUMShowMineService	showMineService;
	
	@Autowired
	protected InventorCHIMPUMUpdateService 		updateService;

	@Autowired
	protected InventorCHIMPUMCreateService 		createService;
	
	@Autowired
	protected InventorCHIMPUMDeleteService		deleteService;
	
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list","list",this.listMineService);
		super.addCommand("show","show",this.showMineService);
		super.addCommand("create","create",this.createService);
		super.addCommand("update",this.updateService);
		super.addCommand("delete",this.deleteService);
	}

}