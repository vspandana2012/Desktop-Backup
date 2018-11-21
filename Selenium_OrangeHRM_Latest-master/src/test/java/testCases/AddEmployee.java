package testCases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dataProvider.ExcelDataConfig;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.AddEmployeePage;
import pages.OrangeHRMLogin;
import pages.PersonalDetailsPage;
import utility.BaseExtentTest;
import utility.GetScreenshot;
import utility.Highlight;

public class AddEmployee extends BaseExtentTest{
	
	

	//static WebDriver driver;
	static AddEmployeePage AddEmpPage;
	static OrangeHRMLogin PageLogin;
	static PersonalDetailsPage PersonalDTPage;
	 //AddEmployeePage addEmpPage;
	
	static ExcelDataConfig excel = new ExcelDataConfig("F:\\Selenium Framework\\com.hybridFramework\\ApplicationTestData\\TestData.xlsx");
	
	/*
	@SuppressWarnings("static-access")
	@BeforeTest
	public static void AppOrangeHRMLogin(){
		
		
		logger = extent.createTest("AppOrangeHRMLogin");
		//this will automatically opens the browser, maximize the browser
		driver = BrowserFactory.getBrowser("Chrome");
										
		//this will provide the URL from the config.properties file
		driver.get(DataProviderFactory.getConfig().getApplicationurl());
								
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		PageLogin=PageFactory.initElements(driver, OrangeHRMLogin.class);
		Highlight.highLightElement(driver, OrangeHRMLogin.txtbx_UserName);
		Highlight.highLightElement(driver, OrangeHRMLogin.txtbx_Password);
		PageLogin.OrangeLogin(DataProviderFactory.getConfig().getusername(), DataProviderFactory.getConfig().getpassword());
		
		
	}
	
	*/
	
