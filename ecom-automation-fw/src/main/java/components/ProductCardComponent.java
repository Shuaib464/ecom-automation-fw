package components;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import object_repository.LoginPage;
import object_repository.RegisterPage;

public class ProductCardComponent {

	private WebDriver driver;
	
	@FindBy(xpath= "//div[@class='image']//img")
	private WebElement productImage;
	
	@FindBy(xpath = "//div[@class='caption']//h4")
	private WebElement productName;
	
	 @FindBy(xpath = "//div[@class='caption']//p[@class='price']")
	    private WebElement productPrice;

//	    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
//	    private WebElement addToCartButton;
	    
	    private By addToCartButton = By.xpath("//span[contains(text(),'Add to Cart')]");

	    
	    
	    // constructor
	    public ProductCardComponent(WebDriver driver) {
	    	this.driver = driver;
	    	PageFactory.initElements(driver, this);
	    }
	    
	    
	    
	    // Actions
	    public HeaderComponent clickAddToCart() {
	    	WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(
	                ExpectedConditions.elementToBeClickable(addToCartButton)
	        ).click();
	        
	    	return new HeaderComponent(driver);
	    }
	    
	    public String getProductName() {
	    	return productName.getText();
	    }
	    
	    public String getProductPrice() {
	    	return productPrice.getText();
	    }
	    
	    public boolean isProductImageDisplayed() {
	    	return productImage.isDisplayed();
	    }
	   
	    
	    

}
