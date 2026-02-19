package Assignments;

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



public class Assignment2_Broken_linksTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		
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
		act.scrollToElement(driver.findElement(By.xpath("//div[@class='widget Stats']"))).perform();
		
		
		//collecting all the links and storing it in a variable 
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='broken-links']//a"));
		
		for(WebElement link:links)
		{
			//getting href attribute value and storing it in a link
			String weblink = link.getAttribute("href");
			
			//converting String to url
			URL url = new URL(weblink);
			
			//typecasting to make a request and get response from the server
			//opening a connection/making request to the server
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			
			//getting the response and checking for response code
			if(http.getResponseCode()>=400)
			{
				System.out.println("Broken link"+url+"**********"+http.getResponseCode()+"*****"+http.getResponseMessage());
			}
			else
			{
				System.out.println("normal link"+url+"**********"+http.getResponseCode()+"*****"+http.getResponseMessage());
			}
		}
		
		
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
