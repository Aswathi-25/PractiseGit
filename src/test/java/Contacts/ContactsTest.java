package Contacts;

import java.io.IOException;

import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import ObjectRepo.ContactsInfoPage;
import ObjectRepo.ContactsPage;
import ObjectRepo.CreateNewContactPage;
import ObjectRepo.CreateNewOrganizationPage;
import ObjectRepo.HomePage;
import ObjectRepo.OrganizationInfoPage;
import ObjectRepo.OrganizationsPage;

public class ContactsTest extends BaseClass {

	@Test(priority = -2 , retryAnalyzer = Generic_Utilities.RetryImpClass.class)
	public void CreateContactWithMandatoryFieldsTest() throws IOException {

		// read data from excel
		String ContName = eutls.readDataFromExcel("Contacts", 0, 1) + jutls.getRandomNo();

		// click on Contacts link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();

		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnContactLookUpImage();

		// create contact with mandatory fields
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(ContName);

		// validating the confirmation message
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		cip.validatingContact(ContName);

	}
//--------------------------------------------------------------------------------------------------------

	@Test(groups = {"smoke"}, priority = -1)
	public void CreateContactWithOrgNameTest() throws IOException {

		String OrgName = eutls.readDataFromExcel("Organizations", 0, 1) + jutls.getRandomNo();
		String ContName = eutls.readDataFromExcel("Contacts", 0, 1) + jutls.getRandomNo();
		String indDD = eutls.readDataFromExcel("Organizations", 1, 1);

		// click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUp();

		// creating organization with industry dropdown
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(OrgName, indDD);

		// validate exp result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.validatingOrganization(OrgName);

		// navigate to contacts
		// click on Organizations link
		hp.clickOnContactsLink();

		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnContactLookUpImage();

		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(ContName, OrgName, driver);

		ContactsInfoPage cip = new ContactsInfoPage(driver);
		cip.validatingContact(ContName);

	}
	@Test(retryAnalyzer = Generic_Utilities.RetryImpClass.class)
	public void impact()
	{
		System.out.println("Contact is the impacted region");
	}

}
