package acme.features.inventors.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
@RequestMapping("/inventors/components/")

public class InventorsComponentsController extends AbstractController<Inventor,Components>{

	//Internal state  -------------------------------------------------------------------
	@Autowired
	protected InventorsComponentsListService listService;

	@Autowired
	protected InventorsComponentsCreateService createService;
	
	@Autowired
	protected InventorsComponentsShowService showService;
	
	//Constructors ----------------------------------------------------------------------
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("create", this.createService);
		super.addCommand("show", this.showService);

	}
}
