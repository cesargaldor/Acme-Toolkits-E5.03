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

package acme.features.anonymous.toolkit;

//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import acme.entities.toolKits.ToolKit;
//import acme.framework.components.models.Model;
//import acme.framework.controllers.Request;
//import acme.framework.roles.Anonymous;
//import acme.framework.services.AbstractListService;
//
//@Service
//public class AnonymousToolkitListService implements AbstractListService<Anonymous, ToolKit> {
//
//	@Autowired
//	protected AnonymousToolkitRepository repository;
//
//
//	@Override
//	public boolean authorise(final Request<ToolKit> request) {
//		assert request != null;
//
//		return true;
//	}
//
//	@Override
//	public void unbind(final Request<ToolKit> request, final ToolKit entity, final Model model) {
//		assert request != null;
//		assert entity != null;
//		assert model != null;
//
//		request.unbind(entity, model, "name", "code", "technology", "description", "retailPrice", "optionalLink");
//	}
//
//	@Override
//	public Collection<ToolKit> findMany(final Request<ToolKit> request) {
//		assert request != null;
//
//		Collection<ToolKit> result;
//
//		result = this.repository.findMany();
//
//		return result;
//	}
//
//}
