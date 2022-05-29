
package acme.testing.administrator.configuration;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdministratorConfigurationUpdateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/configuration/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void updateConfigurationPositive(final String systemCurrency, final String acceptedCurrencies, final String strongSpam, final String strongThreshold, final String weakSpam, final String weakThreshold) {

		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "System configuration");

		super.checkFormExists();
		super.fillInputBoxIn("sysCurrency", systemCurrency);
		super.fillInputBoxIn("allowedCurrencies", acceptedCurrencies);
		super.fillInputBoxIn("strongSpam", strongSpam);
		super.fillInputBoxIn("strongThreshold", strongThreshold);
		super.fillInputBoxIn("weakSpam", weakSpam);
		super.fillInputBoxIn("weakThreshold", weakThreshold);

		super.clickOnSubmit("Update");

		super.checkNotErrorsExist();

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/configuration/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void updateConfigurationNegative(final String systemCurrency, final String acceptedCurrencies, final String strongSpam, final String strongThreshold, final String weakSpam, final String weakThreshold) {

		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "System configuration");

		super.checkFormExists();
		super.fillInputBoxIn("sysCurrency", systemCurrency);
		super.fillInputBoxIn("allowedCurrencies", acceptedCurrencies);
		super.fillInputBoxIn("strongSpam", strongSpam);
		super.fillInputBoxIn("strongThreshold", strongThreshold);
		super.fillInputBoxIn("weakSpam", weakSpam);
		super.fillInputBoxIn("weakThreshold", weakThreshold);

		super.clickOnSubmit("Update");

		super.checkErrorsExist();

		super.signOut();
	}
}
