package Testng_practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.ExcelUtils;

public class DP_genericTest {
	
	@Test(dataProvider = "getData")
	public void execute(String staffs, String subjects)
	{
		
		System.out.println(staffs+"---->"+subjects);
	}


@DataProvider
public Object[][] getData() throws EncryptedDocumentException, IOException
{
	ExcelUtils eutls = new ExcelUtils();
	Object[][] value = eutls.readMultipleSetOfExcelData("DataProvider");
	
	return value;
}
}