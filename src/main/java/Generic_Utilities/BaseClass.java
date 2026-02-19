
package Generic_Utilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;

public class BaseClass {

	public DatabaseUtils dbutls = new DatabaseUtils();
	public FileUtils futls = new FileUtils();
	public ExcelUtils eutls = new ExcelUtils();
	public JavaUtils jutls = new JavaUtils();
	public WebDriverUtils wutls = new WebDriverUtils();

	public WebDriver driver;
	//only ThreadLocal driver
	public static ThreadLocal<WebDriver> wdriver = new ThreadLocal<>();
	
	//getter method
//	public static WebDriver getDriver() {
//	    return driver.get();
//	}


	@BeforeSuite(alwaysRun = true)
	public void connectToDb() throws SQLException {
		//// dbutls.connectToDB();
		System.out.println("----connected to DB-----");
	}

	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(/*String BROWSER*/) throws IOException {
		String BROWSER = futls.readDataFromPropertyFile("browser");
		String URL = futls.readDataFromPropertyFile("url");
		
		//WebDriver localDriver = null;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\Aswathi K E\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		wdriver.set(driver);

		// maximize window
		wutls.maximizeWindow(driver);

		// navigate to appln
		driver.get(URL);

		// wait for page load
		wutls.waitForPageLoad(driver, 10);

		System.out.println("-------browser launched successfully--------");

	}

	@BeforeMethod(alwaysRun = true)
	public void loginToAppln() throws IOException {
		String USERNAME = futls.readDataFromPropertyFile("username");
		String PASSWORD = futls.readDataFromPropertyFile("password");
		
		
		
		LoginPage lp = new LoginPage(driver);
        lp.loginToApplication(USERNAME, PASSWORD);
        
		System.out.println("----------logged into appln---------");
	}

	@AfterMethod(alwaysRun = true)
	public void logoutFromAppln() {
		HomePage hp = new HomePage(driver);
		hp.signOutApplication(driver);
		System.out.println("-----logged out from appln------");

	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		//driver.remove(); 
		System.out.println("----browser closed---");
	}

	@AfterSuite(alwaysRun = true)
	public void disconnectFromDB() throws SQLException {
		// dbutls.disconnectDB();
		System.out.println("-------disconnected from db-------");
	}

}
