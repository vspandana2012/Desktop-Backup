package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalDetailsPage {

	final WebDriver driver;
	
	public PersonalDetailsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Personal Details')]")
	public static WebElement PersonalDetailsLink;
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='btnSave']")
	public static WebElement EditButton;
	
	@FindBy(how = How.ID, using = "personal_txtLicExpDate")
	public static WebElement LicenseExpiryDate;
	
	@FindBy(how = How.ID, using = "personal_optGender_1")
	public static WebElement GenderCheckBox;
	
	@FindBy(how = How.ID, using = "personal_cmbNation")
	public static WebElement Nationality;
	
	@FindBy(how = How.ID, using = "personal_cmbMarital")
	public static WebElement MaritalStatus;
	
	@FindBy(how = How.ID, using = "personal_DOB")
	public static WebElement personalDOB;
	
	@FindBy(how = How.ID, using = "btnSave")
	public static WebElement SaveButton;
	
	
	
}
