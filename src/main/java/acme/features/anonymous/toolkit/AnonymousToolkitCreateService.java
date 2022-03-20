/*
 * AnonymousToolKitCreateService.java
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

//@Service
//public class AnonymousToolkitCreateService implements AbstractCreateService<Anonymous, ToolKit> {
//
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
//	public void bind(final Request<ToolKit> request, final ToolKit entity, final Errors errors) {
//		assert request != null;
//		assert entity != null;
//		assert errors != null;
//
//		request.bind(entity, errors, "name", "code", "technology", "description", "retailPrice", "optionalLink");
//	}
//
//	@Override
//	public void unbind(final Request<ToolKit> request, final ToolKit entity, final Model model) {
//		assert request != null;
//		assert entity != null;
//		assert model != null;
//
//		request.unbind(entity, model,"name", "code", "technology", "description", "retailPrice", "optionalLink");
//	}
//
//	@Override
//	public ToolKit instantiate(final Request<ToolKit> request) {
//		assert request != null;
//
//		ToolKit result;
//
//		result = new ToolKit();
//
//		return result;
//	}
//
//	@Override
//	public void validate(final Request<ToolKit> request, final ToolKit entity, final Errors errors) {
//		assert request != null;
//		assert entity != null;
//		assert errors != null;
//
//	}
//
//	@Override
//	public void create(final Request<ToolKit> request, final ToolKit entity) {
//		assert request != null;
//		assert entity != null;
//		
//		this.repository.save(entity);
//	}
//}
