package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.AuthenticationTest;
import base_utility.BaseTest;
import components.HeaderComponent;
import object_repository.AccountCreationConfirmationPage;
import object_repository.LoginPage;
import object_repository.MyAccountPage;
import object_repository.RegisterPage;
import object_repository.SearchPage;

public class SearchProductTest extends AuthenticationTest{
	
	
	@Test(groups = {"smoke", "positive"})
	public void verifySearchProduct() {
		
		HeaderComponent header = new HeaderComponent(driver);
		
		String keyword = "phone";
		
		SearchPage searchpage = header.searchProduct(keyword);
		
		List<WebElement> totalProducts = searchpage.getTotalProductCards();
		
		//first validation
		Assert.assertEquals(searchpage.getSearchHeading(), "Search - "+ keyword);
		
		// second validation
		if(totalProducts.size() > 0)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false, "No products are displayed");
		
		
	}
	
	/*
	@Test(groups = {"negative", "regression"})
	public void verifySearchWithInvalidKeyword() {
		
		HeaderComponent header = new HeaderComponent(driver);
		
		String keyword = "@#@";
		
		SearchPage searchpage = header.searchProduct(keyword);
		
		//first validation
		Assert.assertEquals(searchpage.getSearchHeading(), "Search - "+ keyword);
		
		// second validation
		Assert.assertTrue(searchpage.isNoProductMessageDisplayed(), "No matching product message is not displayed");
		
		
	}
	*/
	
}
