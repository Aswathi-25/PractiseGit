package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	
	//declaration
	@FindBy(xpath = "//img[@title='Create Vendor...']")
	private WebElement vendorLookUpImg;
	
	//initialization
	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

//utilization
	public WebElement getVendorLookUpImg() {
		return vendorLookUpImg;
	}
	
	public void clickOnVendorLookUpImg()
	{
		vendorLookUpImg.click();	}

}
