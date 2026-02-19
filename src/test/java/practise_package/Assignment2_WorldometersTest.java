package practise_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment2_WorldometersTest {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// launch appln
		driver.get("https://www.worldometers.info/geography/countries-of-the-world/");

		// click on More dropdown
		driver.findElement(By.xpath("//button[@id='menu-button-5']")).click();

		// in that dropdown select Food and Agriculture
		driver.findElement(By.xpath("//a[contains(.,'Food & Agriculture') and @id='item-11']")).click();

		// write a dynamic xpath for india it should work for all countries
		String name = "India";
		driver.findElement(By.xpath("//li/a[normalize-space()='" + name + "']")).click();

		// scroll to graph
		WebElement graph = driver.findElement(By.xpath("//*[name()='svg' and contains(@class,'highcharts')]"));
		Actions act = new Actions(driver);
		act.scrollToElement(graph).perform();

		// getting all the tooltip points
		List<WebElement> points = driver.findElements(By.xpath(
				"//*[name()='svg']//*[name()='path' and contains(@class,'highcharts-point') and (@fill='#FF3300')]"));

		for (WebElement point : points) {
			act.moveToElement(point).perform();
			Thread.sleep(800);

			WebElement tooltipText = driver.findElement(
					By.xpath("//*[name()='g' and contains(@class,'highcharts-tooltip')]//*[name()='text']"));

			// printing the tool tip text
			System.out.println(tooltipText.getText());

		}
		driver.quit();
	}
}