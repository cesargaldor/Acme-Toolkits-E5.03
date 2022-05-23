package acme.testing.administrator.announcement;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdministratorAnnouncementCreateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	
	public void positiveTest(final int recordIndex, final String title, final String body, final String critical, final String link) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "Create announcement");
		super.checkFormExists();
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("flag", critical);
		super.fillInputBoxIn("body", body);
		
		super.fillInputBoxIn("optionalLink", link);
		super.fillInputBoxIn("confirmation", "true");

		super.clickOnSubmit("Create");

		super.clickOnMenu("Any", "Announcement");

		super.checkListingExists();
		super.sortListing(2, "desc");
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, critical);

		super.clickOnListingRecord(recordIndex);

		super.checkFormExists();
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("body", body);
		super.checkInputBoxHasValue("flag", critical);
		super.checkInputBoxHasValue("optionalLink", link);

		super.signOut();
	}
	
	 
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String title, final String body, final String critical, final String link) {
		
	

		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "Create announcement");
		super.checkFormExists();

		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("flag", critical);
		super.fillInputBoxIn("optionalLink", link);
		super.fillInputBoxIn("confirmation", "true");

		super.clickOnSubmit("Create");

		super.checkErrorsExist();

		super.signOut();
	}
}
