package acme.entities.components;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Component extends AbstractEntity{
	
	// Serialisation identifier -----------------------------------------------

			protected static final long	serialVersionUID	= 1L;

			// Attributes -------------------------------------------------------------

			
			//name
			@NotBlank
			@Length(min = 1, max = 101)
			protected String name;
			
			//code
			@Pattern(regexp="^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
			@Column(unique=true)
			protected String code;
			
			//technology
			@NotBlank
			@Length(min = 1, max = 101)
			protected String technology;
			
			//description
			@NotBlank
			@Length(min = 1, max = 256)
			protected String description;
			
			//retail price
			@NotNull
			@Range(min=1, max=100000000)
			protected Double retailPrice;

			//optional link
			protected String optionalLink;
			
			
			// Relationships ----------------------------------------------------------
		    
			
	

}
