package practise_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataIntoExcelMyPractise {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet3");
		
		Row row = sh.createRow(3);
		Cell cel1 = row.createCell(6);
		cel1.setCellValue("Anuvarshini");
		Cell cel2 = row.createCell(7);
		cel2.setCellValue("hi");
		
		
		/*because every time u write createRow(), everytime new row is created
		 * so the values gets deleted and the new passed value gets overridden
		 * 
		Row row = sh.createRow(0);
		Cell cel = row.createCell(1);
		cel.setCellValue("heloooo"); //overridden
		*/
		
		
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Testdata.xlsx");
		wb.write(fos);
		
		wb.close();
		
		
		
		
		
		
	}

}
