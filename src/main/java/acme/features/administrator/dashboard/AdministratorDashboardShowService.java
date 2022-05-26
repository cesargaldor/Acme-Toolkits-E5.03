package acme.features.administrator.dashboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import acme.forms.AdministratorDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, AdministratorDashboard> {
	

	@Autowired
	protected AdministratorDashboardRepository repository;
	
	@Override
	public boolean authorise(final Request<AdministratorDashboard> request) {
		assert request != null;

		return true;
	}
	
	
	@Override
	public AdministratorDashboard findOne(final Request<AdministratorDashboard> request) {
		assert request != null;

		final int totalNumOfComponents = this.repository.totalNumOfComponents();
		
		final int totalNumOfTools = this.repository.totalNumOfTools();
		final int numberOfAcceptedPatronages = this.repository.numberOfAcceptedPatronages();
		final int numberOfDeniedPatronages = this.repository.numberOfDeniedPatronages();
		final int numberOfProposedPatronages = this.repository.numberOfProposedPatronages();
		final List<Object[]> minPriceOfComponents = this.repository.minPriceOfComponents();
		final List<Object[]> maxPriceOfComponents = this.repository.maxPriceOfComponents();
		final List<Object[]> averagePriceOfComponents = this.repository.averagePriceOfComponents();
		final List<Object[]> deviationPriceOfComponents = this.repository.deviationPriceOfComponents();
		final List<Object[]> minPriceOfTools = this.repository.minPriceOfTools();
		final List<Object[]> maxPriceOfTools = this.repository.maxPriceOfTools();
		final List<Object[]> averagePriceOfTools = this.repository.averagePriceOfTools();
		final List<Object[]> deviationPriceOfTools = this.repository.deviationPriceOfTools();
		final Double minPriceOfAcceptedPatronages = this.repository.minBudgetAcceptedPatronages();
		final Double maxPriceOfAcceptedPatronages = this.repository.maxBudgetAcceptedPatronages();
		final Double averagePriceOfAcceptedPatronages = this.repository.averageBudgetAcceptedPatronages();
		final Double deviationPriceOfAcceptedPatronages = this.repository.deviationBudgetAcceptedPatronages();
		final Double minPriceOfDeniedPatronages = this.repository.minBudgetDeniedPatronages();
		final Double maxPriceOfDeniedPatronages = this.repository.maxBudgetDeniedPatronages();
		final Double averagePriceOfDeniedPatronages = this.repository.averageBudgetDeniedPatronages();
		final Double deviationPriceOfDeniedPatronages = this.repository.deviationBudgetDeniedPatronages();
		final Double minPriceOfProposedPatronages = this.repository.minBudgetProposedPatronages();
		final Double maxPriceOfProposedPatronages = this.repository.maxBudgetProposedPatronages();
		final Double averagePriceOfProposedPatronages = this.repository.averageBudgetProposedPatronages();
		final Double deviationPriceOfProposedPatronages = this.repository.deviationBudgetProposedPatronages();
		
	
	
		final Map<String, List<Pair<Double,String>>> priceOfComponentsStats = new HashMap<>();
		
		
		priceOfComponentsStats.put("max", this.objectListToPairList(maxPriceOfComponents));
		priceOfComponentsStats.put("min", this.objectListToPairList(minPriceOfComponents));
		priceOfComponentsStats.put("average", this.objectListToPairList(averagePriceOfComponents));
		priceOfComponentsStats.put("deviation", this.objectListToPairList(deviationPriceOfComponents));
		
	
		final Map<String, List<Money>> priceOfToolsStats = new HashMap<>();

		
		priceOfToolsStats.put("max", this.objectListToMoneyList(maxPriceOfTools));
		priceOfToolsStats.put("min", this.objectListToMoneyList(minPriceOfTools));
		priceOfToolsStats.put("average", this.objectListToMoneyList(averagePriceOfTools));
		priceOfToolsStats.put("deviation", this.objectListToMoneyList(deviationPriceOfTools));
		
		
		final Map<String, Integer> numberOfPatronages = new HashMap<>();
		numberOfPatronages.put("accepted", numberOfAcceptedPatronages);
		numberOfPatronages.put("denied", numberOfDeniedPatronages);
		numberOfPatronages.put("proposed", numberOfProposedPatronages);
		
		
		final Map<String, Double> patronageStats = new HashMap<>();
		
		patronageStats.put("maxAccepted", maxPriceOfAcceptedPatronages);
		patronageStats.put("minAccepted", minPriceOfAcceptedPatronages);
		patronageStats.put("averageAccepted", averagePriceOfAcceptedPatronages);
		patronageStats.put("deviationAccepted", deviationPriceOfAcceptedPatronages);
		patronageStats.put("maxDenied", maxPriceOfDeniedPatronages);
		patronageStats.put("minDenied", minPriceOfDeniedPatronages);
		patronageStats.put("averageDenied", averagePriceOfDeniedPatronages);
		patronageStats.put("deviationDenied", deviationPriceOfDeniedPatronages);
		patronageStats.put("maxProposed", maxPriceOfProposedPatronages);
		patronageStats.put("minProposed", minPriceOfProposedPatronages);
		patronageStats.put("averageProposed", averagePriceOfProposedPatronages);
		patronageStats.put("deviationProposed", deviationPriceOfProposedPatronages);
		
		
		final AdministratorDashboard result = new AdministratorDashboard();

		result.setTotalNumComponents(totalNumOfComponents);
		result.setTotalNumTools(totalNumOfTools);
		result.setNumberOfPatronages(numberOfPatronages);
		result.setPriceOfComponentsStats(priceOfComponentsStats);
		result.setPriceOfToolsStats(priceOfToolsStats);
		result.setPatronagesStats(patronageStats);

		return result;
	}
	
	
	@Override
	public void unbind(final Request<AdministratorDashboard> request, final AdministratorDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalNumComponents", "totalNumTools");
		model.setAttribute("numberOfAcceptedPatronages", entity.getNumberOfPatronages().get("accepted"));
		model.setAttribute("numberOfDeniedPatronages", entity.getNumberOfPatronages().get("denied"));
		model.setAttribute("numberOfProposedPatronages", entity.getNumberOfPatronages().get("proposed"));
		model.setAttribute("maxPriceOfComponents", entity.getPriceOfComponentsStats().get("max"));
		model.setAttribute("minPriceOfComponents", entity.getPriceOfComponentsStats().get("min"));
		model.setAttribute("averagePriceOfComponents", entity.getPriceOfComponentsStats().get("average"));
		model.setAttribute("deviationPriceOfComponents", entity.getPriceOfComponentsStats().get("deviation"));
		model.setAttribute("maxPriceOfTools", entity.getPriceOfToolsStats().get("max"));
		model.setAttribute("minPriceOfTools", entity.getPriceOfToolsStats().get("min"));
		model.setAttribute("averagePriceOfTools", entity.getPriceOfToolsStats().get("average"));
		model.setAttribute("deviationPriceOfTools", entity.getPriceOfToolsStats().get("deviation"));
		model.setAttribute("maxAcceptedPatronages", entity.getPatronagesStats().get("maxAccepted"));
		model.setAttribute("minAcceptedPatronages", entity.getPatronagesStats().get("minAccepted"));
		model.setAttribute("averageAcceptedPatronages", entity.getPatronagesStats().get("averageAccepted"));
		model.setAttribute("deviationAcceptedPatronages", entity.getPatronagesStats().get("deviationAccepted"));
		model.setAttribute("maxDeniedPatronages", entity.getPatronagesStats().get("maxDenied"));
		model.setAttribute("minDeniedPatronages", entity.getPatronagesStats().get("minDenied"));
		model.setAttribute("averageDeniedPatronages", entity.getPatronagesStats().get("averageDenied"));
		model.setAttribute("deviationDeniedPatronages", entity.getPatronagesStats().get("deviationDenied"));
		model.setAttribute("maxProposedPatronages", entity.getPatronagesStats().get("maxProposed"));
		model.setAttribute("minProposedPatronages", entity.getPatronagesStats().get("minProposed"));
		model.setAttribute("averageProposedPatronages", entity.getPatronagesStats().get("averageProposed"));
		model.setAttribute("deviationProposedPatronages", entity.getPatronagesStats().get("deviationProposed"));
	}
	
	private List<Money> objectListToMoneyList(final List<Object[]> list) {
		final List<Money> res = new ArrayList<Money>();
		for (final Object[] object : list) {
			final Money money = new Money();
			money.setAmount((Double) object[0]);
			money.setCurrency((String) object[1]);
			res.add(money);
		}
		return res;
	}

	private List<Pair<Double,String>> objectListToPairList(final List<Object[]> list) {
		final List<Pair<Double,String>> res = new ArrayList<Pair<Double,String>>();
		for (final Object[] object : list) {
			String string;
			final Double value = (Double) object[0];
			string = ((String) object[1]);
			string += ", " + ((String) object[2]);
			
			res.add(Pair.of(value, string));
		}
		return res;
	}

}

