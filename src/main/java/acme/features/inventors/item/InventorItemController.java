package acme.features.inventors.item;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.items.Item;
import acme.features.inventors.toolkits.ToolkitItemListService;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemController extends AbstractController<Inventor, Item>{

	//Internal state  -------------------------------------------------------------------
	@Autowired
	protected InventorItemListService listService;
	
	@Autowired
	protected InventorItemShowService showService;
	
	//Esto es para mostrar los items asociados a toolkits del inventor
	@Autowired
	protected ToolkitItemListService	toolkitItemListService;

	
	//Constructors ----------------------------------------------------------------------
	
	@PostConstruct
	
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
		super.addCommand("list-toolkit", "list", this.toolkitItemListService);


		

	}
}
