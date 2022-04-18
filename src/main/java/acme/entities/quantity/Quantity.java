package acme.entities.quantity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import acme.entities.items.Item;
import acme.entities.toolKits.ToolKit;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Quantity extends AbstractEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Min(1)
	protected int number;
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected Item item;
	

	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected ToolKit toolkit;
}