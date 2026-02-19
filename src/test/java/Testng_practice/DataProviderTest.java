package Testng_practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataProviderTest {
	
	@DataProvider(name = "staff_subjects")
	public Object[][] excelData() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TEST_DATA_FOR_FRAMEWORK.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DataProvider");
		int rowCount = sh.getLastRowNum()+1;
		int celCount = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowCount][celCount];
		
		for(int i =0; i<rowCount; i++)
		{
			for(int j=0; j<celCount; j++)
			{
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@DataProvider(name = "credentials")
	public Object[][] storeData() {
		Object[][] obj = new Object[2][2];

		obj[0][0] = "admin";
		obj[0][1] = "admin";

		obj[1][0] = "admin";
		obj[1][1] = "root";
		return obj;
	}
	
	@DataProvider(name = "store-products")
	public Object[][] products()
	{
		Object[][] obj = new Object[3][2];

		obj[0][0] = "laptop";
		obj[0][1] = 3000;

		obj[1][0] = "samsung";
		obj[1][1] = 5000;
		

		obj[2][0] = "redmi";
		obj[2][1] = 7000;
		
		
		return obj;
	}

}
