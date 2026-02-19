package ObjectRepo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriverUtils;


public class CreateNewContactPage extends WebDriverUtils {
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement orgLookUpField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//childwindow elements
	@FindBy(id="search_txt")
	private WebElement searchTxtField;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchNowBtn;
	
	//initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getOrgLookUpField() {
		return orgLookUpField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSearchTxtField() {
		return searchTxtField;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	//business library
	public void createContact(String contname)
	{
		lastname.sendKeys(contname);
		saveBtn.click();
		
	}
	
	public void createContact(String contname, String orgName, WebDriver driver)
	{
		lastname.sendKeys(contname);
		orgLookUpField.click();
		switchToWindow(driver, "Accounts&action");
		searchTxtField.clear();
		searchTxtField.sendKeys(orgName);
		searchNowBtn.click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		switchToWindow(driver, "Contacts&action");
		saveBtn.click();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}