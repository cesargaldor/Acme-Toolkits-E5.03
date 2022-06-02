package acme.testing.administrator.announcement;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdministratorAnnouncementCreateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createAnnouncementPositiveTest(final int recordIndex, final String title, final String body, final String critical, final String link, final String confirmation) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "List announcemets");
		super.checkListingExists();

		super.clickOnButton("Create");

		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("optionalLink", link);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("flag", critical);
		super.fillInputBoxIn("confirmation", confirmation);
		super.clickOnSubmit("Create");

		super.checkNotErrorsExist();

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void createAnnouncementNegativeTest(final int recordIndex, final String title, final String body, final String critical, final String link, final String confirmation) {

		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "List announcemets");
		super.clickOnButton("Create");
		super.checkFormExists();

		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("flag", critical);
		super.fillInputBoxIn("optionalLink", link);
		super.fillInputBoxIn("confirmation", confirmation);

		super.clickOnSubmit("Create");

		super.checkErrorsExist();

		super.signOut();
	}

}
