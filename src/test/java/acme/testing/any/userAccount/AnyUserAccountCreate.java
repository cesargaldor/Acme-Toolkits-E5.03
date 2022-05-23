
package acme.testing.any.userAccount;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyUserAccountCreate extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/any/user-account/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(1)
	public void createUserPositive(final int recordIndex, final String username, final String password, final String confirmation, final String name, final String surname, final String email, final String phone, final String accept) {

		super.signUp(username, password, name, surname, email, phone);

		super.signIn(username, password);

		super.signOut();

	}

	@ParameterizedTest
	@CsvFileSource(resources = "/any/user-account/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(12)
	public void createUserNegative(final int recordIndex, final String username, final String password, final String confirmation, final String name, final String surname, final String email, final String phone, final String accept) {

		super.clickOnMenu("Sign up");
		super.fillInputBoxIn("username", username);
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("confirmation", password);
		super.fillInputBoxIn("identity.name", name);
		super.fillInputBoxIn("identity.surname", surname);
		super.fillInputBoxIn("identity.email", email);
		super.fillInputBoxIn("identity.phone", phone);
		super.fillInputBoxIn("accept", accept);
		super.clickOnSubmit("Sign up");

		super.checkErrorsExist();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/any/user-account/become-patron-success.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(3)
	public void becomePatronSuccess(final int recordIndex, final String username, final String password, final String company, final String statement, final String link) {

		super.signIn(username, password);
		super.clickOnMenu("Account", "Become a patron");

		super.checkFormExists();

		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Register");

		super.checkNotErrorsExist();

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/any/user-account/become-patron-error.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(4)
	public void becomePatronError(final int recordIndex, final String username, final String password, final String confirmation, final String name, final String surname, final String email, final String phone, final String accept, final String company, final String statement, final String link) {

		super.signUp(username, password, name, surname, email, phone);
		super.signIn(username, password);
		super.clickOnMenu("Account", "Become a patron");

		super.checkFormExists();

		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Register");

		super.checkErrorsExist();

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/any/user-account/become-inventor-success.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(5)
	public void becomeInventorSuccess(final int recordIndex, final String username, final String password, final String company, final String statement, final String link) {

		super.signIn(username, password);
		super.clickOnMenu("Account", "Become a inventor");

		super.checkFormExists();

		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Register");

		super.checkNotErrorsExist();

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/any/user-account/become-inventor-error.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(6)
	public void becomeInventorError(final int recordIndex, final String username, final String password, final String confirmation, final String name, final String surname, final String email, final String phone, final String accept, final String company, final String statement, final String link) {

		super.signUp(username, password, name, surname, email, phone);
		super.signIn(username, password);
		super.clickOnMenu("Account", "Become a inventor");

		super.checkFormExists();

		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Register");

		super.checkErrorsExist();

		super.signOut();
	}
}
