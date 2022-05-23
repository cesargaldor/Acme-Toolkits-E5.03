package acme.testing.any.chirp;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyChirpListAllTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirp/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveComponent(final int recordIndex, final String moment, final String author, final String title, final String body) {
		

		super.clickOnMenu("Any", "List chirps");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, author);
		super.checkColumnHasValue(recordIndex, 3, body);

//		super.clickOnListingRecord(recordIndex);
//		super.checkFormExists();
//		super.checkInputBoxHasValue("moment", moment);
//		super.checkInputBoxHasValue("author", author);
//		super.checkInputBoxHasValue("title", title);
//		super.checkInputBoxHasValue("body", body);
	}
}
