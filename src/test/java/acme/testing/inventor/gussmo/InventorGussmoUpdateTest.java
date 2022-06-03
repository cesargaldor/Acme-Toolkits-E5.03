package acme.testing.inventor.gussmo;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorGussmoUpdateTest extends TestHarness {


	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/gussmo/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String name, final String explanation, final String startDate, final String endDate,final String ration, final String optionalLink) {
		super.signIn("inventor1", "inventor1");

		/*Artefact=Component                                                 <---------------------- Cambiar si Component
		super.clickOnMenu("Inventor", "List my components"); 
		super.checkListingExists();
		super.clickOnListingRecord(0);
		
		Artefact=Tool                                                     <---------------------- Dejar si Tool*/
		super.clickOnMenu("Inventor", "List my gussmos");
		super.checkListingExists();
		super.clickOnListingRecord(2);

		
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("explanation", explanation);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("endDate", endDate);
		super.fillInputBoxIn("ration", ration);
		super.fillInputBoxIn("optionalLink", optionalLink);
		super.clickOnSubmit("Update");

		super.clickOnListingRecord(2);
		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("explanation", explanation);
		super.checkInputBoxHasValue("startDate", startDate);
		super.checkInputBoxHasValue("endDate", endDate);
		super.checkInputBoxHasValue("ration", ration);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		
		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/gussmo/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String name, final String explanation, final String startDate, final String endDate,final String ration, final String optionalLink) {
		super.signIn("inventor1", "inventor1");
		                                                   
		super.clickOnMenu("Inventor", "List my components");
		super.checkListingExists();
		super.clickOnListingRecord(0);
		
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("explanation", explanation);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("endDate", endDate);
		super.fillInputBoxIn("ration", ration);
		super.fillInputBoxIn("optionalLink", optionalLink);
		super.clickOnSubmit("Update");
		
		super.checkErrorsExist();

		super.signOut();
	}

	@Test
	@Order(30)
	public void hackingTest() {
		String query,published;
		
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List my components");
		super.checkListingExists();
		super.clickOnListingRecord(0);
		query ="language=en&debug=true&" + super.getCurrentQuery().substring(1);
		super.clickOnButton("Return");
		super.clickOnListingRecord(0);
		published ="language=en&debug=true&" + super.getCurrentQuery().substring(1);
		
		//checking you can't update a published item's gussmo
		super.navigate("/inventor/gussmo/update", published);
		super.checkPanicExists();
		
		super.signOut();
		
		//Checking another roles' access
		super.checkNotLinkExists("Account");
		super.navigate("/inventor/gussmo/update", query);
		super.checkPanicExists();
		
		super.signIn("patron1", "patron1");
		super.navigate("/inventor/gussmo/update", query);
		super.checkPanicExists();
		super.signOut();
		
		super.signIn("administrator", "administrator");
		super.navigate("/inventor/gussmo/update", query);
		super.checkPanicExists();
		super.signOut();
		
		//Checking you can't update another's unpublished gussmo
		super.signIn("inventor4", "inventor4");
		super.navigate("/inventor/gussmo/update", query);
		super.checkPanicExists();
		//Checking you can't update another's published gussmo
		super.navigate("/inventor/gussmo/update", published);
		super.checkPanicExists();
		super.signOut();
		
	}
}
