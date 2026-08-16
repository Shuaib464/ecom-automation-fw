package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_utility.BasePage;

public class AccountCreationConfirmationPage extends BasePage{
	
	// locators
	@FindBy(xpath = "//h1[contains(text(), 'Your Account')]")
    private WebElement accountCreationMessage;
	
	@FindBy(partialLinkText = "Continue")
	private WebElement continueButton;
	
	
	
	// constructor
	public AccountCreationConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions
	 public String getAccountCreationMessage() {
	    	return getText(accountCreationMessage);
	    }
	 
	 public MyAccountPage clickContinueButton() {
		 click(continueButton);
		 return new MyAccountPage(driver);
	 }
}
