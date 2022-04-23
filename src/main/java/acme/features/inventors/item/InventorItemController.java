package acme.features.inventors.item;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.items.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;
@Controller
public class InventorItemController extends AbstractController<Inventor, Item>{

	//Internal state  -------------------------------------------------------------------
	@Autowired
	protected InventorItemListService listService;

	@Autowired
	protected InventorItemCreateService createService;
	
	@Autowired
	protected InventorItemShowService showService;
	

	
	//Constructors ----------------------------------------------------------------------
	
	@PostConstruct
	
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("create", this.createService);
		super.addCommand("show", this.showService);
		

		

	}
}
