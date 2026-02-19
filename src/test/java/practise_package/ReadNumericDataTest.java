package practise_package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadNumericDataTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet("Sheet2");
		
		Cell cel = sh.getRow(0).getCell(2);
		
		 DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(cel);
		
		System.out.println(value);
	}

}
