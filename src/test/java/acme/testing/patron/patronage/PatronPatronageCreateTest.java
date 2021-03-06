
package acme.testing.patron.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.framework.testing.BrowserDriver;
import acme.testing.TestHarness;

public class PatronPatronageCreateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String moment, final String optionalLink, final String inventorId) {

		final BrowserDriver driver = super.getDriver();

		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "List patronages");
		super.clickOnButton("Create patronage");

		super.fillInputBoxIn("status", status);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("legalStuff", legalStuff);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("moment", moment);
		super.fillInputBoxIn("optionalLink", optionalLink);
		super.fillInputBoxIn("inventorId", inventorId);
		//driver.locateOne(By.xpath("//*[@id=\"inventorId\"]/option[" + inventorId + "]")).click();
		
		super.clickOnSubmit("Create patronage");
		super.signOut();
	}

}
