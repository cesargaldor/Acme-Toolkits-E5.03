package acme.testing.patron.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageList extends TestHarness {

	@ParameterizedTest	
	@CsvFileSource(resources = "/patron/patronage/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String code, final String startPeriod, final String endPeriod) {
		
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "List my patronages");
		
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, moment);
		super.signOut();
	}
}