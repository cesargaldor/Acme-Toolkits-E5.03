package acme.features.patron.patronage;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.patronage.Patronage;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Anonymous;

@Controller
@RequestMapping("/anonymous/patronage/")
public class PatronPatronageController extends AbstractController<Anonymous, Patronage>{
	
	//Internal state  -------------------------------------------------------------------
	@Autowired
	protected PatronPatronageListService listService;

	@Autowired
	protected PatronPatronageCreateService createService;
	
	//Constructors ----------------------------------------------------------------------
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("create", this.createService);

	}
}
