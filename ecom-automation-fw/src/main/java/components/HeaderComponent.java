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

import object_repository.CartPage;
import object_repository.LoginPage;
import object_repository.RegisterPage;
import object_repository.SearchPage;

public class HeaderComponent {

	private WebDriver driver;
	
	@FindBy(id = "logo")
	private WebElement logo;
	
//	@FindBy(name = "search")
//	private WebElement searchBox;
	private By searchBox = By.name("search");
	
//	 @FindBy(xpath = "//div[@id='search']//button")
//	    private WebElement searchButton;
	private By searchButton = By.xpath("//div[@id='search']//button");

	    @FindBy(xpath = "//a[@title='My Account']")
	    private WebElement accountMenu;

	    @FindBy(id = "wishlist-total")
	    private WebElement wishlist;

//	    @FindBy(xpath = "//a[@title='Shopping Cart']")
//	    private WebElement cart;
	    private By cart = By.xpath("//a[@title='Shopping Cart']");
	    
	    // constructor
	    public HeaderComponent(WebDriver driver) {
	    	this.driver = driver;
	    	PageFactory.initElements(driver, this);
	    }
	    
	    // Actions
	    
	    public void clickLogo() {
	    	logo.click();
	    }
	    
	    
	    public SearchPage searchProduct(String productName) {
	    	WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(10));

	    	 WebElement search = wait.until(
	    	            ExpectedConditions.refreshed(
	    	                    ExpectedConditions.elementToBeClickable(searchBox)
	    	            )
	    	    );

	        search.clear();
	        search.sendKeys(productName);

	        wait.until(
	                ExpectedConditions.elementToBeClickable(searchButton)
	        ).click();
	    	
	    	return new SearchPage(driver);
	    }
	    
	    
	    public void openAccountMenu() {
	    	accountMenu.click();
	    }
	    
	    
	    public LoginPage openLoginPage() {
	    	openAccountMenu();
	    	
	    	WebElement loginLink = driver.findElement(By.xpath("//a[text()='Login']"));
	    	loginLink.click();
	    	return new LoginPage(driver);

	    }
	    
	    public RegisterPage openRegisterPage() {
	    	openAccountMenu();
	    	
	    	WebElement registerLink = driver.findElement(By.xpath("//a[text()='Register']"));   	
	    	registerLink.click();
	    	return new RegisterPage(driver);
	    }
	    
	    public CartPage openCart() {
	    	
	    	WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(
	                ExpectedConditions.elementToBeClickable(cart)
	        ).click();
	    	
	    	return new CartPage(driver);
	    }
	    
	    
	    

}
