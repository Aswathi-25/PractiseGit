package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment3_shadow_domTest {
	public static void main(String[] args) throws InterruptedException {
		
		//launching the browser
				WebDriver driver = new ChromeDriver();
				
				//maximizing the browser
				driver.manage().window().maximize();
				
				//launching appln
				driver.get("https://testautomationpractice.blogspot.com/");
				
				//wait for page load
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//scroll to particular element
				Actions act = new Actions(driver);
				act.scrollToElement(driver.findElement(By.xpath("//h2[.='Footer Links']"))).perform();
				
				//identifying the host
				SearchContext host = driver.findElement(By.id("shadow_host")).getShadowRoot();
				
				//from the host locating the web element and performing action on it
				WebElement ele = host.findElement(By.cssSelector("input[type='text']"));
				
				ele.sendKeys("Aswathi");
				
				WebElement ele2 = host.findElement(By.cssSelector("input[type='checkbox']"));
				
				ele2.click();
	
				 host.findElement(By.cssSelector("input[type='file']")).sendKeys("C:\\Users\\user\\OneDrive\\Desktop\\SELENIUM ADVANCES NOTES.txt");
				
				Thread.sleep(2000);
				driver.quit();
				
	}

}
