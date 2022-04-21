package acme.entities.toolkits;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import acme.roles.Inventor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Toolkit extends AbstractEntity {
	
	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------
		
		//code
		@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
		@Column(unique = true)
		protected String			code;
		
		//title
		@NotBlank
		@Length(min = 1, max = 100)
		protected String			title;

		//description
		@NotBlank
		@Length(min = 1, max = 255)
		protected String 			description;
		
		//assembly notes
		@NotBlank
		@Length(min = 1, max = 255)
		protected String 			assemblyNotes;
		
		//optional link
		@URL
		protected String			optionalLink;

		// Relationships ----------------------------------------------------------
		@NotNull
		@Valid
		@ManyToOne(optional=false)
		protected Inventor inventor;
}
