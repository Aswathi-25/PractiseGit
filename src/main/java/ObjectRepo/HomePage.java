package ObjectRepo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic_Utilities.WebDriverUtils;

public class HomePage extends WebDriverUtils {
	
	private WebDriver driver;
	
	//declaration
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement oppurLink;
	
	@FindBy(linkText = "Products")
	private WebElement prodLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campLink;
	
	@FindBy(linkText="Purchase Order")
	private WebElement purOrdLink;
	
	@FindBy(linkText="Price Books")
	private WebElement priceBooksLink;
	
	@FindBy(linkText="Vendors")
	private WebElement venLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminbtn;
	
	@FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']")
	private WebElement signOutLink;
	
	
	
	//initialization
	public HomePage(WebDriver driver)
	{
		this.driver = driver;  
		PageFactory.initElements(driver, this);
		
	}


	//utilization
	public WebElement getOrgLink() {
		return orgLink;
	}



	public WebElement getContLink() {
		return contLink;
	}



	public WebElement getOppurLink() {
		return oppurLink;
	}



	public WebElement getProdLink() {
		return prodLink;
	}



	public WebElement getMoreLink() {
		return moreLink;
	}



	public WebElement getCampLink() {
		return campLink;
	}



	public WebElement getPurOrdLink() {
		return purOrdLink;
	}



	public WebElement getPriceBooksLink() {
		return priceBooksLink;
	}



	public WebElement getVenLink() {
		return venLink;
	}



	public WebElement getAdminbtn() {
		return adminbtn;
	}



	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	
	//business library
	public void clickOnOrganizationsLink()
	{
		orgLink.click();
	}
	
	public void clickOnContactsLink()
	{
		contLink.click();
	}
	
	public void clickOnOppurtunitiesLink()
	{
		oppurLink.click();
	}
	
	public void clickOnProductsLink()
	{
		prodLink.click();
	}
	public void clickOnMoreLink()
	{
		moreLink.click();
	}
	
	public void clickOnCampaignsLink()
	{
		campLink.click();
	}
	
	public void clickOnPurchaseOrderLink()
	{
		purOrdLink.click();
	}
	public void clickOnPriceBooksLink()
	{
		priceBooksLink.click();
	}
	
	public void clickOnVendorsLink()
	{
		venLink.click();
	}
	
	public void signOutApplication(WebDriver driver)
	{
		adminbtn.click();
		waitUntilElementToBeVisible(driver, signOutLink, 10);
		clickOnElementUsingJSE(driver, signOutLink);

	    
	}


}
