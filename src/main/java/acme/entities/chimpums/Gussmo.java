package acme.entities.chimpums;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.dom4j.tree.AbstractEntity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Gussmo extends AbstractEntity {
	
	private static final long serialVersionUID = 4827750132244297758L;
	
	

	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{2}(-[0-9]{2}[/][0][1-9]|[1][12][/][1-9]|[12][0-9]|3[01])$")
	protected String code;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	protected Date 				creationMoment;
	
	@NotBlank
	@Length(min=1,max = 100)
	protected String 			name;
	
	@NotBlank
	@Length(min=1,max=255)
	protected String 			explanation;
	
	
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
	protected Money 			ration;
	
	@URL
	protected String 			optionalLink;
	

}
