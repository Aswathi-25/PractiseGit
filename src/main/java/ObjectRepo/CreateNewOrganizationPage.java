package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriverUtils;

public class CreateNewOrganizationPage extends WebDriverUtils {
	
	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(name="industry")
	private WebElement indDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getIndDD() {
		return indDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	//business logic
	
	public void createOrganization(String orname)
	{
		orgName.sendKeys(orname);
		saveBtn.click();
		
	}
	
	public void createOrganization(String orname, String indText)
	{
		orgName.sendKeys(orname);
		dropdownUsingVisibleText(indDD, indText);
		saveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
