package Organizations;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import ObjectRepo.CreateNewOrganizationPage;
import ObjectRepo.HomePage;
import ObjectRepo.OrganizationInfoPage;
import ObjectRepo.OrganizationsPage;

public class OrganizationTest extends BaseClass {

	@Test(priority = -2,retryAnalyzer = Generic_Utilities.RetryImpClass.class)
	public void CreateOrgWithMandatoryFieldsTest() throws IOException {

		// Read data from Excel file
		String OrgName = eutls.readDataFromExcel("Organizations", 0, 1) + jutls.getRandomNo();

		// click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		// click on the lookup image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUp();

		// create New Organization with mandatory field
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(OrgName);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.validatingOrganization(OrgName);

	

	}

	// -------------------------------------------------------------------------------------------------------

	@Test(groups = {"smoke","org"}, priority = -1)
	public void CreateOrgWithIndustryDDTest() throws IOException {

		// Read data from Excel file
		String OrgName = eutls.readDataFromExcel("Organizations", 0, 1) + jutls.getRandomNo();
		String indDD = eutls.readDataFromExcel("Organizations", 1, 1);

		// click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		// click on the lookup image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUp();

		// create New Organization with industry dropdown
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(OrgName, indDD);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.validatingOrganization(OrgName);

		Assert.fail();
		

	}

}
