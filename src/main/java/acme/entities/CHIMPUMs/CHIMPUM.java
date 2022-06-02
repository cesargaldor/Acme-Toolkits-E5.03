package acme.entities.CHIMPUMs;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CHIMPUM extends AbstractEntity {
	
	private static final long serialVersionUID = 4827750132244297758L;
	
	//Attributes-------------------------------------------
	
	//@Column(unique = true)
	//@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String CODE;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	protected Date 				CREATION_MOMENT;
	
	@NotBlank
	@Length(min=1,max = 100)
	protected String 			TITLE;
	
	@NotBlank
	@Length(min=1,max=255)
	protected String 			DESCRIPTION;
	
	
	//-----------------PERIOD---------------------
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date 				startDate;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date 				endDate;
	//--------------------------------------------------------
	@NotNull
	@Valid
	protected Money 			BUDGET;
	
	@URL
	protected String 			LINK;
	

}
