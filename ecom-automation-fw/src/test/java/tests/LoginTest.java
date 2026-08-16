package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.BaseTest;
import components.HeaderComponent;
import object_repository.LoginPage;
import object_repository.MyAccountPage;

public class LoginTest extends BaseTest{
	
	@Test(groups = {"smoke", "positive"})
	public void verifyValidLogin() {
		
		HeaderComponent header = new HeaderComponent(driver);
		
		LoginPage loginPage = header.openLoginPage();
		
		MyAccountPage accountPage = loginPage.login("one@yahoo.com", "786786");
		
		Assert.assertTrue(accountPage.isPageDisplayed(), "Account Page is not displayed");
		
	}
	
	@Test(groups = {"negative", "regression", "critical"})
	public void verifyInvalidPassword() {
		
		HeaderComponent header = new HeaderComponent(driver);
		
		LoginPage loginPage = header.openLoginPage();
		
		loginPage.login("one@yahoo.com", "wrongpass");
		
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed");	
		Assert.assertTrue(loginPage.isPageDisplayed(), "Login page is not displayed");
		
	}
	
	@Test(groups = {"negative", "regression"})
	public void verifyLoginWithEmptyPassword() {
		
		HeaderComponent header = new HeaderComponent(driver);
		
		LoginPage loginPage = header.openLoginPage();
		
		loginPage.enterEmail("one@yahoo.com").clickLogin();
		
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed");
		Assert.assertTrue(loginPage.isPageDisplayed(), "Login page is not displayed");
		
	}
}
