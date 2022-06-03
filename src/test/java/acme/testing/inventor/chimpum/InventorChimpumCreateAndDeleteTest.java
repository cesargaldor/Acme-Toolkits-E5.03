package acme.testing.inventor.chimpum;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class InventorChimpumCreateAndDeleteTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/chimpum/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String title, final String code,final String description, final String startDate, final String endDate,final String budget, final String optionalLink) {
		super.signIn("inventor1", "inventor1");

		//Artefact=Component                                      <---------------------- Cambiar si Component
//		super.clickOnMenu("Inventor", "List my components");
//		super.checkListingExists();
//		super.clickOnListingRecord(0);
		
		//Artefact=Tool                                           <---------------------- Dejar si Tool
		super.clickOnMenu("Inventor", "List my tools");
		super.checkListingExists();
		super.clickOnListingRecord(2);

		super.clickOnButton("Create Chimpum");
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("endDate", endDate);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("optionalLink", optionalLink);
		super.clickOnSubmit("Create");

		super.clickOnButton("Chimpum");
		super.checkFormExists();
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("startDate", startDate);
		super.checkInputBoxHasValue("endDate", endDate);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		
		super.clickOnSubmit("Delete");
		super.checkNotButtonExists("Chimpum");
		super.checkButtonExists("Create Chimpum");
		
		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/chimpum/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String title, final String code,final String description, final String startDate, final String endDate,final String budget, final String optionalLink) {
		super.signIn("inventor1", "inventor1");
		
		//Artefact=Component                                      <---------------------- Cambiar si Component
//		super.clickOnMenu("Inventor", "List my components");
//		super.checkListingExists();
//		super.clickOnListingRecord(0);
		
		//Artefact=Tool                                          <---------------------- Dejar si Tool
		super.clickOnMenu("Inventor", "List my tools");
		super.checkListingExists();
		super.clickOnListingRecord(2);

		super.clickOnButton("Create Chimpum");
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("endDate", endDate);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("optionalLink", optionalLink);
		super.clickOnSubmit("Create");
		
		super.checkErrorsExist();

		super.signOut();
	}

	@Test
	@Order(30)
	public void hackingTest() {
		String createQuery;
		String deleteQuery;
		
		super.signIn("inventor1", "inventor1");

		//Artefact=Component                                                                      <---------------------- Cambiar si Component
//		super.clickOnMenu("Inventor", "List my components");
//		super.checkListingExists();
//		super.clickOnListingRecord(0);
		
		//Checking you can't create a chimpum for an item that already has one                          <---------------------- Dejar si Tool
		super.clickOnMenu("Inventor", "List my tools");
		super.checkListingExists();
		super.clickOnListingRecord(1);
		createQuery ="language=en&debug=true&masterId=" + super.getCurrentQuery().substring(4);
		super.navigate("/inventor/chimpum/create", createQuery);
		super.checkPanicExists();
		
		//Artefact=Tool
		//Getting query for an unpublished item with no chimpum
		super.clickOnMenu("Inventor", "List my tools");
		super.checkListingExists();
		super.clickOnListingRecord(2);
		super.clickOnButton("Create Chimpum");
		createQuery ="language=en&debug=true&" + super.getCurrentQuery().substring(1);
		
		
		//Checking you can't delete a published item's chimpum
		super.clickOnMenu("Inventor", "List my chimpums");
		super.checkListingExists();
		super.clickOnListingRecord(0);
		deleteQuery ="language=en&debug=true&" + super.getCurrentQuery().substring(1);
		super.navigate("/inventor/chimpum/delete", deleteQuery);
		super.checkPanicExists();
		
		//Getting query for not published chimpum
		super.clickOnMenu("Inventor", "List my chimpums");
		super.checkListingExists();
		super.clickOnListingRecord(2);
		deleteQuery ="language=en&debug=true&" + super.getCurrentQuery().substring(1);
		
		super.signOut();
		
		//Checking other roles' access
		super.checkNotLinkExists("Account");
		super.navigate("/inventor/chimpum/create", createQuery);
		super.checkPanicExists();
		
		super.signIn("patron1", "patron1");
		super.navigate("/inventor/chimpum/create", createQuery);
		super.checkPanicExists();
		super.signOut();
		
		super.signIn("administrator", "administrator");
		super.navigate("/inventor/chimpum/create", createQuery);
		super.checkPanicExists();
		super.signOut();
		
		//Checking you can't create a chimpum for another's item
		super.signIn("inventor4", "inventor4");
		super.navigate("/inventor/chimpum/create", createQuery);
		super.checkPanicExists();
		
		//Checking you can't create a chimpum for a published item
		super.clickOnMenu("Inventor", "List my tools");
		super.checkListingExists();
		super.clickOnListingRecord(0); //query = ?id=xx
		createQuery ="language=en&debug=true&masterId=" + super.getCurrentQuery().substring(4);
		super.navigate("/inventor/chimpum/create", createQuery);
		super.checkPanicExists();
		
		//Checking you can't delete another's unpublished chimpum
		super.navigate("/inventor/chimpum/delete", deleteQuery);
		super.checkPanicExists();
		
		super.signOut();
		
	}

	// Ancillary methods ------------------------------------------------------

}
