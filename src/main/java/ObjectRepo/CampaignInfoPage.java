package ObjectRepo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CampaignInfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement campConfirmHeader;
	
	public CampaignInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampConfirmHeader() {
		return campConfirmHeader;
	}

	
	//business library
		public void validatingCampaign(String CampaignName)
		{
			
		    
			String header = campConfirmHeader.getText();
			// validating whether actual and expected result is same or not
			if (header.contains(CampaignName)) {
				System.out.println("Campaign is created successfully");
			} else {
				System.out.println("Campaign is not created");
			}
		}
}
