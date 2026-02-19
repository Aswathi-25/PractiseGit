package Campaigns;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import ObjectRepo.CampaignInfoPage;
import ObjectRepo.CampaignsPage;
import ObjectRepo.CreateNewCampaignPage;
import ObjectRepo.HomePage;

public class CreateCampaignsWithMandatoryFieldTest extends BaseClass {
	
	@Test(retryAnalyzer = Generic_Utilities.RetryImpClass.class)
	public void CreateCampaignsWithMandatoryFieldTest() throws IOException {

		// Read data from Excel file
		String CampName = eutls.readDataFromExcel("Campaigns", 0, 1) + jutls.getRandomNo();

		// click on Vendor link
		HomePage hp = new HomePage(driver);
		hp.clickOnMoreLink();
		hp.clickOnCampaignsLink();

		CampaignsPage cp = new CampaignsPage(driver);
		cp.clickOnCampaignLookUp();

		CreateNewCampaignPage cncp = new CreateNewCampaignPage(driver);
		cncp.createCampaign(CampName);

		// validate exp result
		CampaignInfoPage cip = new CampaignInfoPage(driver);
		cip.validatingCampaign(CampName);
		
		

	}
	
}