	@SuppressWarnings("static-access")
	@Test
	public static void addEmployee() throws Exception{
		
		
		AddEmpPage=PageFactory.initElements(driver, AddEmployeePage.class);
		//AddEmployeePage.PIMLink.click();
		
		AddEmpPage.PIMLink.click();
		Thread.sleep(5000);
		
		Highlight.highLightElement(driver, AddEmployeePage.AddEmployeeButton);
		AddEmpPage.AddEmployeeButton.click();
		Thread.sleep(5000);
		
		Highlight.highLightElement(driver, AddEmployeePage.FirstName);
		AddEmpPage.FirstName.sendKeys("Narayana14");
		
		Highlight.highLightElement(driver, AddEmployeePage.LastName);
		AddEmpPage.LastName.sendKeys("Barnana14");
		
		Highlight.highLightElement(driver, AddEmployeePage.EmployeeId);
		AddEmpPage.EmployeeId.sendKeys("133454");
		
		Highlight.highLightElement(driver, AddEmployeePage.Photograph);
		AddEmpPage.Photograph.click();
		
		Runtime.getRuntime().exec("C:\\Users\\Narayana\\Desktop\\ORAddempFileUpload.exe");
		
		
		
		Highlight.highLightElement(driver, AddEmployeePage.CreateLoginCheckBox);
		AddEmpPage.CreateLoginCheckBox.click();
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("user_name"))));
		
		Highlight.highLightElement(driver, AddEmployeePage.empUserName);
		AddEmpPage.empUserName.sendKeys("Narayana14");
		
		Highlight.highLightElement(driver, AddEmployeePage.empPassword);
		AddEmpPage.empPassword.sendKeys("Test@009");
		
		
		Highlight.highLightElement(driver, AddEmployeePage.empConfirmPassword);
		AddEmpPage.empConfirmPassword.sendKeys("Test@009");
		
		Highlight.highLightElement(driver, AddEmployeePage.empStatus);
		Select statusdd=new Select(AddEmployeePage.empStatus);
        statusdd.selectByVisibleText("Enabled");

		Highlight.highLightElement(driver, AddEmployeePage.SaveEmployeeButton);
		AddEmpPage.SaveEmployeeButton.click();
		
		GetScreenshot.capture(driver, "AddEmplooyeePage");
		
		//Edit the Personal details
		PersonalDTPage=PageFactory.initElements(driver, PersonalDetailsPage.class);
		
		Thread.sleep(5000);
		//Highlight.highLightElement(driver, PersonalDTPage.PersonalDetailsLink);
		//PersonalDTPage.PersonalDetailsLink.click();
		
		Highlight.highLightElement(driver, PersonalDTPage.EditButton);
		PersonalDTPage.EditButton.click();
		
		WebDriverWait WaitNat=new WebDriverWait(driver,10);
		WaitNat.until(ExpectedConditions.visibilityOfElementLocated((By.id("personal_cmbNation"))));
		
		Date myDate = new Date();
		System.out.println(myDate);
		//System.out.println(new SimpleDateFormat("MM/dd/yyyy").format(myDate));
		String DateF=new SimpleDateFormat("yyyy-MM-dd").format(myDate);
		System.out.println("The date format is " + DateF);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(myDate));
		System.out.println(myDate);
		
		Highlight.highLightElement(driver, PersonalDTPage.LicenseExpiryDate);
		//PersonalDTPage.LicenseExpiryDate.sendKeys(DateF);
		PersonalDTPage.LicenseExpiryDate.clear();
		PersonalDTPage.LicenseExpiryDate.sendKeys(DateF);
		
		Highlight.highLightElement(driver, PersonalDTPage.GenderCheckBox);
		PersonalDTPage.GenderCheckBox.click();
		
		Highlight.highLightElement(driver, PersonalDTPage.MaritalStatus);
		Select MaritalStatusdd=new Select(PersonalDTPage.MaritalStatus);
		MaritalStatusdd.selectByVisibleText("Single");
		
		Highlight.highLightElement(driver, PersonalDTPage.Nationality);
		Select Nationalitydd=new Select(PersonalDTPage.Nationality);
		Nationalitydd.selectByVisibleText("Indian");
		
		String dob="1991-12-04";
		Highlight.highLightElement(driver, PersonalDTPage.personalDOB);
		PersonalDTPage.personalDOB.clear();
		PersonalDTPage.personalDOB.sendKeys(dob);
		
		Highlight.highLightElement(driver, PersonalDTPage.SaveButton);
		PersonalDTPage.SaveButton.click();
		
		GetScreenshot.capture(driver, "PersonalDetails");
		
		Thread.sleep(5000);
		
		//homepage.Logout();
        
        //BrowserFactory.closeBrowser(driver);
		
	}
	
	/*
	@SuppressWarnings("static-access")
	@Test(dependsOnMethods="addEmployee")
	public static void EditPersonalDetails() throws Exception
	{
		PersonalDTPage=PageFactory.initElements(driver, PersonalDetailsPage.class);
		
		Thread.sleep(5000);
		//Highlight.highLightElement(driver, PersonalDTPage.PersonalDetailsLink);
		//PersonalDTPage.PersonalDetailsLink.click();
		
		Highlight.highLightElement(driver, PersonalDTPage.EditButton);
		PersonalDTPage.EditButton.click();
		
		WebDriverWait WaitNat=new WebDriverWait(driver,10);
		WaitNat.until(ExpectedConditions.visibilityOfElementLocated((By.id("personal_cmbNation"))));
		
		Date myDate = new Date();
		System.out.println(myDate);
		//System.out.println(new SimpleDateFormat("MM/dd/yyyy").format(myDate));
		String DateF=new SimpleDateFormat("yyyy-MM-dd").format(myDate);
		System.out.println("The date format is " + DateF);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(myDate));
		System.out.println(myDate);
		
		Highlight.highLightElement(driver, PersonalDTPage.LicenseExpiryDate);
		//PersonalDTPage.LicenseExpiryDate.sendKeys(DateF);
		PersonalDTPage.LicenseExpiryDate.clear();
		PersonalDTPage.LicenseExpiryDate.sendKeys(DateF);
		
		Highlight.highLightElement(driver, PersonalDTPage.GenderCheckBox);
		PersonalDTPage.GenderCheckBox.click();
		
		Highlight.highLightElement(driver, PersonalDTPage.MaritalStatus);
		Select MaritalStatusdd=new Select(PersonalDTPage.MaritalStatus);
		MaritalStatusdd.selectByVisibleText("Single");
		
		Highlight.highLightElement(driver, PersonalDTPage.Nationality);
		Select Nationalitydd=new Select(PersonalDTPage.Nationality);
		Nationalitydd.selectByVisibleText("Indian");
		
		String dob="1991-12-04";
		Highlight.highLightElement(driver, PersonalDTPage.personalDOB);
		PersonalDTPage.personalDOB.clear();
		PersonalDTPage.personalDOB.sendKeys(dob);
		
		Highlight.highLightElement(driver, PersonalDTPage.SaveButton);
		PersonalDTPage.SaveButton.click();
		
		GetScreenshot.capture(driver, "PersonalDetails");
		
		homepage.Logout();
        
        BrowserFactory.closeBrowser(driver);
	}
	*/
	
	

}
