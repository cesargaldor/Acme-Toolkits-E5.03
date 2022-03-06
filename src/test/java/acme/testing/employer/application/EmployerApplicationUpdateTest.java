/*
 * EmployerApplicationUpdateTest.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.employer.application;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class EmployerApplicationUpdateTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/employer/application/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String reference, final String moment, final String title, final String statement, final String skills, final String qualifications, final String status) {
		super.signIn("employer1", "employer1");

		super.clickOnMenu("Employer", "List my applications");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.checkColumnHasValue(recordIndex, 0, reference);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();		
		super.fillInputBoxIn("status", status);
		super.clickOnSubmit("Update");

		super.clickOnMenu("Employer", "List my applications");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, reference);
		super.checkColumnHasValue(recordIndex, 1, status);
		super.checkColumnHasValue(recordIndex, 2, title);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("reference", reference);
		super.checkInputBoxHasValue("moment", moment);
		super.checkInputBoxHasValue("statement", statement);
		super.checkInputBoxHasValue("skills", skills);
		super.checkInputBoxHasValue("qualifications", qualifications);
		super.checkInputBoxHasValue("status", status);

		super.signOut();
	}

	// Ancillary methods ------------------------------------------------------

}
