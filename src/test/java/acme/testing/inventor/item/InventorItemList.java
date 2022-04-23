package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorItemList extends TestHarness{


		@ParameterizedTest
		@CsvFileSource(resources = "/inventor/item/list-mine.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void positiveTest(final int recordIndex,final String name, final String type, final String code,  
									final String technology, final String retailPrice) {
			
			super.signIn("inventor1", "inventor1");
			super.clickOnMenu("Inventor", "List my Items");
			
			super.checkColumnHasValue(recordIndex, 0, name);
			super.checkColumnHasValue(recordIndex, 1, type);
			super.checkColumnHasValue(recordIndex, 2, code);
			super.checkColumnHasValue(recordIndex, 3, technology);
			super.checkColumnHasValue(recordIndex, 4, retailPrice);
			super.signOut();
		}
		
}
