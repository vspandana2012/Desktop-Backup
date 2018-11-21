package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddEmployeePage {

	final WebDriver driver;
	
	public AddEmployeePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how = How.ID, using = "menu_pim_viewPimModule")
	public static WebElement PIMLink;
	//
	
	@FindBy(how = How.ID, using = "menu_pim_addEmployee")
	public static WebElement AddEmployeeButton;
	
	@FindBy(how = How.ID, using = "firstName")
	public static WebElement FirstName;
	
	@FindBy(how = How.ID, using = "lastName")
	public static WebElement LastName;
	
	@FindBy(how = How.ID, using = "employeeId")
	public static WebElement EmployeeId;
	
	@FindBy(how = How.ID, using = "chkLogin")
	public static WebElement CreateLoginCheckBox;
	
	@FindBy(how = How.ID, using = "btnSave")
	public static WebElement SaveEmployeeButton;
	
	@FindBy(how = How.ID, using = "user_name")
	public static WebElement empUserName;
	
	@FindBy(how = How.ID, using = "user_password")
	public static WebElement empPassword;
	
	@FindBy(how = How.ID, using = "re_password")
	public static WebElement empConfirmPassword;
	
	@FindBy(how = How.ID, using = "status")
	public static WebElement empStatus;
	
	@FindBy(how = How.ID, using = "photofile")
	public static WebElement Photograph;
	
	
}
