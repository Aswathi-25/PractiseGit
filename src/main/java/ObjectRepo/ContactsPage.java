package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	//declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement contactLookUpImg;
	
	//initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getContactLookUpImg() {
		return contactLookUpImg;
	}

	//business library
	public void clickOnContactLookUpImage()
	{
		contactLookUpImg.click();
	}
	
}
