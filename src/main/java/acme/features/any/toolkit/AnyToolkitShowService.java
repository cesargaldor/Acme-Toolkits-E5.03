package acme.features.any.toolkit;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.quantity.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyToolkitShowService implements AbstractShowService<Any, Toolkit>{

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyToolkitRepository repository;

	// AbstractShowService<Any, Toolkit> interface --------------------------

	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;

		boolean result;
		int id;
		Toolkit toolkit;

		id = request.getModel().getInteger("id");
		toolkit = this.repository.findOneToolkitById(id);
		result = !toolkit.isDraft();

		return result;
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "totalPrice", "optionalLink");
	}

	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request != null;

		Toolkit result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneToolkitById(id);
		final Money totalPrice = this.calculateTotalPrice(result);
		result.setTotalPrice(totalPrice);
		this.repository.save(result);

		return result;
	}
	
	private Money calculateTotalPrice(final Toolkit t) {
		final Money money = new Money();
		money.setCurrency("EUR"); //Default Currency
		Double sum=0.;
		final Collection<Quantity> quantities = this.repository.findItemQuantitiesOfToolkit(t.getId());
		for(final Quantity quantity: quantities) {
			sum+=quantity.getItem().getRetailPrice().getAmount()*quantity.getNumber();
		}
		money.setAmount(sum);
		return money;
	}
}
