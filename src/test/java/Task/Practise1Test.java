package Task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise1Test {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung phones",Keys.ENTER);
		
		
		
	String price =	driver.findElement(By.xpath("//div[@data-cy='price-recipe']/descendant::span[@class='a-price-whole']")).getText();
	System.out.println(price);
		
		
		
		
Thread.sleep(2000);
driver.quit();
		
		
	}

}
