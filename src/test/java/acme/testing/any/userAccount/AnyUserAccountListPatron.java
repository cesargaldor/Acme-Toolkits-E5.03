package acme.testing.any.userAccount;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyUserAccountListPatron extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/any/user-account/list-patron.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listPatron(final int recordIndex, final String username, final String identityName, final String identitySurname, 
		final String identityEmail, final String role) {
		
		super.clickOnMenu("Any", "List patrons");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, username);
		super.checkColumnHasValue(recordIndex, 1, identityName);
		super.checkColumnHasValue(recordIndex, 2, identitySurname);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("username", username);
		super.checkInputBoxHasValue("identity.name", identityName);
		super.checkInputBoxHasValue("identity.surname", identitySurname);
		super.checkInputBoxHasValue("identity.email", identityEmail);
		super.checkInputBoxHasValue("roles", role);
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/user-account/list-patron.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listPatronAuthenticated(final int recordIndex, final String username, final String identityName, final String identitySurname, 
		final String identityEmail, final String role) {
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Any", "List patrons");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, username);
		super.checkColumnHasValue(recordIndex, 1, identityName);
		super.checkColumnHasValue(recordIndex, 2, identitySurname);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("username", username);
		super.checkInputBoxHasValue("identity.name", identityName);
		super.checkInputBoxHasValue("identity.surname", identitySurname);
		super.checkInputBoxHasValue("identity.email", identityEmail);
		super.checkInputBoxHasValue("roles", role);
		
		super.signOut();
	}
}
