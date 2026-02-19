package Task;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PaginationWebTableTest {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement ele =  driver.findElement(By.xpath("//div[@class='widget Stats']"));
		
		String name = "Soundbar";
		boolean isFound = false;
		
		//scroll
		Actions act = new Actions(driver);
		act.scrollToElement(ele).perform();
		
		List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']//a"));
		
		for(WebElement page:pages)
		{
			page.click();
			Thread.sleep(1500);
			
			
			List<WebElement> products = driver.findElements(By.xpath("//table[@id='productTable']//tr/td[2]"));
			
		for(WebElement product:products)
		{
			if(product.getText().equalsIgnoreCase(name))
			{
				WebElement checkbox = product.findElement(By.xpath("./following-sibling::td[last()]/input"));
				
				if(!checkbox.isSelected())
				{
					checkbox.click();
				}
				
				String price = product.findElement(By.xpath("./following-sibling::td[1]")).getText();
				System.out.println("price:"+price);
				System.out.println("Product found and checkbox clicked");
				isFound = true;
				break;
			}
		}
		
		if(isFound)
		{
			break;
		}
		}
		if(!isFound)
		{
			System.out.println("Product not found in any of the pages");
		
		}
		
	Thread.sleep(2000);
	driver.quit();
		
	}

}
