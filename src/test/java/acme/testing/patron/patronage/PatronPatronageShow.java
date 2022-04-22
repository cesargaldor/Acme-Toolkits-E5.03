package acme.testing.patron.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageShow extends TestHarness {

	@ParameterizedTest	
	@CsvFileSource(resources = "/patron/patronage/show.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String status, final String code, final String legalStuff,
		final String budget, final String fullName, final String email, final String moment, final String optionalLink) {
		
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "List my patronages");
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("fullName", fullName);
		super.checkInputBoxHasValue("email", email);
		super.checkInputBoxHasValue("moment", moment);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		
		super.signOut();
	}
}