package practise_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment1_AutoTestPracWebTableTest {
	public static void main(String[] args) throws InterruptedException {
		
		String name = "Portable Charger";
		
		//launching the chrome browser
		WebDriver driver = new ChromeDriver();
		
		//maximizing the browser
		driver.manage().window().maximize();
		
		//launching the appln
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//wait for page load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//using Actions class to scroll to a particular element
		Actions act = new Actions(driver);
		act.scrollToElement(driver.findElement(By.xpath("//div[@class='widget Stats']"))).perform();
		
		//since my desired product name is in page 3 navigating to page 3
		
        driver.findElement(By.xpath("//a[.='3']")).click();
        
        //finding the row containing 'Portable Charger'
       WebElement row =  driver.findElement(By.xpath("//table[@id='productTable']//tr/td[.= '"+name+"']"));
		
		//finding the checkbox of that particular element
       WebElement checkbox = row.findElement(By.xpath("//table[@id='productTable']//tr/td[.='"+name+"']/following-sibling::td[last()]/input[@type='checkbox']"));
	    
       
       //checking whether the checkbox is not selected
       if(!checkbox.isSelected())
       {
    	   //if not selected then selecting
    	   checkbox.click();
       }
       
      
       
		Thread.sleep(5000);
		driver.quit();
		
		
		
	}

	}

