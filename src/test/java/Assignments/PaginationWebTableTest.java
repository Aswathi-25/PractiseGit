package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PaginationWebTableTest {
	public static void main(String[] args) throws InterruptedException {
		
		//launching browser
		WebDriver driver = new ChromeDriver();
		
		//maximize the browser window
		driver.manage().window().maximize();
		
		//wait for page load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//launch appln
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement ele = driver.findElement(By.xpath("//div[@class='widget Stats']"));
		
		//scroll until pagination web table is visible
		Actions act = new Actions(driver);
		act.scrollToElement(ele).perform();
		
		String productName = "Soundbar";

		while (true) {

		    // try to find product in current page
		    List<WebElement> product =
		            driver.findElements(By.xpath(
		                    "//table[@id='productTable']//td[.='" + productName + "']"));

		    // if found
		    if (product.size() > 0) {

		        driver.findElement(By.xpath(
		                "//table[@id='productTable']//td[.='" + productName + "']/preceding-sibling::td//input"))
		              .click();

		        System.out.println(productName + " checkbox clicked");
		        break;
		    }

		    // product NOT found → go to next page
		    WebElement nextBtn = driver.findElement(By.id("pagination-next"));

		    if (nextBtn.getAttribute("class").contains("disabled")) {
		        System.out.println(productName + " not found in any page");
		        break;
		    }

		    nextBtn.click();   // THIS moves to page 2
		}

		
		
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
		
	}
	

}
