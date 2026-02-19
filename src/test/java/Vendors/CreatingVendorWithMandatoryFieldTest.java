package Vendors;

import java.io.IOException;

import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import ObjectRepo.CreateNewVendorPage;
import ObjectRepo.HomePage;
import ObjectRepo.VendorInfoPage;
import ObjectRepo.VendorsPage;

public class CreatingVendorWithMandatoryFieldTest extends BaseClass {

	@Test(groups = "smoke", retryAnalyzer = Generic_Utilities.RetryImpClass.class)
	public void CreatingVendorWithMandatoryFieldTest() throws IOException {

		// read data from excel
		String VendorName = eutls.readDataFromExcel("Vendors", 0, 1) + jutls.getRandomNo();
		String ven_email = eutls.readDataFromExcel("Vendors", 1, 1);
		String ven_phone = eutls.readDataFromExcel("Vendors", 2, 1);

		// click on Vendor link
		HomePage hp = new HomePage(driver);
		hp.clickOnMoreLink();
		hp.clickOnVendorsLink();

		VendorsPage cp = new VendorsPage(driver);
		cp.clickOnVendorLookUpImg();

		CreateNewVendorPage cnvp = new CreateNewVendorPage(driver);
		cnvp.createVendor(VendorName, ven_email, ven_phone);

		VendorInfoPage vip = new VendorInfoPage(driver);
		vip.validatingVendor(driver, VendorName);

	}

}
