package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	//declarations
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement orgLookUpImg;
	
//	@FindBy(xpath = "//table[@class='lvt small']//tr[@class='lvtColData']/td/a[@title='Organizations']")
//	private List<WebElement> listOfOrgNames;
	

	//initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}


//	public List<WebElement> getListOfOrgNames() {
//		return listOfOrgNames;
//	}

    
	//business logic
	public void clickOnCreateOrgLookUp()
	{
		orgLookUpImg.click();
	}
	
//	public void getListOfOrganizationNames()
//	{
//		for(WebElement orgName:listOfOrgNames)
//		{
//			System.out.println(orgName.getText());
//		}
//	}
	
	

}
