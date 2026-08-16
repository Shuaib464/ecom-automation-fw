package listener_utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base_utility.BaseTest;
import base_utility.DriverFactory;
import generic_utility.JavaUtility;

public class Listener_Imp implements ISuiteListener, ITestListener{
	ExtentSparkReporter reporter;
	ExtentTest test;
	ExtentReports report;
	
	public Listener_Imp() {
		report = new ExtentReports();
	}
	
	@Override
	public void onStart(ISuite suite) {
		// ********** report configuration *************
		
		System.out.println("===== LISTENER onTestStart CALLED =====");

	    test = report.createTest("Dummy name");
		
String rep = JavaUtility.currentTime();
		
		reporter = new ExtentSparkReporter("./reports/" + rep + ".html");
		reporter.config().setDocumentTitle("Ecommerce-Automation");
		reporter.config().setReportName(suite.getName() + " report");
		reporter.config().setTheme(Theme.DARK);
		
		
		report.attachReporter(reporter);
		
		// add env info
		report.setSystemInfo("User", "Shuaib");
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Browser", "Chrome");
		
	}
	
	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());
//		test = report.createTest(result.getMethod().getMethodName());    // other way to fetch method name
	}
	
	@Override 
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getName() + " passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getName() + " is failed");
//		TakesScreenshot tks = (TakesScreenshot) result.getTestContext().getAttribute("driver");
		TakesScreenshot tks = (TakesScreenshot) DriverFactory.getDriver();
		String ss = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss, JavaUtility.currentTime());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getName() + " is skipped");
	}
	
	
}
