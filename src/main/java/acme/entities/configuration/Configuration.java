
package acme.entities.configuration;

import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Configuration extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}$")
	private String						sysCurrency;

	@NotBlank
	private String						allowedCurrencies;

	@NotBlank
	private String						strongSpam;

	@NotBlank
	private String						weakSpam;

	@Range(min = 0, max = 100)
	@Digits(integer = 3, fraction = 2)
	private double						strongThreshold;

	@Range(min = 0, max = 100)
	@Digits(integer = 3, fraction = 2)
	private double						weakThreshold;
}
