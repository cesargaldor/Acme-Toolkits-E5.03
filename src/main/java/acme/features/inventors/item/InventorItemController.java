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
	protected InventorItemListMineService listMineService;
	
	@Autowired
	protected InventorItemShowMineService showMineService;

	@Autowired
	protected InventorItemUpdateService updateService;
	
	
	@Autowired
	protected InventorItemCreateService createService;
	
	@Autowired
	protected InventorItemDeleteService	deleteService;

	
	//Constructors ----------------------------------------------------------------------
	
	@PostConstruct
	
	protected void initialise() {
		super.addCommand("list", this.listMineService);
		super.addCommand("show", this.showMineService);
		super.addCommand("create",this.createService);
		super.addCommand("update",this.updateService);
		super.addCommand("delete",this.deleteService);


	}
}
