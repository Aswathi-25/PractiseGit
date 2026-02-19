package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1_withforloopTest {
    public static void main(String[] args) throws InterruptedException {
        
        String targetName = "Portable Charger";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        // Click on Page 3
        driver.findElement(By.xpath("//a[.='3']")).click();

        // Get all rows from the table
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));

        for (WebElement row : rows) {
            
            // First column = product name
            String productName = row.findElement(By.xpath("./td[1]")).getText();

            if (productName.equals(targetName)) {

                // Checkbox is the last column
                WebElement checkbox = row.findElement(By.xpath("./td[last()]/input"));

                checkbox.click();

                System.out.println("Clicked checkbox for: " + productName);
                break;
            }
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
