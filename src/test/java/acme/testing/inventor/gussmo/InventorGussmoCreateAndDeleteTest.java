package acme.testing.inventor.gussmo;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class InventorGussmoCreateAndDeleteTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/gussmo/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String name, final String code,final String explanation, final String startDate, final String endDate,final String ration, final String optionalLink) {
		super.signIn("inventor1", "inventor1");

		                                       
		super.clickOnMenu("Inventor", "List my components");
		super.checkListingExists();
		super.clickOnListingRecord(0);

		super.clickOnButton("Create Gussmo");
		
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("explanation", explanation);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("endDate", endDate);
		super.fillInputBoxIn("ration", ration);
		super.fillInputBoxIn("optionalLink", optionalLink);
		super.clickOnSubmit("Create");

		super.clickOnButton("Gussmo");
		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("explanation", explanation);
		super.checkInputBoxHasValue("startDate", startDate);
		super.checkInputBoxHasValue("endDate", endDate);
		super.checkInputBoxHasValue("ration", ration);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		
		super.clickOnSubmit("Delete");
		super.checkNotButtonExists("Gussmo");
		super.checkButtonExists("Create Gussmo");
		
		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/gussmo/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String name, final String code,final String explanation, final String startDate, final String endDate,final String ration, final String optionalLink) {
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "List my components");
		super.checkListingExists();
		super.clickOnListingRecord(0);

		super.clickOnButton("Create Gussmo");
		
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("explanation", explanation);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("endDate", endDate);
		super.fillInputBoxIn("ration", ration);
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


		
		//Checking you can't create a gussmo for an item that already has one                          <---------------------- Dejar si Tool
		super.clickOnMenu("Inventor", "List my components");
		super.checkListingExists();
		super.clickOnListingRecord(0);
		createQuery ="language=en&debug=true&masterId=" + super.getCurrentQuery().substring(4);
		super.navigate("/inventor/gussmo/create", createQuery);
		super.checkPanicExists();
		
		//Artefact=Tool
		//Getting query for an unpublished item with no gussmo
		super.clickOnMenu("Inventor", "List my tools");
		super.checkListingExists();
		super.clickOnListingRecord(2);
		super.clickOnButton("Create Gussmo");
		createQuery ="language=en&debug=true&" + super.getCurrentQuery().substring(1);
		
		
		//Checking you can't delete a published item's gussmo
		super.clickOnMenu("Inventor", "List my gussmos");
		super.checkListingExists();
		super.clickOnListingRecord(0);
		deleteQuery ="language=en&debug=true&" + super.getCurrentQuery().substring(1);
		super.navigate("/inventor/gussmo/delete", deleteQuery);
		super.checkPanicExists();
		
		//Getting query for not published gussmo
		super.clickOnMenu("Inventor", "List my gussmos");
		super.checkListingExists();
		super.clickOnListingRecord(2);
		deleteQuery ="language=en&debug=true&" + super.getCurrentQuery().substring(1);
		
		super.signOut();
		
		//Checking other roles' access
		super.checkNotLinkExists("Account");
		super.navigate("/inventor/gussmo/create", createQuery);
		super.checkPanicExists();
		
		super.signIn("patron1", "patron1");
		super.navigate("/inventor/gussmo/create", createQuery);
		super.checkPanicExists();
		super.signOut();
		
		super.signIn("administrator", "administrator");
		super.navigate("/inventor/gussmo/create", createQuery);
		super.checkPanicExists();
		super.signOut();
		
		//Checking you can't create a gussmo for another's item
		super.signIn("inventor4", "inventor4");
		super.navigate("/inventor/gussmo/create", createQuery);
		super.checkPanicExists();
		
		//Checking you can't create a gussmo for a published item
		super.clickOnMenu("Inventor", "List my tools");
		super.checkListingExists();
		super.clickOnListingRecord(0); //query = ?id=xx
		createQuery ="language=en&debug=true&masterId=" + super.getCurrentQuery().substring(4);
		super.navigate("/inventor/gussmo/create", createQuery);
		super.checkPanicExists();
		
		//Checking you can't delete another's unpublished gussmo
		super.navigate("/inventor/gussmo/delete", deleteQuery);
		super.checkPanicExists();
		
		super.signOut();
		
	}

	// Ancillary methods ------------------------------------------------------

}
