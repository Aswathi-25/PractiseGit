package Task;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TaskNowTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("chrome://history/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	    SearchContext host1 = driver.findElement(By.id("history-app")).getShadowRoot();
	    
	    SearchContext host2 = host1.findElement(By.cssSelector("#toolbar")).getShadowRoot();
	    
	    SearchContext host3 = host2.findElement(By.cssSelector("#mainToolbar")).getShadowRoot();
	    
	    SearchContext host4 = host3.findElement(By.cssSelector("cr-toolbar-search-field#search")).getShadowRoot();
	    
	    host4.findElement(By.cssSelector("#searchInput")).clear();
	    host4.findElement(By.cssSelector("#searchInput")).sendKeys("Aswathi",Keys.ENTER);

	 
		Thread.sleep(2000);		
		
		driver.quit();
		
		
		
		
	}

}
