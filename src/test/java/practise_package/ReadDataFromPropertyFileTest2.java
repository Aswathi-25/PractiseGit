package practise_package;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromPropertyFileTest2 {

    public static void main(String[] args) throws EncryptedDocumentException, IOException {

        FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
        Workbook wb = WorkbookFactory.create(fi);
        Sheet sh = wb.getSheet("Sheet2");

        int lastRow = sh.getLastRowNum();
        int lastCell = sh.getRow(0).getLastCellNum();

        // Outer loop here use <= 
        for (int i = 0; i <= lastRow; i++) {

            // Inner loop here use only <, mouseover and see it is 0+1
            for (int j = 0; j < lastCell; j++) {

            	// String data = sh.getRow(i).getCell(j).getStringCellValue();
            	/*so here u want to go into excel and give the numeric value
            	 * as ' before start so it will be a String
            	 *
            	 */
                String data = sh.getRow(i).getCell(j).toString();
                System.out.print(data + "  ");   // print in same line
            }

            System.out.println();  // move to next row
        }

        wb.close();
    }
}
