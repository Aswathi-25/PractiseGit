package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	
	@FindBy(name="productname")
	private WebElement proName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	

	public WebElement getProName() {
		return proName;
	}



	public WebElement getSaveBtn() {
		return saveBtn;
	}



	public void createProduct(String pro_name)
	{
		proName.clear();
		proName.sendKeys(pro_name);
		saveBtn.click();
	}
	
}


