package practise_package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelTest {

    public static void main(String[] args) throws EncryptedDocumentException, IOException {

        FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");

        Workbook wb = WorkbookFactory.create(fi);

        Sheet sh = wb.getSheet("Sheet2");

        // total number of rows
        int lastRow = sh.getLastRowNum();  // FIXED
       

        //apply for loop to read all the data
        for (int i = 0; i <= lastRow; i++) {

            String company = sh.getRow(i).getCell(0).toString();
            String location = sh.getRow(i).getCell(1).toString();

            System.out.println(company + " " + location);
        }

        wb.close();
    }
}
