package Task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task2Test {

	public static void main(String[] args) throws InterruptedException {

		// launching the chrome browser
		WebDriver driver = new ChromeDriver();

		// maximizing the browser
		driver.manage().window().maximize();

		// launching the application
		driver.get("https://testautomationpractice.blogspot.com/");

		// wait for page load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// using Actions class to scroll to a particular element till pagination
		// webTable is visible
		Actions act = new Actions(driver);
		act.scrollToElement(driver.findElement(By.xpath("//div[@class='widget Stats']"))).perform();

		String name = "Soundbar";

		// since my desired product name is in page 4 navigating to page 4
		driver.findElement(By.xpath("//a[.='4']")).click();

		String name1 = "Soundbar";

		// finding the row containing 'Soundbar'
		WebElement row = driver.findElement(By.xpath("//table[@id='productTable']//tr/td[.= '" + name1 + "']"));

		// printing the price in the console
		String price = row
				.findElement(By.xpath("//table[@id='productTable']/tbody/tr/td[.='Soundbar']/following-sibling::td[1]"))
				.getText();

		System.out.println(price);

		// finding the checkbox of that particular element
		WebElement checkbox = row.findElement(By.xpath("//table[@id='productTable']//tr/td[.='" + name1
				+ "']/following-sibling::td[last()]/input[@type='checkbox']"));

		// checking whether the checkbox is not selected
		if (!checkbox.isSelected()) {

			// if the checkbox is not selected selecting the checkbox
			checkbox.click();
		}

		Thread.sleep(2000);

		driver.quit();
	}
}
