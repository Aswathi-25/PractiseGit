package Oppurtunities;

import java.io.IOException;

import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import ObjectRepo.CreateNewOppurtunityPage;
import ObjectRepo.CreateNewOrganizationPage;
import ObjectRepo.HomePage;
import ObjectRepo.OppurtunitiesInfoPage;
import ObjectRepo.OppurtunitiesPage;
import ObjectRepo.OrganizationInfoPage;
import ObjectRepo.OrganizationsPage;

public class CreateOppurWithOrgFieldsTest extends BaseClass {
	
	@Test(retryAnalyzer = Generic_Utilities.RetryImpClass.class)
	public void CreateOppurWithOrgFieldsTest() throws IOException {

		String futureDate = jutls.systemFutureDate(9);

		// read data from excel
		String OppurName = eutls.readDataFromExcel("Oppurtunities", 0, 1) + jutls.getRandomNo();
		String OrgName = eutls.readDataFromExcel("Organizations", 0, 1) + jutls.getRandomNo();
		String indDD = eutls.readDataFromExcel("Organizations", 1, 1);

		// click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUp();

		// create organization with industry dropdown
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(OrgName, indDD);

		// validate exp result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.validatingOrganization(OrgName);

		// click on oppurtunities
		hp.clickOnOppurtunitiesLink();

		// click on lookupimage
		OppurtunitiesPage opp = new OppurtunitiesPage(driver);
		opp.clickOnOppurtunityLookUp();

		// create oppurtunity with organization
		CreateNewOppurtunityPage cnop2 = new CreateNewOppurtunityPage(driver);
		cnop2.createOppurtunity(OppurName, OrgName, futureDate, driver);

		// capturing confirmation message
		OppurtunitiesInfoPage opip = new OppurtunitiesInfoPage(driver);
		opip.validatingOppurtunity(OppurName);

	}
	@Test(retryAnalyzer = Generic_Utilities.RetryImpClass.class)
	public void impact()
	{
		System.out.println("Oppurtunity is the impacted region");
	}

}
