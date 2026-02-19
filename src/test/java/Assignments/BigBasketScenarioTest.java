package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigBasketScenarioTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bigbasket.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions act = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        // 0️⃣ Wait for page loader (if any)
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//*[contains(@class,'Loader')]")));
        } catch (Exception e) {
            // loader not present, ignore
        }


        // 1️⃣ Click / Hover “Shop by Category”
        WebElement shop = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(.,'Shop by Category')]")
                )
        );
        act.moveToElement(shop).click().perform();
        Thread.sleep(1000);


        // 2️⃣ Hover on first left column → “Electronics”
        WebElement electronics = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[contains(@class,'StyledMenuItems')]/li/a[contains(text(),'Electronics')]"))
        );
        act.moveToElement(electronics).perform();
        Thread.sleep(1000);


        // 3️⃣ Hover on next column → "Audio devices"
        WebElement audioDevices = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[contains(text(),'Audio devices')]"))
        );
        act.moveToElement(audioDevices).perform();
        Thread.sleep(1000);


        // 4️⃣ Capture ALL items in the 3rd column under Audio Devices
        List<WebElement> subList = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//a[contains(text(),'Audio devices')]/ancestor::ul/following-sibling::ul/li/a")
                )
        );


     
        for (WebElement ele : subList) {
            System.out.println(ele.getText());
        }


        driver.quit();
    }
}
