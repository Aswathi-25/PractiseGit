package ObjectRepo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static org.testng.Assert.*;

public class VendorInfoPage {

	//declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement vendorConfirmHeader;
	
	
	//initialization
	public VendorInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

    //utilization
	public WebElement getVendorConfirmHeader() {
		return vendorConfirmHeader;
	}
	
	public void validatingVendor(WebDriver driver, String vendorName)
	{
		try {
	        
			Alert alert = driver.switchTo().alert();
	        System.out.println(alert.getText());
	        alert.accept();
	    } catch (Exception e) {
	        // no alert
		String header = vendorConfirmHeader.getText();
		
		assertTrue(header.contains(vendorName),"Vendor is not created");
		
		//to print the message in report and in console
		Reporter.log("Vendor is created successfully");
		// validating whether actual and expected result is same or not
//		if (header.contains(vendorName)) {
//			System.out.println("Vendor is created successfully");
//		} else {
//			System.out.println("Vendor is not created");
//		}
	}
	
	}
}
