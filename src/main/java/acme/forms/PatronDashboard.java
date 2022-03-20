/*
 * Dashboard.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Dashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	Map<String,Integer>				numberOfPatronages;
	Map<String,List<Double>>			patronageStats:
	
	//-------------------Patron Dashboard--------------------------------------------------------------------
	
	//Double						numberOfProposedPatronages;
	//Double						numberOfAcceptedPatronages;
	//Double						numberOfDeniedPatronages;
	//Double						averageOfProposedPatronages;
	//Double						averageOfAcceptedPatronages;
	//Double						averageOfDeniedPatronages;
	//Double						deviationOfProposedPatronages;
	//Double						deviationOfAcceptedPatronages;
	//Double						deviationOfDeniedPatronages;
	//Double						minimunBudgetOfProposedPatronages;
	//Double						maximunBudgetOfProposedPatronages;
	//Double						minimunBudgetOfAcceptedPatronages;
	//Double						maximunBudgetOfAcceptedPatronages;
	//Double						minimunBudgetOfDeniedPatronages;
	//Double						maximunBudgetOfDeniedPatronages;


	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}