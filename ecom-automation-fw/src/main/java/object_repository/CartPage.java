package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base_utility.BasePage;


public class CartPage extends BasePage{
	
	// locators
	@FindBy(xpath = "//h1[contains(text(), 'Shopping Cart')]")
    private WebElement shoppingCartHeading;
	
//	@FindBy(xpath = "//input[contains(@name, 'quantity')]")
//	private WebElement productQuantityInput;
	
	private By productQuantityInput = By.xpath("//input[contains(@name, 'quantity')]");
	
//	@FindBy(xpath = "//div[contains(text(), 'Success: You have modified')]")
//	private WebElement modifyQuantityMessage;
	
	private By modifyQuantityMessage = By.xpath("//div[contains(text(), 'Success: You have modified')]");
	
	
	// constructor
	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions
	 public boolean isPageDisplayed() {
	    	return isDisplayed(shoppingCartHeading);
	    }
	 
	public boolean isProductAdded(String keyword) {
		 By productTitle = By.partialLinkText(keyword);
		 WebElement product = driver.findElement(productTitle);
		 
		return isDisplayed(product);
	}
	
	
	public void modifyProductQuantity(String quantity) {
		WebElement quantityInput = wait.until(
	            ExpectedConditions.elementToBeClickable(productQuantityInput)
	    );

	    quantityInput.clear();
	    quantityInput.sendKeys(quantity);
	    quantityInput.sendKeys(Keys.ENTER);
	}
	
	
	public boolean isModifyQunatityMsgDisplayed() {
		WebElement modificationMessage = driver.findElement(modifyQuantityMessage);
		
		return isDisplayed(modificationMessage);
	}
}
