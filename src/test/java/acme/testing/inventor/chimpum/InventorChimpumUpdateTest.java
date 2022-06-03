package acme.testing.inventor.chimpum;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorChimpumUpdateTest extends TestHarness {


	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/chimpum/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String title, final String description, final String startDate, final String endDate,final String budget, final String optionalLink) {
		super.signIn("inventor1", "inventor1");

		/*Artefact=Component                                                 <---------------------- Cambiar si Component
		super.clickOnMenu("Inventor", "List my components"); 
		super.checkListingExists();
		super.clickOnListingRecord(0);
		
		Artefact=Tool                                                     <---------------------- Dejar si Tool*/
		super.clickOnMenu("Inventor", "List my chimpums");
		super.checkListingExists();
		super.clickOnListingRecord(2);

		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("endDate", endDate);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("optionalLink", optionalLink);
		super.clickOnSubmit("Update");

		super.clickOnListingRecord(2);
		super.checkFormExists();
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("startDate", startDate);
		super.checkInputBoxHasValue("endDate", endDate);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		
		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/chimpum/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String title, final String description, final String startDate, final String endDate,final String budget, final String optionalLink) {
		super.signIn("inventor1", "inventor1");
		
		/*Artefact=Component                                                     <---------------------- Cambiar si Component
		super.clickOnMenu("Inventor", "List my components");
		super.checkListingExists();
		super.clickOnListingRecord(0);
		
		Artefact=Tool                                                           <---------------------- Dejar final si Tool*/
		super.clickOnMenu("Inventor", "List my chimpums");
		super.checkListingExists();
		super.clickOnListingRecord(2);
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("endDate", endDate);
		super.fillInputBoxIn("budget", budget);
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

		//Artefact=Component
//		super.clickOnMenu("Inventor", "List my components");
//		super.checkListingExists();
//		super.clickOnListingRecord(0);
		
		//Artefact=Tool
		super.clickOnMenu("Inventor", "List my chimpums");
		super.checkListingExists();
		super.clickOnListingRecord(2);
		query ="language=en&debug=true&" + super.getCurrentQuery().substring(1);
		super.clickOnButton("Return");
		super.clickOnListingRecord(0);
		published ="language=en&debug=true&" + super.getCurrentQuery().substring(1);
		
		//checking you can't update a published item's chimpum
		super.navigate("/inventor/chimpum/update", published);
		super.checkPanicExists();
		
		super.signOut();
		
		//Checking another roles' access
		super.checkNotLinkExists("Account");
		super.navigate("/inventor/chimpum/update", query);
		super.checkPanicExists();
		
		super.signIn("patron1", "patron1");
		super.navigate("/inventor/chimpum/update", query);
		super.checkPanicExists();
		super.signOut();
		
		super.signIn("administrator", "administrator");
		super.navigate("/inventor/chimpum/update", query);
		super.checkPanicExists();
		super.signOut();
		
		//Checking you can't update another's unpublished chimpum
		super.signIn("inventor4", "inventor4");
		super.navigate("/inventor/chimpum/update", query);
		super.checkPanicExists();
		//Checking you can't update another's published chimpum
		super.navigate("/inventor/chimpum/update", published);
		super.checkPanicExists();
		super.signOut();
		
	}
}
