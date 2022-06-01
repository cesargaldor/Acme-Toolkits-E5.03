package acme.components;

import java.util.Calendar;

import org.springframework.web.client.RestTemplate;

import acme.entities.moneyExchangeCache.MoneyExchangeCache;
import acme.forms.MoneyExchange;
import acme.framework.datatypes.Money;
import acme.framework.helpers.StringHelper;

public class CalculateMoneyExchange {

	private CalculateMoneyExchange() {
	    throw new IllegalStateException("Utility class");
	  }
	
	public static Boolean checkCache(final MoneyExchangeCache cache) {
		final Boolean result;
		Calendar date;

		date = Calendar.getInstance();
		if (date.get(Calendar.DATE) == cache.getDate().get(Calendar.DATE) && date.get(Calendar.MONTH) == cache.getDate().get(Calendar.MONTH) && date.get(Calendar.YEAR) == cache.getDate().get(Calendar.YEAR)) {
			result = true;
		} else
			result = false;
		return result;
	}
	
	public static MoneyExchange computeMoneyExchange(final Money source, final String targetCurrency) {
		
		assert source != null;
		assert !StringHelper.isBlank(targetCurrency);
		
		MoneyExchange result;
		RestTemplate api;
		ExchangeRate record;
		String sourceCurrency;
		Double sourceAmount, targetAmount, rate;
		Money target;
		 
		final Calendar date = Calendar.getInstance();
		 
		try {
			 
			 api = new RestTemplate();
			 sourceCurrency = source.getCurrency();
			 sourceAmount = source.getAmount();
			 
			 record = api.getForObject( //
					"https://api.exchangerate.host/latest?base={0}&symbols={1}", //
					ExchangeRate.class, //
					sourceCurrency, //
					targetCurrency //
			);
			 
			assert record != null;
			rate = record.getRates().get(targetCurrency);
			targetAmount = rate * sourceAmount;
			
			target = new Money();
			target.setAmount(targetAmount);
			target.setCurrency(targetCurrency);

			date.setTime(record.getDate());

			result = new MoneyExchange();
			result.setSource(source);
			result.setTargetCurrency(targetCurrency);
			result.setDate(record.getDate());
			result.setTarget(target);
			result.setRate(rate);
			
			 
		 }catch(final Throwable mamaso) {
			 result = null;
			 
		 }
		 return result;	 
	}
	
	public static MoneyExchange calculateMoneyExchangeFromCache(final Money source, final String targetCurrency, final MoneyExchangeCache cache) {
		assert source != null;
		assert !StringHelper.isBlank(targetCurrency);

		MoneyExchange result;
		Double sourceAmount, targetAmount, rate;
		Money target;

		sourceAmount = source.getAmount();

		assert cache != null;
		rate = cache.getRate();
		targetAmount = rate * sourceAmount;

		target = new Money();
		target.setAmount(targetAmount);
		target.setCurrency(targetCurrency);

		
		result = new MoneyExchange();
		result.setSource(source);
		result.setTargetCurrency(targetCurrency);
		result.setDate(cache.getDate().getTime());
		result.setTarget(target);
		result.setRate(rate);

		return result;

	}
	

}
