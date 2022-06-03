package acme.features.inventor.gussmo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.AbstractController;

import acme.roles.Inventor;

@Controller
public class InventorGussmoController extends AbstractController<Inventor, Chimpum> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorGussmoCreateService 		createService;
	@Autowired
	protected InventorGussmoListMineService	listMineService;
	@Autowired
	protected InventorGussmoShowMineService	showMineService;
	@Autowired
	protected InventorGussmoUpdateService 		updateService;
	@Autowired
	protected InventorGussmoDeleteService		deleteService;
	
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list","list",this.listMineService);
		super.addCommand("show","show",this.showMineService);
		super.addCommand("create","create",this.createService);
		super.addCommand("update",this.updateService);
		super.addCommand("delete",this.deleteService);
	}

}