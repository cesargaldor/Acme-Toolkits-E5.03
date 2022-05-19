package acme.testing.patron.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageListTest  extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/list.csv", encoding = "utf-8")
	@Order(10)
	public void PositiveTest(final int recordIndex, final String status, final String code, final String budget, final String legalStuff, final String isPublished) {
		
		super.signIn("patron1", "patron1");

		
		super.clickOnMenu("Patron", "List all patronges");
		super.checkListingExists();
		
		super.checkColumnHasValue(recordIndex, 0, status);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, budget);
		super.checkColumnHasValue(recordIndex, 3, legalStuff);
		super.checkColumnHasValue(recordIndex, 3, isPublished);
		super.signOut();

	}
}