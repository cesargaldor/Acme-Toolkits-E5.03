
package acme.testing.any.chirp;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyChirpCreate extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirp/positive-create.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveCreateTest(final int recordIndex, final String title, final String body, final String author, final String email, final String confirmation) {

		super.clickOnMenu("Any", "List chirps");
		super.clickOnButton("Create chirp");
		super.checkFormExists();
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("email", email);
		super.fillInputBoxIn("confirmation", confirmation);
		super.clickOnSubmit("Create");

		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, title);
		super.checkColumnHasValue(recordIndex, 3, body);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirp/negative-create.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeCreateTest(final int recordIndex, final String title, final String body, final String author, final String email, final String confirmation) {

		super.clickOnMenu("Any", "List chirps");
		super.clickOnButton("Create chirp");
		super.checkFormExists();

		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("email", email);
		super.fillInputBoxIn("confirmation", confirmation);
		super.clickOnSubmit("Create");

		super.checkErrorsExist();
	}

}
