package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriceBooksPage {
	
	@FindBy(xpath = "//img[@title='Create Price Book...']")
	private WebElement priceBooksLookUpImg;
	
	
	
	public PriceBooksPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	

public WebElement getPriceBooksLookUpImg() {
		return priceBooksLookUpImg;
	}




public void clickOnPriceBooksLookUp()
{
	priceBooksLookUpImg.click();
	
}
	
	

}
