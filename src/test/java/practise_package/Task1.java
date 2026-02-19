package practise_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//input[@name='q']")).clear();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("mobile",Keys.ENTER);
		
		
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='RG5Slk']"));
		
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='hZ3P6w DeU9vF']"));
		
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet5");
		 
		
		
//		for(WebElement name:names)
//		{
//			String data1 = name.getText();
//			
//			sh.createRow(0).createCell(0);
//			Cell cel = row.createCell(0);
//			cel.setCellValue(data);
//			
//			System.out.println(data);
//			
//		}
//		
			FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Testdata.xlsx");
			wb.write(fos);
			
			wb.close();
			
		}
	
	}



