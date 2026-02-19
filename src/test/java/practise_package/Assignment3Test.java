package practise_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3Test {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.worldometers.info/world-population/");
		String countryname = "Holy See";
		for (;;) {
			try {
				WebElement country = driver.findElement(By.xpath(
						"//h2[.='World Population by Country']/following-sibling::div[@class=\"not-prose\"]/descendant::a[contains(.,'"
								+ countryname + "')]"));
				country.click();
				break;
			} catch (RuntimeException e) {
				driver.findElement(By.xpath("//button[.='›']")).click();
			}
		}
		WebElement population = driver.findElement(By.xpath("//span[@class=\"rts-nr-int rts-nr-10e0\"]"));
		System.out.println(countryname + " : " + population.getText());
		String worldShare = driver.findElement(
			    By.xpath("//tr[td[normalize-space()='Holy See']]/td[last()]")
			).getText();

			System.out.println("World Share of Holy See: " + worldShare);

		Thread.sleep(1000);
		driver.quit();
	}
}