package LoginModule;

import java.io.IOException;

import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import ObjectRepo.LoginValidationPage;

public class LoginModuleOfVtigerCRMTest extends BaseClass {

	@Test(groups = "smoke")
	public void LoginModuleOfVtigerCRMTest() throws IOException, InterruptedException {

		// login validation
		LoginValidationPage lvp = new LoginValidationPage(driver);
		lvp.validatingLogin(driver);

	}

}
