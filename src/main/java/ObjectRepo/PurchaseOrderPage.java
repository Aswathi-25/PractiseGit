package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage {
	
	//declaration
	@FindBy(xpath = "//img[@title='Create Purchase Order...']")
	private WebElement purOrdLookUpImg;
	
	
	//initialization
	public PurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
	//utilization
	public WebElement getPurOrdLookUpImg() {
		return purOrdLookUpImg;
	}
	
public void clickOnPurchaseOrder()
{
	purOrdLookUpImg.click();
}
	
}
