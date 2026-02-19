package ObjectRepo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {

	//declarations
	@FindBy(name="campaignname")
	private WebElement campName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCampName() {
		return campName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business library
	public void createCampaign(String campaignName)
	{
		campName.clear();
		campName.sendKeys(campaignName);
		saveBtn.click();
		
	}
}