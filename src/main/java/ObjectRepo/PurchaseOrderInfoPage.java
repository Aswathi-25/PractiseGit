package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static org.testng.Assert.*;

import Generic_Utilities.WebDriverUtils;

public class PurchaseOrderInfoPage extends WebDriverUtils {
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement purOrdHeader;
	
	//initialization
	public PurchaseOrderInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPurOrdHeader() {
		return purOrdHeader;
	}

	
	//business library
			public void validatingPurchaseOrder(WebDriver driver, String purOrderName)
			{
				
			    waitUntilElementToBeVisible(driver, purOrdHeader, 10);
				String header = purOrdHeader.getText();
				
				assertTrue(header.contains(purOrderName),
						"Purchase Order is not created");

				    // Success message → console + TestNG report
				    Reporter.log("Purchase Order is created successfully",true);
				
				
				
				
				// validating whether actual and expected result is same or not
//				if (header.contains(purOrderName)) {
//					System.out.println("Purchase Order is created successfully");
//				} else {
//					System.out.println("Purchase Order is not created");
//				}
			}
	}

