
package acme.features.administrator.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.configuration.Configuration;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Administrator;

@Controller
@RequestMapping("/administrator/configuration/")
public class AdministratorConfigurationController extends AbstractController<Administrator, Configuration> {

	// Internal state ---------------------------------------------------------

//	@Autowired
//	protected AdministratorConfigurationListService	listService;
//	
//	@Autowired
//	private AdministratorConfigurationShowService showService;

	// Constructors -----------------------------------------------------------


//	@PostConstruct
//	private void initialise() {
//		super.addCommand("list", this.listService);
//		//super.addCommand("show", this.showService);
//	}

}
