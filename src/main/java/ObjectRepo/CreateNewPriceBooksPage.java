package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewPriceBooksPage {
	
	@FindBy(name="bookname")
	private WebElement bookName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewPriceBooksPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getBookName() {
		return bookName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createPriceBook(String book_name)
	{
		bookName.clear();
		bookName.sendKeys(book_name);
		saveBtn.click();
	}
	
}
