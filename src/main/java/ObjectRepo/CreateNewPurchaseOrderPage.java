package ObjectRepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import Generic_Utilities.WebDriverUtils;

public class CreateNewPurchaseOrderPage extends WebDriverUtils {

	@FindBy(name="subject")
	private WebElement subject;
	
	@FindBy(xpath = "//input[@name='vendor_id']/following-sibling::img")
	private WebElement venNameLookUpField;
	
	
	
	//childwindow elements
	 
	@FindBy(id="search_txt")
	private WebElement searchTxtField;
	
	@FindBy(name="search")
	private WebElement searchNowBtn;
	
	@FindBy(name="bill_street")
	private WebElement bill_add;
	
	@FindBy(xpath = "//input[@name='cpy' and @onclick='return copyAddressRight(EditView)'] ")
	private WebElement copyBillAddRadioBtn;
	
	@FindBy(xpath = "//input[@id='productName1']/following-sibling::img")
	private WebElement itemNameLookUp;
	
	
	@FindBy(id="qty1")
	private WebElement itemqty;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateNewPurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getSubject() {
		return subject;
	}

	public WebElement getVenNameLookUpField() {
		return venNameLookUpField;
	}

	public WebElement getSearchTxtField() {
		return searchTxtField;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getBill_add() {
		return bill_add;
	}

	public WebElement getCopyBillAddRadioBtn() {
		return copyBillAddRadioBtn;
	}

	public WebElement getItemNameLookUp() {
		return itemNameLookUp;
	}

	public WebElement getItemqty() {
		return itemqty;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createPurchaseOrder(
	        WebDriver driver,
	        String sub,
	        String venName,
	        String proName,
	        String billingAddress,
	        String qty) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // Subject
	    subject.clear();
	    subject.sendKeys(sub);

	    // Vendor
	    venNameLookUpField.click();
	    switchToWindow(driver, "Vendors&action");
	    

	    wait.until(ExpectedConditions.visibilityOf(searchTxtField)).sendKeys(venName);
	    searchNowBtn.click();
	    wait.until(ExpectedConditions.elementToBeClickable(
	            driver.findElement(By.xpath("//a[normalize-space()='" + venName + "']"))
	    )).click();

	    switchToWindow(driver, "PurchaseOrder&action");

	    // Product
	    itemNameLookUp.click();
	    switchToWindow(driver, "Products&action");

	    wait.until(ExpectedConditions.visibilityOf(searchTxtField)).sendKeys(proName);
	    searchNowBtn.click();
	    wait.until(ExpectedConditions.elementToBeClickable(
	            driver.findElement(By.xpath("//a[normalize-space()='" + proName + "']"))
	    )).click();

	    switchToWindow(driver, "PurchaseOrder&action");

	    // Quantity
	    wait.until(ExpectedConditions.visibilityOf(itemqty)).sendKeys(qty);

	    // Billing Address
	    wait.until(ExpectedConditions.visibilityOf(bill_add)).sendKeys(billingAddress);
	    
	    copyBillAddRadioBtn.click();

	    // Save
	    wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();

	    // Alert handling
	    try {
	        acceptAlertPopup(driver);
	    } catch (Exception e) {
	    }
	}

}