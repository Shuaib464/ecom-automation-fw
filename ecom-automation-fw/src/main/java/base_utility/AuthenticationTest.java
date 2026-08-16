package base_utility;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;

import components.HeaderComponent;
import generic_utility.FileUtility;
import object_repository.LoginPage;

public class AuthenticationTest extends BaseTest{
	
	@BeforeMethod
	public void login() throws IOException {
		
		String EMAIL = FileUtility.getDataFromPropertiesFile("un");
		String PASSWORD = FileUtility.getDataFromPropertiesFile("pwd");
		
		HeaderComponent header = new HeaderComponent(driver);
		
		
		LoginPage loginPage = header.openLoginPage();
		loginPage.login(EMAIL, PASSWORD);
	}
	
}
