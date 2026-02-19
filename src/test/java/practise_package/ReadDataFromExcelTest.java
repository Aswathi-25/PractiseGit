package practise_package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	
	
	//identify the path of the excel file
	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
	
	//open the file
	Workbook wb = WorkbookFactory.create(fi);
	
	//get sheet
	Sheet sh = wb.getSheet("Sheet1");
	
	//get row
	Row row = sh.getRow(0);
	
	//get cell
	Cell cel = row.getCell(0);
	String company = cel.getStringCellValue();
	
	//get bangalore location
	String location = row.getCell(1).getStringCellValue();
	/*Whenever ur executing if there is no data present in the cell
	 * we will get NullPointerException
	 */
   
	System.out.println(company);
	System.out.println(location);
	 
	wb.close();
	
	
	
	}
	

}

