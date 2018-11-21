package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.HomePage;

import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = BrowserFactory.getBrowser("Chrome");
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
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
