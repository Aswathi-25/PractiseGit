package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4Test {
	
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
		act.scrollToElement(driver.findElement(By.xpath("//h2[.='SVG Elements']"))).perform();
		
		WebElement ele1 = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
		
		WebElement ele2 = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
		
		act.clickAndHold(ele1).moveByOffset(15, 0).release().build().perform();
		
		WebDriverWait ew = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		ew.until(ExpectedConditions.elementToBeClickable(ele2));
		
		act.clickAndHold(ele2).moveByOffset(59, 0).release().build().perform();		
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
