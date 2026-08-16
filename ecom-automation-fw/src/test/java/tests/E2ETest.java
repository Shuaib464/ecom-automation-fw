package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.BaseTest;
import components.HeaderComponent;
import components.ProductCardComponent;
import generic_utility.FileUtility;
import object_repository.CartPage;
import object_repository.LoginPage;
import object_repository.MyAccountPage;
import object_repository.SearchPage;

public class E2ETest extends BaseTest{
	
	@Test(groups = {"E2E", "regression"})
	public void verifyLoginToAddCart() throws IOException {
		
		// login 
		HeaderComponent header = new HeaderComponent(driver);
		
		LoginPage loginPage = header.openLoginPage();
		
		String email = FileUtility.getDataFromPropertiesFile("un");
		String password = FileUtility.getDataFromPropertiesFile("pwd");
		
		MyAccountPage accountPage = loginPage.login(email, password);
		
		Assert.assertTrue(accountPage.isPageDisplayed(), "Account Page is not displayed");
		
		// search product		
		String keyword = "iPhone";
		
		SearchPage searchpage = header.searchProduct(keyword);
		
		List<WebElement> totalProducts = searchpage.getTotalProductCards();
		
		// first validation
		if(totalProducts.size() > 0)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false, "No products are displayed");
		
		ProductCardComponent card = new ProductCardComponent(driver);
		
		header = card.clickAddToCart();
		
		CartPage cartpage = header.openCart();
		
		// second validation 
		Assert.assertTrue(cartpage.isPageDisplayed(), "Cart page is not displayed");
		
		// Third validation
		Assert.assertTrue(cartpage.isProductAdded(keyword), "Product is not added to the cart");
		
	}
}
