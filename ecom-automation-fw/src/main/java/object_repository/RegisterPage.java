package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_utility.BasePage;

public class RegisterPage extends BasePage{
	
	 // Locators
    @FindBy(name = "firstname")
    private WebElement firstnameInput;
    
    @FindBy(name = "lastname")
    private WebElement lastnameInput;
    
    @FindBy(name = "email")
    private WebElement emailInput;
    
    @FindBy(name = "telephone")
    private WebElement telephoneInput;
    
    @FindBy(name = "confirm")
    private WebElement confirmPasswordInput;

    @FindBy(name = "password")
    private WebElement passwordInput;
    
    @FindBy(name = "agree")
    private WebElement privacyPolicyCheck;
    
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;
    

    
    
    // constructor
    public RegisterPage(WebDriver driver) {
    	super(driver);
    	
    	PageFactory.initElements(driver, this);
    }
    
    // Actions
    public RegisterPage enterFirstName(String fname) {
    	type(firstnameInput, fname);
    	return this;
    }
    
    public RegisterPage enterLastName(String lname) {
    	type(lastnameInput, lname);
    	return this;
    }
    
    public RegisterPage enterEmail(String email) {
    	type(emailInput, email);
    	return this;
    }
    
    public RegisterPage enterTelephone(String telephone) {
    	type(telephoneInput, telephone);
    	return this;
    }
    
    public RegisterPage enterPassword(String password) {
    	type(passwordInput, password);
    	return this;
    }
    
    public RegisterPage enterConfirmPassword(String password) {
    	type(confirmPasswordInput, password);
    	return this;
    }
    
    public RegisterPage clickPrivacyPolicy() {
    	click(privacyPolicyCheck);
    	return this;
    }
    
    public void clickContinue() {
    	click(continueButton);;
    }
    
    public AccountCreationConfirmationPage registerWithCompulsary(String fname, String lname, String email, String telephone, String password, String confirmPass) {
    	enterFirstName(fname)
    		.enterLastName(lname)
    		.enterEmail(email)
    		.enterTelephone(telephone)
    		.enterPassword(password)
    		.enterConfirmPassword(confirmPass)
    		.clickPrivacyPolicy()
    		.clickContinue();
    	
    	return new AccountCreationConfirmationPage(driver);
    }
    
    
   
    /*
    public boolean isErrorMessageDisplayed() {
    	return isDisplayed(errorMessage);
    }
    
    public boolean isPageDisplayed() {
    	return isDisplayed(returningCustomerHeading);
    }
    */
    
}
