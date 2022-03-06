/*
 * EmployerDutyCreateTest.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.employer.duty;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class EmployerDutyCreateTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/employer/duty/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int jobRecordIndex, final int dutyRecordIndex, final String title, final String description, final String workLoad, final String moreInfo) {
		super.signIn("employer1", "employer1");

		super.clickOnMenu("Employer", "List my jobs");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.clickOnListingRecord(jobRecordIndex);
		super.clickOnButton("Duties");
		
		super.clickOnButton("Create");
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("workLoad", workLoad);
		super.fillInputBoxIn("moreInfo", moreInfo);
		super.clickOnSubmit("Create");

		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(dutyRecordIndex, 0, title);
		super.checkColumnHasValue(dutyRecordIndex, 1, workLoad);

		super.clickOnListingRecord(dutyRecordIndex);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("workLoad", workLoad);
		super.checkInputBoxHasValue("moreInfo", moreInfo);

		super.signOut();
	}
	
	// Ancillary methods ------------------------------------------------------

}
