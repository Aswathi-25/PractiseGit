package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriverUtils;

public class CreateNewOppurtunityPage extends WebDriverUtils {

    // declarations
    @FindBy(name = "potentialname")
    private WebElement oppurName;

    @FindBy(xpath = "//input[@id='related_to_display']/following-sibling::img")
    private WebElement orgLookUp;

    // child window of Organization Field
    @FindBy(id = "search_txt")
    private WebElement searchTxtField;

    @FindBy(name = "search")
    private WebElement searchNowBtn;

    @FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;

    @FindBy(name = "closingdate")
    private WebElement closeDate;

    // initialization
    public CreateNewOppurtunityPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // utilization
    public WebElement getOppurName() {
        return oppurName;
    }

    public WebElement getOrgLookUp() {
        return orgLookUp;
    }

    public WebElement getSearchTxtField() {
        return searchTxtField;
    }

    public WebElement getSearchNowBtn() {
        return searchNowBtn;
    }

    public WebElement getSaveBtn() {
        return saveBtn;
    }

    public WebElement getCloseDate() {
        return closeDate;
    }

    // business library
    public void createOppurtunity(String oppName, String orgName, String closingDateValue, WebDriver driver) {
        oppurName.clear();
        oppurName.sendKeys(oppName);

        closeDate.clear();
        closeDate.sendKeys(closingDateValue);

        orgLookUp.click();

        switchToWindow(driver, "Accounts&action");

        searchTxtField.clear();
        searchTxtField.sendKeys(orgName);
        searchNowBtn.click();

        driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

        switchToWindow(driver, "Potentials&action");

        saveBtn.click();
    }
}
