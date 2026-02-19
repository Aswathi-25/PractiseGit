package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static org.testng.Assert.*;

public class OppurtunitiesInfoPage {
	
	//declarations
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement oppurHeader;
	
	//initialization
	public OppurtunitiesInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getOppurHeader() {
		return oppurHeader;
	}
	
	
	//business library
	public void validatingOppurtunity(String oppName)
	{
		String header = oppurHeader.getText();
		
		assertTrue(header.contains(oppName), "Oppurtunity is not created");
		
		Reporter.log("Oppurtunity is created successfully");
		// validating whether actual and expected result is same or not
//		if (header.contains(oppName)) {
//			System.out.println("Oppurtunity is created successfully");
//		} else {
//			System.out.println("Oppurtunity is not created");
//		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
