package acme.testing.any.component;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyComponentListAllTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/any/component/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveComponent(final int recordIndex, final String name, final String code, final String technology, final String description, 
		final String retailPrice, final String optionalLink) {
		

		super.clickOnMenu("Any", "List components");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, name);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, description);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
	}
}
