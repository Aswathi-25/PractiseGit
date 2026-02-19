package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static org.testng.Assert.*;

public class ProductInfoPage {
	

	//declaration
		@FindBy(xpath = "//span[@class='lvtHeaderText']")
		private WebElement productConfirmHeader;
		
		
		//initialization
		public ProductInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}



		public WebElement getProductConfirmHeader() {
			return productConfirmHeader;
		}
		
		
		//business library
		public void validatingProduct(String proName)
		{
			String header = productConfirmHeader.getText();
			
			
			assertTrue(header.contains(proName), "Product is not created");
			
			
			Reporter.log("Product is created successfully");
			// validating whether actual and expected result is same or not
//			if (header.contains(proName)) {
//				System.out.println("Product is created successfully");
//			} else {
//				System.out.println("Product is not created");
//			}
		}




		

	}

	


