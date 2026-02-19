package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	
	//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactConfirmHeader;
	
	
	//initialization
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//utilization
	public WebElement getContactConfirmHeader() {
		return contactConfirmHeader;
	}
	
	//business library
	public void validatingContact(String ContName)
	{
		String header = contactConfirmHeader.getText();
		// validating whether actual and expected result is same or not
		if (header.contains(ContName)) {
			System.out.println("Contact is created successfully");
		} else {
			System.out.println("Contact is not created");
		}
	}
	

}
