
package acme.entities.quantity;

import java.awt.Toolkit;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import acme.entities.items.Item;
import acme.framework.entities.AbstractEntity;

public class Quantity extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Min(1)
	protected int					number;
	
	// Relacion con items
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Item					item;

	// Relacion con toolkit
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Toolkit				toolkit;
}
