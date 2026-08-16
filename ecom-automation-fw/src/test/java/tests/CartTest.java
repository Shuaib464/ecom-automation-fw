package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.AuthenticationTest;
import components.HeaderComponent;
import components.ProductCardComponent;
import object_repository.CartPage;
import object_repository.SearchPage;

public class CartTest extends AuthenticationTest {

	@Test(groups = {"smoke", "positive"})
	public void verifyAddToCartProduct() {
		
		HeaderComponent header = new HeaderComponent(driver);
		
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
	
	/*
	@Test(groups = {"critical","regression"})
	public void verifyCartQunatityModification() {
		
		HeaderComponent header = new HeaderComponent(driver);
		
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
		
		cartpage.modifyProductQuantity("4");
		
		Assert.assertTrue(cartpage.isModifyQunatityMsgDisplayed(), "Qunatity modification success message is not displayed");
		
		
	}
			*/
	
	
	
}
