package acme.forms;

import javax.persistence.Embeddable;

import acme.framework.datatypes.AbstractDatatype;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Stats extends AbstractDatatype{

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	
	protected Double average;
	
	protected Double deviation;
	
	protected Double minumun;
	
	protected Double maximun;
}
