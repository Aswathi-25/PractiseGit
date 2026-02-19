package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static org.testng.Assert.*;

public class OrganizationInfoPage {
	
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ConfirmationHeader;
	
	//initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getConfirmationHeader() {
		return ConfirmationHeader;
	}

	//business library
	public void validatingOrganization(String OrgName)
	{
		String header = ConfirmationHeader.getText();
		
		assertTrue(header.contains(OrgName), "Organization is not created");
		
		Reporter.log("Organization is created successfully");
		// validating whether actual and expected result is same or not
//		if (header.contains(OrgName)) {
//			System.out.println("Organization is created successfully");
//		} else {
//			System.out.println("Organization is not created");
//		}
	}

}
