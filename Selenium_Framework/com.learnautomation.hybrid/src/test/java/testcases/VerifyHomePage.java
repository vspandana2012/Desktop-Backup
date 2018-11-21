package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.HomePage;

import dataProvider.ExcelDataProvider;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import utility.ExcelDataConfig;

public class VerifyHomePage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = BrowserFactory.getBrowser("Chrome");
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}

	@Test
	public void testHomePage() {
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		String title = home.getApplicationTitle();
		
		//System.out.println("My Application title is" +title);
		
		Assert.assertTrue(title.contains("Free CRM"));

//		HomePage login = PageFactory.initElements(driver, HomePage.class);
//		
//		ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\Nbarnana\\Desktop\\Selenium_Framework\\com.learnautomation.hybrid\\ApplicationTestData\\AppData.xlsx");
//		
//		//ExcelDataProvider excel = new ExcelDataProvider("C:\\Users\\Nbarnana\\Desktop\\Selenium_Framework\\com.learnautomation.hybrid\\ApplicationTestData\\AppData.xlsx");
//		//login.loginApplication("naveenk", "test@123");//hardcoding the values
//		System.out.println(excel.getCellData("Sheet1", 0, 0));
//		login.loginApplication(excel.getCellData("Sheet1", 0, 0),excel.getCellData("Sheet1", 0, 1));//to get the login credentials from the excel (int sheetnum,int row,int col)
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		BrowserFactory.closeBrowser(driver);
	}
}
