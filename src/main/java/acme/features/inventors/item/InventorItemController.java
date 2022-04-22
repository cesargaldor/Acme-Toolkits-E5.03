package acme.features.inventors.item;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.AbstractController;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Inventor;
@Controller
@RequestMapping("/inventor/item/")


public class InventorsItemController extends AbstractController<Inventor, Item>{

	//Internal state  -------------------------------------------------------------------
	@Autowired
	protected InventorItemListService listService;

	@Autowired
	protected InventorItemCreateService createService;
	
	@Autowired
	protected InventorItemShowService showService;
	
	@Autowired
	protected ToolkitItemListService        toolkitItemListService;

	
	//Constructors ----------------------------------------------------------------------
	
	@PostConstruct
	
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("create", this.createService);
		super.addCommand("show", this.showService);
		super.addCommand("list-toolkit", "list", this.toolkitItemListService);

		

	}
}
