package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTestInterruptedException;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.HomePage;

import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPageWithReport {
	
	WebDriver driver;
	ExtentHtmlReporter report;
	ExtentReports extent;
	ExtentTest logger;

	
	@BeforeMethod
	public void setUp() {
		
		report = new ExtentHtmlReporter("./Reports/LoginInPageReport.html");//boolean true indicates that if any file exits wth the name it will override it
		
		extent = new ExtentReports();
		
		driver = BrowserFactory.getBrowser("Chrome");
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		logger.
	}

	@Test
	public void testLoginPage() {
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		String title = home.getApplicationTitle();
		
		//System.out.println("My Application title is" +title);
		
		Assert.assertTrue(title.contains("Free CRM"));
	
		HomePage login = PageFactory.initElements(driver, HomePage.class);
		
		//login.loginApplication("naveenk", "test@123");
		
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		
		login.verifyLogoutLink();
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		BrowserFactory.closeBrowser(driver);
	}
}
