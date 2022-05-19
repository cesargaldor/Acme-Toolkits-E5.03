package acme.testing.patron.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageCreateTest extends TestHarness{
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String code, final String legalStuff, final String budget, final String moment, final String optionalLink, final String isPublished, final String status) {
		
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "List my patronages");
		super.checkListingExists();
		super.clickOnButton("Create");
//		super.fillInputBoxIn("code", code);
//		super.fillInputBoxIn("legalStuff", legalStuff);
//		super.fillInputBoxIn("budget", budget);
//		super.fillInputBoxIn("moment", moment);
//		super.fillInputBoxIn("optionalLink", optionalLink);
//		super.fillInputBoxIn("isPublished", isPublished);
//		super.fillInputBoxIn("status", status);
//		super.clickOnSubmit("Create");
//		
//		super.clickOnMenu("Patron", "Listar mis patrocinios");
//		super.checkListingExists();
//		super.checkColumnHasValue(recordIndex, 0, status);
//		super.checkColumnHasValue(recordIndex, 1, code);
//		super.checkColumnHasValue(recordIndex, 2, legalStuff);
//		super.checkColumnHasValue(recordIndex, 3, budget);
//		super.checkColumnHasValue(recordIndex, 4, moment);
//		super.checkColumnHasValue(recordIndex, 5, isPublished);		
//		super.clickOnListingRecord(recordIndex);
//		
//		super.checkFormExists();
//		super.checkInputBoxHasValue("status", status);
//		super.checkInputBoxHasValue("code", code);
//		super.checkInputBoxHasValue("legalStuf", legalStuff);
//		super.checkInputBoxHasValue("budget", budget);
//		super.checkInputBoxHasValue("moment", moment);
//		super.checkInputBoxHasValue("optionalLink", optionalLink);
//		super.checkInputBoxHasValue("status", status);
		super.signOut();
		
	}

}
