/*
 * AnonymousComponentCreateService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.anonymous.component;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.components.Component;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousComponentsCreateService implements AbstractCreateService<Anonymous, Component> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnonymousComponentsRepository repository;

	// AbstractCreateService<Administrator, Component> interface --------------


	@Override
	public boolean authorise(final Request<Component> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Component> request, final Component entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "name", "code", "technology", "description", "retailPrice", "optionalLink");
	}

	@Override
	public void unbind(final Request<Component> request, final Component entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model,"name", "code", "technology", "description", "retailPrice", "optionalLink");
	}

	@Override
	public Component instantiate(final Request<Component> request) {
		assert request != null;

		Component result;
		Date moment;
		
		final Integer id = request.getPrincipal().getActiveRoleId();

		moment = new Date(System.currentTimeMillis() - 1);

		result = new Component();
		result.setName("Juan Carajito");
		result.setCode("ABC-123-A");
		result.setTechnology("Tecnología barata");
		result.setDescription("testestestestestestestestest");
		result.setRetailPrice(123.0);
		result.setOptionalLink("https://youtube.com");

		return result;
	}

	@Override
	public void validate(final Request<Component> request, final Component entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Component> request, final Component entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);
	}

}
