
package acme.entities.patronage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import acme.roles.Inventor;
import acme.roles.Patron;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patronage extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	//status(enum)
	@NotNull
	protected Status			status;

	//code
	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	@Column(unique = true)
	protected String			code;

	//legal stuff
	@NotBlank
	@Length(min = 1, max = 255)
	protected String			legalStuff;

	//budget
	@NotNull
	//@Valid
	protected Money			budget;

	//period of time
	@Temporal(TemporalType.TIMESTAMP)
	@Future
	@NotNull
	protected Date				moment;

	//optional link
	@URL
	protected String			optionalLink;
	

	//Checks if a patronage is published or not
	protected boolean           isPublished;

	// Relationships ----------------------------------------------------------
	@NotNull
	@Valid
	@ManyToOne
	Patron						patron;
	
	@NotNull
	@Valid
	@ManyToOne
	Inventor					inventor;

	

}
