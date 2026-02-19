package practise_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PractiseTest1 {
	public static void main(String[] args) {
		
	
	
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://www.bbc.com/sport/olympics/paris-2024/medals");
	
	driver.findElement(By.xpath("//span[text()='Medal results']")).click();
	
	WebElement dropdown = driver.findElement(By.id("discipline-selector"));
	
	String sport = "Artistic Swimming";
	Select sel = new Select(dropdown);
	sel.selectByVisibleText(sport);
	
	driver.findElement(By.xpath("//select[@id='discipline-selector']/option[text()='"+sport+"']")).click();
	
	
	

	
	
	
	}
	
}
