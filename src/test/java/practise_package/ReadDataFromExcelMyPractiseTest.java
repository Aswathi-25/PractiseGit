package practise_package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//Excel -->Workbook-->Sheet-->Row-->Cell
public class ReadDataFromExcelMyPractiseTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		Workbook wb =  WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet2");
		
		int last_row = sh.getLastRowNum();
		int last_cell = sh.getRow(0).getLastCellNum();
		
		for(int i=0;i<=last_row;i++)
		{
			for(int j=0; j<last_cell; j++)
			{
				String datas = sh.getRow(i).getCell(j).toString();
				System.out.print(datas+ " ");
			}
			System.out.println();
		}
		
		
		
		wb.close();
		fis.close();
		
	}

}
