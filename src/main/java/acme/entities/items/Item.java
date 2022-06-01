
package acme.entities.items;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import acme.roles.Inventor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Tipo de item
	@NotNull
	protected Type					type;

	//name
	@NotBlank
	@Length(min = 1, max = 100)
	protected String				name;

	//code
	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	@Column(unique = true)
	protected String				code;

	//technology
	@NotBlank
	@Length(min = 1, max = 100)
	protected String				technology;

	//description
	@NotBlank
	@Length(min = 1, max = 255)
	protected String				description;

	//retail price
	//@Valid
	@NotNull
	protected Money					retailPrice;
	
	protected Money convertedPrice;
	
	protected Date exchangeDate;

	//optional link
	@URL
	protected String				optionalLink;
	
	//published
	protected boolean published;

	//Relación con el inventor
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Inventor				inventor;
	
	public static Boolean positiveMoney(final Money m) {
		return m.getAmount()>=0;
	}

}
