package acme.entities.tools;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.entities.components.Component;
import acme.entities.toolKits.ToolKit;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Tool extends AbstractEntity{
	
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	
	//name
	@NotBlank
	@Length(min = 1, max = 101)
	protected String			name;

	//code
	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	@Column(unique = true)
	protected String			code;
	
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
	@Range(min = 0, max = 100000000)
	protected Double			retailPrice;

	//optional link
	@URL
	protected String			optionalLink;

	// Relationships ----------------------------------------------------------
	
	@OneToMany
	Component component;
	
	@ManyToOne
	ToolKit toolKit;

}
