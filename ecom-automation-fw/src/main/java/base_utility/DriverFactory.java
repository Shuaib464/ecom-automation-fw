package base_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.WebDriverUtility;

public class DriverFactory {

	private DriverFactory() {

	}

	private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

	public static void initializeDriver(String browser) {

		WebDriver driver;

		switch (browser.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser : " + browser);
		}

		WebDriverUtility webUtil = new WebDriverUtility(driver);
		webUtil.maximizeWindow();
		webUtil.waitForPageLoad();
		DRIVER.set(driver);
	}

	public static WebDriver getDriver() {
		return DRIVER.get();
	}

	public static void quitDriver() {
		if (DRIVER.get() != null) {
			DRIVER.get().quit();
			DRIVER.remove();
		}
	}
}
