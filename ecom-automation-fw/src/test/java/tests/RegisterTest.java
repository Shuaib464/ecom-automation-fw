package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.BaseTest;
import components.HeaderComponent;
import object_repository.AccountCreationConfirmationPage;
import object_repository.LoginPage;
import object_repository.MyAccountPage;
import object_repository.RegisterPage;

public class RegisterTest extends BaseTest{
	
	@Test(groups = {"smoke", "positive"})
	public void verifyRegistrationWithCompulsaryFields() {
		
		HeaderComponent header = new HeaderComponent(driver);
		
		RegisterPage registerPage = header.openRegisterPage();
		
		String fname = "One" + (int)(Math.random() * 1000);
		String lname = "Singh" + (int)(Math.random() * 10);
		String email = fname + "@yahoo.com";
		String telephone = "9695367896";
		String password = "123456";
		
		AccountCreationConfirmationPage confirmPage = registerPage.registerWithCompulsary(fname, lname, email, telephone, password, password);
		
		// first validation
		Assert.assertEquals(confirmPage.getAccountCreationMessage(), "Your Account Has Been Created!", "Account Creation message does not match");
		
		MyAccountPage accountPage = confirmPage.clickContinueButton();
		
		Assert.assertTrue(accountPage.isPageDisplayed(), "Account Page is not displayed");
		
	}
	
}
