package practise_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_OlympicsTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.bbc.com/sport/olympics");

        // Click Medal Results
        driver.findElement(By.xpath("//span[contains(text(),'Medal results')]")).click();
        
        WebElement dropdown = driver.findElement(By.id("discipline-selector"));

        // Select sport
        String name = "Artistic Gymnastics";
        Select sel = new Select(dropdown);
        sel.selectByVisibleText(name);

        // Get medal winners 
        List<WebElement> medals = driver.findElements(By.xpath("//div[@class=\"ssrcss-7dafha-DesktopNames e1dg50ic3\"]/div[contains(@class,'SecondaryName')]"));
        

        System.out.println("---- " + name + " ----");

        if (medals.size() >= 3) {
            System.out.println("Gold Medal: " + medals.get(0).getText());
            System.out.println("Silver Medal: " + medals.get(1).getText());
            System.out.println("Bronze Medal: " + medals.get(2).getText());
        } else {
            System.out.println("No medal available");
        }

        driver.quit();
    }
}
