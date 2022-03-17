package acme.entities.toolKits;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.entities.tools.Tool;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class ToolKit {
	
	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------
		
		//code
		@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
		@Column(unique = true)
		protected String			code;
		
		//title
		@NotBlank
		@Length(min = 1, max = 101)
		protected String			title;

		//description
		@NotBlank
		@Length(min = 1, max = 256)
		protected String description;
		
		//assembly notes
		@NotBlank
		@Length(min = 1, max = 256)
		protected String assemblyNotes;
		
		//optional link
		protected String			optionalLink;

		// Relationships ----------------------------------------------------------

		//1 toolKit solo puede tener una instancia de una tool dada
		@OneToOne
		Tool tool;
}
