/*
 * Job.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.entities.jobs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import acme.roles.Employer;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Job extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Column(unique = true)
	@NotBlank
	@Length(min = 5, max = 15)
	protected String			reference;

	@NotBlank
	protected String			title;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				deadline;

	@NotNull
	@Valid
	protected Money				salary;

	@Range(min = 0, max = 100)
	@Digits(integer = 2, fraction = 2)
	protected double			score;

	@NotBlank
	protected String			description;

	@URL
	protected String			moreInfo;

	protected boolean			draftMode;

	// Derived attributes -----------------------------------------------------


	public boolean isAvailable() {
		boolean result;
		Date now;

		now = new Date();
		result = !this.draftMode && now.before(this.deadline);

		return result;
	}

	// Relationships ----------------------------------------------------------


	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Employer employer;

}
