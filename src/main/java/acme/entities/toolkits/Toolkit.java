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
	
	//Serialisation identifier
	
	protected static final long serialVersionUID = 1L;
	
	//Attributes  
	
	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String 	code;
	
	@NotBlank
	@Length(max=100)
	protected String 	title;
	
	@NotBlank
	@Length(max=255)
	protected String 	description;
	
	@NotBlank
	@Length(max=255)
	protected String 	assemblyNote;
	
	@URL
	protected String	optionalLink;
	
	protected boolean   draft;
	
	@ManyToOne(optional = false)
    @Valid
    @NotNull
    protected Inventor inventor;
 
}

