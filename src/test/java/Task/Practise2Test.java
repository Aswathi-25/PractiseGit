package Task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practise2Test {
	public static void main(String[] args) throws InterruptedException {
		
WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phones",Keys.ENTER);
		
		WebElement ele = driver.findElement(By.id("p_n_g-1003565058111-title"));
		
		Actions act = new Actions(driver);
		act.scrollToElement(ele).perform();
		
	WebElement checkbox = driver.findElement(By.xpath("//ul[@id='filter-p_n_g-1003517064111']//li[@id='p_n_g-1003517064111/51258698031']/descendant::i[@class='a-icon a-icon-checkbox']"));
		
		if(!checkbox.isSelected())
		{
			checkbox.click();
			
		}
		
		
		Thread.sleep(3000);
		driver.quit();
		
		
	}

}
