package acme.features.any.userAccount;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.framework.controllers.AbstractController;
import acme.framework.entities.UserAccount;
import acme.framework.roles.Any;

@Controller
@RequestMapping("/any/user-account/")
public class AnyUserAccountController extends AbstractController<Any, UserAccount> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyUserAccountListPatronService		listPatronService;
	
	@Autowired
	protected AnyUserAccountListInventorService		listInventorService;

	@Autowired
	protected AnyUserAccountShowService				showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list-patron", "list", this.listPatronService);
		super.addCommand("list-inventor", "list", this.listInventorService);
		super.addCommand("show", this.showService);
	}

}
