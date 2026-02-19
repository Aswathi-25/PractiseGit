package Testng_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTest {
	
	@Test
	public void m1()
	{
		System.out.println("-------step-1--------");
		System.out.println("-------step-2--------");
		Assert.assertEquals("A", "B", "my validation fails");
		System.out.println("-------step-3--------");
		System.out.println("-------step-4-------");
	}
	
	@Test
	public void m2()

	{
		System.out.println("-------step-1--------");
		System.out.println("-------step-2--------");
		Assert.assertNotEquals("A", "B");
		System.out.println("-------step-3--------");
		System.out.println("-------step-4-------");

		
	}
	
	@Test
	public void m3()
	{
		int a = 10;
		System.out.println("-------step-5--------");
		System.out.println("-------step-6--------");
		Assert.assertNull(a);
		System.out.println("-------step-7--------");
		System.out.println("-------step-8-------");
	}
	
	@Test
	public void validation()
	{
		String exp = "vtiger CRM";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		String title = driver.getTitle();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
