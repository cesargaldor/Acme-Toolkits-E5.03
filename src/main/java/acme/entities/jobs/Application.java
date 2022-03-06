/*
 * Application.java
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.framework.entities.AbstractEntity;
import acme.roles.Worker;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Application extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Column(unique = true)
	protected String			reference;

	@Past
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				moment;

	@NotNull
	protected ApplicationStatus	status;

	@NotBlank
	protected String			statement;

	@NotBlank
	protected String			skills;

	@NotBlank
	protected String			qualifications;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Worker			worker;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Job				job;

}
