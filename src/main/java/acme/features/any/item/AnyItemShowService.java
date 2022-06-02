package acme.features.any.item;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.components.CalculateMoneyExchange;
import acme.entities.items.Item;
import acme.entities.moneyExchangeCache.MoneyExchangeCache;
import acme.forms.MoneyExchange;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyItemShowService implements AbstractShowService<Any, Item>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected AnyItemRepository repository;
			
		@Override
		public boolean authorise(final Request<Item> request) {
			assert request != null;			
			boolean result;
			int id;
			Item item;

			id = request.getModel().getInteger("id");
			item = this.repository.findOneItemById(id);
			result = item.isPublished();

			return result;
		}

		@Override
		public Item findOne(final Request<Item> request) {
			assert request != null;

			Item result;
			int id;
			final Money converted;
			Money source;
			String targetCurrency;
			final MoneyExchange exchange;
			Calendar today;
			final Calendar exchangeDate = Calendar.getInstance();

			id = request.getModel().getInteger("id");
			result = this.repository.findOneItemById(id);

			source = result.getRetailPrice();
			targetCurrency = "EUR";
			today = Calendar.getInstance();
			exchangeDate.setTime(result.getExchangeDate());

			if (!(result.getRetailPrice().getCurrency().equals(targetCurrency))) {
				exchange = this.getConversion(source, targetCurrency);
				converted = exchange.getTarget();
				result.setExchangeDate(exchange.getDate());
				
			} else {
				converted = source;
				result.setExchangeDate(today.getTime());
			}
			result.setConvertedPrice(converted);
			this.repository.save(result);
			return result;

		}

		@Override
		public void unbind(final Request<Item> request, final Item entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;
			
			model.setAttribute("inventor", entity.getInventor().getUserAccount().getUsername());
			
			request.unbind(entity, model, "type", "name", "code", "technology", "description", "retailPrice", "optionalLink");
			
		}
		
		public MoneyExchange getConversion(final Money source, final String targetCurrency) {
			MoneyExchangeCache cache;
			MoneyExchange exchange;
			final Calendar date;

			date = Calendar.getInstance();

			final Optional<MoneyExchangeCache> opt = this.repository.findCacheBySourceAndTarget(source.getCurrency(), targetCurrency);
			if (opt.isPresent()) {
				cache = opt.get();
				if (Boolean.TRUE.equals(CalculateMoneyExchange.checkCache(cache)))
					exchange = CalculateMoneyExchange.calculateMoneyExchangeFromCache(source, targetCurrency, cache);
				else {
					exchange = CalculateMoneyExchange.computeMoneyExchange(source, targetCurrency);

					date.setTime(exchange.getDate());
					cache.setDate(date);
					cache.setRate(exchange.getRate());

					this.repository.save(cache);
				}
				return exchange;
			} else {
				exchange = CalculateMoneyExchange.computeMoneyExchange(source, targetCurrency);

				date.setTime(exchange.getDate());
				cache = new MoneyExchangeCache();
				cache.setDate(date);
				cache.setRate(exchange.getRate());
				cache.setSource(source.getCurrency());
				cache.setTarget(targetCurrency);

				this.repository.save(cache);

				return exchange;
			}
		}

}
