package practise_package;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment2_Broken_links {
	
	public static void main(String[] args) throws IOException {
		
		//launching the browser
		WebDriver driver = new ChromeDriver();
		
		//maximizing it
		driver.manage().window().maximize();
		
		//launching the appln
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//wait for page load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//scrolling the page
		Actions act = new Actions(driver);
		act.scrollToElement(driver.findElement(By.xpath("//h2[.='Visitors']"))).perform();
		
		//collecting all the links
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='broken-links']//a"));
		
		for(WebElement link:links)
		{
			String weblink = link.getAttribute("href");
			
			URL url = new URL(weblink);
			
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			
			if(http.getResponseCode()>=400)
			{
				System.out.println("Broken link"+url+"******"+http.getResponseMessage()+"*****"+http.getResponseCode());
			}
			else
			{
				System.out.println("normal link"+url+"******"+http.getResponseMessage()+"*****"+http.getResponseCode());
			}
			
			
		}
		
		
		
		
		
	}

}
