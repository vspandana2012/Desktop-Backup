package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
	}

	@FindBy(xpath="//a[text() = \"Features\"]") WebElement featuresLink;
	@FindBy(xpath="//font[@color='red'][text() =\"Sign Up\"]") WebElement signUpLink;
	@FindBy(xpath="//a[text()=\"Pricing\"]") WebElement pricingLink;
	@FindBy(xpath="//a[text() = \"Customers\"]")WebElement customersLink;
	@FindBy(xpath="//a[text()=\"Contact\"]") WebElement contactLink;

	@FindBy(name = "username") WebElement userName;
	@FindBy(name = "password") WebElement passWord;
	@FindBy(xpath = "//input[@value ='Login']") WebElement loginButton;
	//@FindBy(xpath = "//a[contains(text(),'out')]") WebElement logoutButton; //This logBottuon is not in verifyLogout method because when we use explicit wait the driver will search for a object in 
																			//By class.It cannot identify WebElement so we need to declare the logoutButton as an object of By class as shown in next step
	
	By logoutButton = By.xpath("//a[contains(text(),'out')]");
	
	public void clickOnFeaturesLink() {
		featuresLink.click();
	}
	public void clickOnSignUpLink() {
		signUpLink.click();
	}
	public void clickOnPricingLink() {
		pricingLink.click();
	}
	public void clickOnCustomersLink() {
		customersLink.click();
	}
	public void clickOnContactLink() {
		contactLink.click();
	}
	public String getApplicationTitle() {
		return driver.getTitle();
	}
	
	public void loginApplication(String user, String pass) {
		
		userName.sendKeys(user);
		passWord.sendKeys(pass);
		//loginButton.click();
		//WebElement login=driver.findElement(By.xpath("//input[@type='submit']"));//already intilaized the webelement above the  method
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", loginButton);
	}
	
	public void verifyLogoutLink() {//signout link might appear after sometime so we need to use dynamic wait i.e to wait till that element appears
		
		driver.switchTo().frame("mainpanel");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(logoutButton));
		
		String text = ele.getText();
		Assert.assertEquals(text, "  Logout  ","Logout link is not verified properly");
		ele.click();
	}
}
