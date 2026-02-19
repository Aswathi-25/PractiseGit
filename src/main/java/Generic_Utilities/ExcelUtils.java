package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	/**
	 * This method is used to read Single data from excel file
	 * 
	 * @author Aswathi
	 * @param sheetName
	 * @param rowNo
	 * @param CelNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String readDataFromExcel(String sheetName, int rowNo, int CelNo)
			throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(rowNo).getCell(CelNo).toString();
		return value;

	}

	/**
	 * this method is used to read multiple data from the excel
	 * 
	 * @author Aswathi
	 * @param sheetName
	 * @param rowNo
	 * @param CelNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public ArrayList<String> readMultipleDataFromExcel(String sheetName, int rowNo, int CelNo)
			throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		int celCount = sh.getRow(0).getLastCellNum();

		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i <= rowCount; i++) {
			for (int j = 0; j < celCount; j++) {
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				list.add(value);
			}
		}
		return list;

	}

	// -------------------------------------------------------------------------------

	/**
	 * this method is used to get the row count
	 * 
	 * @author userAswathi
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount;

	}

	// -----------------------------------------------------------------------------------

	/**
	 * this method is used to get the cell count
	 * 
	 * @author Aswathi
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRCelCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int CelCount = sh.getRow(0).getLastCellNum();
		return CelCount;

	}

	// -------------------------------------------------------------------------

	/**
	 * this method is used to write data into excel file
	 * 
	 * @author Aswathi
	 * @param sheetName
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName, String value) throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(0);
		Cell cel = row.createCell(0);
		cel.setCellType(CellType.STRING);
		cel.setCellValue(value);

		FileOutputStream fos = new FileOutputStream(IPathConstants.excelPath);

		wb.write(fos);
		wb.close();

	}
	
	/**
	 * @author Aswathi K E
	 * @param filePath
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	
	public static Object[][] readMultipleSetOfExcelData(String sheetName)
	        throws EncryptedDocumentException, IOException {

	    FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
	    Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
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


}
