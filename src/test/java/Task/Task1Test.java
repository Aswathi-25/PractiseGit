package Task;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task1Test {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions act = new Actions(driver);
        act.scrollToElement(driver.findElement(By.id("productTable"))).perform();

        String productName = "Soundbar";
        boolean isFound = false;

        // get all page number links (1,2,3,4)
        List<WebElement> pages = driver.findElements(
                By.xpath("//ul[@id='pagination']//a"));

        for (WebElement page : pages) {

            page.click();
            Thread.sleep(1500); // wait for table refresh

            // get product names in current page
            List<WebElement> rows = driver.findElements(
                    By.xpath("//table[@id='productTable']//tr/td[1]"));

            for (WebElement row : rows) {

                if (row.getText().equalsIgnoreCase(productName)) {

                    WebElement checkbox = row.findElement(
                            By.xpath("./following-sibling::td[last()]/input"));

                    if (!checkbox.isSelected()) {
                        checkbox.click();
                    }

                    System.out.println(productName + " found and checkbox clicked");
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                break;
            }
        }

        if (!isFound) {
            System.out.println(productName + " not found in any page");
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
