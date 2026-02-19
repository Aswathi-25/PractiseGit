package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppurtunitiesPage {
	
	//declarations
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement oppurLookUp;
	
	//initialization
	public OppurtunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOppurLookUp() {
		return oppurLookUp;
	}

	//business library
	public void clickOnOppurtunityLookUp()
	{
		oppurLookUp.click();
	}
}
