package acme.entities.patronage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patronage extends AbstractEntity{
	
	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------

		//status(enum)
		@NotNull
		protected Status status;
		
		
		//code
		@Pattern(regexp="^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
		@Column(unique=true)
		protected String code;
		
		
		
		//legal stuff
		@NotBlank
		@Length(min = 1, max = 256)
		protected String legalStuff;
		
		
		//budget
		@NotNull
		@Range(min=1, max=100000000)
		protected Double budget;
		
		
		
		//period of time
		@Temporal(TemporalType.TIMESTAMP)
		@Past
		@NotNull
		protected Date moment;
		
		
		
		//optional link
		protected String optionalLink;

}
