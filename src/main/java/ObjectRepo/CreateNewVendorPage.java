package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {
	
	@FindBy(name="vendorname")
	private WebElement venName;
	
	
	@FindBy(id="email")
	private WebElement venEmail;
	

	@FindBy(id="phone")
	private WebElement venPhone;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	public CreateNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getVenName() {
		return venName;
	}


	public WebElement getVenEmail() {
		return venEmail;
	}


	public WebElement getVenPhone() {
		return venPhone;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}

public void createVendor(String vendorName, String emailfield, String ph)
{
	venName.clear();
	venName.sendKeys(vendorName);
	venEmail.clear();
	venEmail.sendKeys(emailfield);
	venPhone.clear();
	venPhone.sendKeys(ph);
	saveBtn.click();
	
}
	
	
}
