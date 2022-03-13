package acme.features.anonymous.patronage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.patronage.Patronage;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Anonymous;

@Controller
@RequestMapping("/anonymous/patronage/")
public class AnonymousPatronageController extends AbstractController<Anonymous, Patronage>{
	
//	//Internal state  -------------------------------------------------------------------
//	@Autowired
//	protected AnonymousPatronageListService		listService;
//
//	@Autowired
//	protected AnonymousPatronageCreateService	createService;
//	
//	//Constructors ----------------------------------------------------------------------
//	
//	@PostConstruct
//	protected void initialise() {
//		super.addCommand("list", this.listService);
//		super.addCommand("create", this.createService);
//
//	}
}
