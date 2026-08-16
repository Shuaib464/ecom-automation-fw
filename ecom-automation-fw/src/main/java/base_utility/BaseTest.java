package base_utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import generic_utility.FileUtility;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void setup(@Optional("chrome") String browser) throws IOException {
		
		// for mvn command (if present)
		String browserOverride = System.getProperty(browser);
		
		if(browserOverride != null) {
			browser = browserOverride;
		}
		
		DriverFactory.initializeDriver(browser);
		
		driver = DriverFactory.getDriver();
		
		// navigate to application
		driver.get(FileUtility.getDataFromPropertiesFile("url"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		DriverFactory.quitDriver();
	}
}
