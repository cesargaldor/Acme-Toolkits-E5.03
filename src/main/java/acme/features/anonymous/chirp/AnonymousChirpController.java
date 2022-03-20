package acme.features.anonymous.chirp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.chirps.Chirp;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Anonymous;

@Controller
@RequestMapping("/anonymous/chirp/")
public class AnonymousChirpController extends AbstractController<Anonymous, Chirp> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnonymousChirpListService		listService;

	@Autowired
	protected AnonymousChirpCreateService	createService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("create", this.createService);
	}

}
