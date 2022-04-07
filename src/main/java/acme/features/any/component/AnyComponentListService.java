/*
 * AnonymousComponentListService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.any.component;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.components.Component;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyComponentListService implements AbstractListService<Any, Component> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyComponentRepository repository;

	// AbstractListService<Any, Component> interface --------------


	@Override
	public boolean authorise(final Request<Component> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Component> request, final Component entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "code", "technology", "description", "retailPrice", "optionalLink", "component.inventor");
	}

	@Override
	public Collection<Component> findMany(final Request<Component> request) {
		assert request != null;

		Collection<Component> result;

		result = this.repository.findMany();

		return result;
	}

}
