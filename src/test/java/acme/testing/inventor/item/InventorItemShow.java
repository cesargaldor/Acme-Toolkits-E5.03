package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorItemShow extends TestHarness{


	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/show.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex,final String name, final String itemType, final String code,  
								final String technology, final String description, final String retailPrice, 
								final String optionalLink) {
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "List my Items");
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("itemType", itemType);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		
		super.signOut();
	}

}
