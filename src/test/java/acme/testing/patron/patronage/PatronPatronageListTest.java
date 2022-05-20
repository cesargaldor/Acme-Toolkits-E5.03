package acme.testing.patron.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageListTest  extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void ListPositiveTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget,final String moment, final String isPublished) {
		
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "List all patronages");
		///super.sortListing(recordIndex, isPublished);
		super.checkColumnHasValue(recordIndex, 0, status);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, legalStuff);
		super.checkColumnHasValue(recordIndex, 3, budget);
		super.checkColumnHasValue(recordIndex, 4, moment);
		super.checkColumnHasValue(recordIndex, 5, isPublished);
		super.signOut();

	}
}