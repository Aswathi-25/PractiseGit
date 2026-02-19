package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static org.testng.Assert.*;

public class PriceBooksInfoPage {
	

	//declaration
		@FindBy(xpath = "//span[@class='lvtHeaderText']")
		private WebElement priceBookConfirmHeader;
		
		
		//initialization
		public PriceBooksInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}


		//utilization
		public WebElement getPriceBooksHeader() {
			return priceBookConfirmHeader;
		}
		
		//business library
		public void validatingPriceBook(String priceBookName)
		{
			String header = priceBookConfirmHeader.getText();
			
			assertTrue(header.contains(priceBookName), "PriceBook is not created");
			
			Reporter.log("PriceBook is created successfully");
			// validating whether actual and expected result is same or not
//			if (header.contains(priceBookName)) {
//				System.out.println("PriceBook is created successfully");
//			} else {
//				System.out.println("PriceBook is not created");
//			}
		}
		

	}

	


