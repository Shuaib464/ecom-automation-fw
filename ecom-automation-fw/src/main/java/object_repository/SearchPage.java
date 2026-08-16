package object_repository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base_utility.BasePage;

public class SearchPage extends BasePage{
	
	// locators
	
//	@FindBy(xpath = "//div[@class='product-thumb']")
//    private List<WebElement> productCards;
	
	@FindBy(xpath = "//h1[contains(text(),'Search - ')]")
	private WebElement searchHeading;
	
	@FindBy(xpath = "//p[contains(text(),'There is no product')]")
	private WebElement noProductMessage;
	
	// constructor
	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions
	 public String getSearchHeading() {
	    	return getText(searchHeading);
	    }
	 
	 public boolean isPageDisplayed() {
		 return isDisplayed(searchHeading);
	 }
	 
	// private By noPrductMsg = By.xpath("//p[contains(text(),'There is no product')]");
	 
	 /*
	 public boolean isNoProductMessageDisplayed() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(noPrductMsg));
		 return isDisplayed(noProductMessage);
	 }
	 */
	 private By productCards = By.xpath("//div[@class='product-thumb']");
	 
	 public List<WebElement> getTotalProductCards(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productCards));
		  
		 List<WebElement> totalProducts = driver.findElements(By.xpath("//div[@class='product-thumb']"));
		 System.out.println("total : "+ totalProducts.size());
		 return totalProducts;
	 }
	 

}
