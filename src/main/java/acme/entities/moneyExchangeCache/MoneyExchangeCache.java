package acme.entities.moneyExchangeCache;

import java.util.Calendar;

import javax.persistence.Entity;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MoneyExchangeCache extends AbstractEntity{

private static final long serialVersionUID = 7262772812619557192L;
	
	// Attributes
	
	public Double				rate;
	public String				source;
	public String				target;
	public Calendar				date;
}
