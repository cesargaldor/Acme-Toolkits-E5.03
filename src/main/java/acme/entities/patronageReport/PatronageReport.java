
package acme.entities.patronageReport;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.patronage.Patronage;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PatronageReport extends AbstractEntity {
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	//status(enum)

	/*
	 * The system must store the following data about them: an automatic sequence number (not blank, matches pattern “〈patronage-code〉:〈serial-number〉”,
	 * where “〈patronage-code〉” denotes the code of corresponding patronage and “〈serial-number〉” denotes a sequential number that starts at “0001” and
	 * gets increased with every new patronage report), a creation moment (in the past), a memorandum (not blank, shorter than 256 characters),
	 * and an optional link with further information.
	 */
	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?:[0-9]{4}$")
	protected String			numSeq;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	protected Date				creationMoment;

	@NotBlank
	@Length(min = 1, max = 255)
	protected String			memorandum;

	@URL
	protected String			optionalLink;

	@OneToOne
	Patronage					patronage;

}
