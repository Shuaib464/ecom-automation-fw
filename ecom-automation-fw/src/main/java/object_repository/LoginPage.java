package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_utility.BasePage;

public class LoginPage extends BasePage{
	
	 // Locators
    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(),'Warning: No match')]")
    private WebElement errorMessage;

    @FindBy(partialLinkText = "Forgot Password")
    private WebElement forgotPasswordLink;
    
    @FindBy(xpath = "//h2[text()='Returning Customer']")
    private WebElement returningCustomerHeading;
    
    // constructor
    public LoginPage(WebDriver driver) {
    	super(driver);
    	
    	PageFactory.initElements(driver, this);
    }
    
    // Actions
    public LoginPage enterEmail(String email) {
    	type(emailInput, email);
    	return this;
    }
    
    public LoginPage enterPassword(String password) {
    	type(passwordInput, password);
    	return this;
    }
    
    public void clickLogin() {
    	click(loginButton);;
    }
    
    public MyAccountPage login(String email, String password) {
    	System.out.println("login.....");
    	enterEmail(email).enterPassword(password).clickLogin();
    	return new MyAccountPage(driver);
    }
    
    public String getErrorMessage() {
    	return getText(errorMessage);
    }
    
    public boolean isErrorMessageDisplayed() {
    	return isDisplayed(errorMessage);
    }
    
    public boolean isPageDisplayed() {
    	return isDisplayed(returningCustomerHeading);
    }
    
    
}
