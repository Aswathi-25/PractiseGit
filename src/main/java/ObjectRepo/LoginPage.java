package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriverUtils;

public class LoginPage {

	// declaration
	@FindBy(name = "user_name")
	private WebElement username;

	@FindBy(name = "user_password")
	private WebElement password;

	@FindBy(id = "submitButton")
	private WebElement loginbtn;

//intialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//utilization
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

     //business logic 
	public void loginToApplication(String userName, String passWord)
	{
		username.sendKeys(userName);
		password.sendKeys(passWord);
		loginbtn.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}