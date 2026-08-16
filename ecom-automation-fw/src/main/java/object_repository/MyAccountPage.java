package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_utility.BasePage;

public class MyAccountPage extends BasePage{
	
	// Locators
	
	@FindBy(linkText = "Account")
	private WebElement accountNavLink;
	
	@FindBy(xpath = "//h2[text()='My Account']")
	private WebElement myAccountHeading;
	
	
	// Constructor
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions
	
	public boolean isPageDisplayed() {
		return isDisplayed(myAccountHeading);
	}
}
