package practise_package;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDataFromPropertyFileTest {
	public static void main(String[] args) throws IOException {
		
		//step1: create object for physicalrepresentation of file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
	
	
	    //step2:create object for properties class
		Properties pObj = new Properties();
		
		//step3: load all the keys
		pObj.load(fis);
		
		//step4: fetch the values using "getProperty" method
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//step5: print the values
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		//launch the browser
		WebDriver driver = null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		 driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		//to maximize the window
		driver.manage().window().maximize();
		
		//enter the url
		driver.get(URL);
		
		//for page load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//enter valid username and password and click on login button
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	
	}

}
