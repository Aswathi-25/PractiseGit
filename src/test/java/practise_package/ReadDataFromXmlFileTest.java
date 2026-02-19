package practise_package;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXmlFileTest {
	
	@Test
	public void readXMLfile(XmlTest test)
	{
		System.out.println(test.getParameter("browser"));
		System.out.println(test.getParameter("url"));
		System.out.println(test.getParameter("username"));
		System.out.println(test.getParameter("password"));
	}

}
