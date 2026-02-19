package PriceBooks;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import ObjectRepo.CreateNewPriceBooksPage;
import ObjectRepo.HomePage;
import ObjectRepo.PriceBooksInfoPage;
import ObjectRepo.PriceBooksPage;

public class CreatePriceBookWithMandatoryFieldTest extends BaseClass {

	@Test(retryAnalyzer = Generic_Utilities.RetryImpClass.class)

	public void CreatePriceBookWithMandatoryFieldTest() throws IOException {

		// Read data from Excel file
		String PriceBookName = eutls.readDataFromExcel("Price_Books", 0, 1) + jutls.getRandomNo();

		// click on Vendor link
		HomePage hp = new HomePage(driver);
		hp.clickOnMoreLink();
		hp.clickOnPriceBooksLink();

		PriceBooksPage pbp = new PriceBooksPage(driver);
		pbp.clickOnPriceBooksLookUp();

		CreateNewPriceBooksPage cnpb = new CreateNewPriceBooksPage(driver);
		cnpb.createPriceBook(PriceBookName);

		// validate
		PriceBooksInfoPage pbip = new PriceBooksInfoPage(driver);
		pbip.validatingPriceBook(PriceBookName);
		Assert.fail();

		
	}
}
