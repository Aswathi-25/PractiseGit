package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic_Utilities.WebDriverUtils;

public class LoginValidationPage extends WebDriverUtils{
	
	//declaration
	@FindBy(xpath = "//a[@class='hdrLink']")
	private WebElement homePageHeader;
	
	//initialization 
	public LoginValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getHomePageHeader() {
		return homePageHeader;
	}

	//business logic validation
	public void validatingLogin(WebDriver driver)
	{
		
		waitUntilElementToBeVisible(driver, homePageHeader, 10);
		String header = homePageHeader.getText();
		Assert.assertTrue(header.contains("Home"),"Login unsuccessful");

		    System.out.println("Login is successful");
		}
}
