package Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

	/**
	 * This method is used to maximize the window
	 * 
	 * @author Aswathi
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to wait for page load
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param seconds
	 */
	public void waitForPageLoad(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	/**
	 * this method is used to wait until element is available on the webpage.
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param ele
	 * @param seconds
	 */
	public void waitUntilElementToBeVisible(WebDriver driver, WebElement ele, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	/**
	 * this method is used to wait until the element to be clickable
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param ele
	 * @param seconds
	 */
	public void waitUntilElementToBeClickable(WebDriver driver, WebElement ele, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	/**
	 * This method is used to select a value from dropdown using value
	 * 
	 * @author Aswathi
	 * @param element
	 * @param value
	 */
	public void dropdownUsingValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * this method is used to select a value from dropdown using its index
	 * 
	 * @author Aswathi
	 * @param element
	 * @param index
	 */
	public void dropdownUsingIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * this method is used to select a value from dropdown by using its visible text
	 * 
	 * @author Aswathi
	 * @param element
	 * @param text
	 */
	public void dropdownUsingVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * this method is used to create an Actions class and return the Actions
	 * variable
	 * 
	 * @author Aswathi
	 * @param driver
	 * @return
	 */
	public Actions actions(WebDriver driver) {
		Actions act = new Actions(driver);
		return act;
	}

	/**
	 * this method is used to move the cursor to the element/hover
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {
		actions(driver).moveToElement(element).perform();
	}

	/**
	 * this method is used to move the cursor to the particular element and click on
	 * that element
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAndClickOneEle(WebDriver driver, WebElement element) {
		actions(driver).moveToElement(element).click(element).perform();
	}

	/**
	 * this method is used to drag a particular element from source and drop it to
	 * the destination
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDropElement(WebDriver driver, WebElement source, WebElement target) {
		actions(driver).dragAndDrop(source, target);
	}

	/**
	 * this method is used to scroll the webpage
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollWebPage(WebDriver driver, int x, int y) {
		actions(driver).scrollByAmount(x, y).perform();
	}

	/**
	 * this method is used to scroll to a particular element
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param element
	 */
	public void scrollToParticularElement(WebDriver driver, WebElement element) {
		actions(driver).scrollToElement(element).perform();
	}

	/**
	 * this method is used to doubleclick on a particular element
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnThatElement(WebDriver driver, WebElement element) {
		actions(driver).doubleClick(element).perform();
	}

	/**
	 * This method is used to drag an element by x and y offsets
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param element
	 */
	public void dragAndDropBy(WebDriver driver, WebElement element, int x, int y) {
		actions(driver).dragAndDropBy(element, x, y).perform();
	}

	/**
	 * This method is used to right click on the web page
	 * 
	 * @author Aswathi
	 * @param driver
	 */
	public void rightClickOnWebPage(WebDriver driver) {
		actions(driver).contextClick().perform();
	}

	/**
	 * this method is used to right click on that particular element
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		actions(driver).contextClick(element).perform();
	}

	/**
	 * this method is used to click and hold on the particular element
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param element
	 */
	public void clickAndHold(WebDriver driver, WebElement element) {
		actions(driver).clickAndHold().perform();
	}

	/**
	 * this method is used to perform click , hold and release on an element
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param ele
	 */
	public void clickAndHoldAndRelease(WebDriver driver, WebElement ele) {
		actions(driver).clickAndHold(ele).release().perform();
	}

	/**
	 * this method is used to handle multiple windows
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param expTitle
	 */
	public void switchToWindow(WebDriver driver, String expTitle) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			String currwin = it.next();

			String actualTitle = driver.switchTo().window(currwin).getTitle();
			if (actualTitle.contains(expTitle)) 
			{
				break;
			}
		}
	}

	/**
	 * this method is used to switch back the control back to the parent window
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param ParentId
	 */
	public void switchToParentWindow(WebDriver driver, String ParentWindowHandle) {
		driver.switchTo().window(ParentWindowHandle);
	}

	// frames
	/**
	 * this method is used to switch to a frame using index
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param index
	 */
	public void switchToChildFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * this method is used to switch to a frame using name
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param name
	 */
	public void switchToChildFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	/**
	 * this method is used to switch to a frame using WebElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchToChildFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	// popups
	/**
	 * this method is used to accept the alert pop up window
	 * 
	 * @author Aswathi
	 * @param driver
	 */
	public void acceptAlertPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * this method is used to cancel the alert pop up window
	 * 
	 * @author Aswathi
	 * @param driver
	 */
	public void cancelAlertPopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * this method is used to get the text from the alert window
	 * 
	 * @author Aswathi
	 * @param driver
	 */
	public void getTextFromAlertPopup(WebDriver driver) {
		driver.switchTo().alert().getText();
	}

	/**
	 * this method is used to enter values into the textfield of alert window
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param value
	 */
	public void enterValueIntoAlertTextField(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	/**
	 * this method is used to typecast to JavascriptExecutor and return the value to
	 * the function
	 * 
	 * @author Aswathi
	 * @param driver
	 * @return
	 */
	public JavascriptExecutor javaScriptExecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	// javascripexecutor methods
	/**
	 * this method is sued to scroll the webpage using jse
	 * 
	 * @author Aswathi
	 * @param driver
	 */
	public void scrollHeight(WebDriver driver) {
		javaScriptExecutor(driver).executeScript("window.scrollBy(0,document.body.scrollHeight);");
	}

	// scroll till element
	/**
	 * this method is used to scroll until the element is visible
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param element
	 */
	public void scrollUntilEleIsVisibleUsingJSE(WebDriver driver, WebElement element) {
		javaScriptExecutor(driver).executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/**
	 * this method is used to click on a particular element using jse
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param element
	 */
	public void clickOnElementUsingJSE(WebDriver driver, WebElement element) {
		javaScriptExecutor(driver).executeScript("arguments[0].click()", element);
	}

	// sendkeys
	/**
	 * this method is used to send values to the text fields using jse
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param element
	 * @param value
	 */
	public void enterValueIntoTextField(WebDriver driver, WebElement element, String value) {
		javaScriptExecutor(driver).executeScript("arguments[0].value=arguments[1]", element, value);
	}

	/**
	 * this method is used to scroll to a particular element using x and y
	 * coordinates
	 * 
	 * @author Aswathi
	 * @param driver
	 * @param element
	 */
	public void scrollToEleUsingXYCoordinate(WebDriver driver, WebElement element) {
		Point loc = element.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		javaScriptExecutor(driver).executeScript("window.scrollBy(" + x + "," + y + ")");
	}

}
