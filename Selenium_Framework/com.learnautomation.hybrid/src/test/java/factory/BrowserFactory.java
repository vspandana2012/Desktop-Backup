package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigDataProvider;

public class BrowserFactory {//factory returns the objects, here the browser factory returns broser objects

	static WebDriver driver;
	
	public static WebDriver getBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
		driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Chrome"))
		{
			//ConfigDataProvider config = new ConfigDataProvider();
			//System.setProperty("webdriver.chrome.driver",config.getChromePath());
			//These two are can be written in a single line because of DataProviderFactory
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			//ConfigDataProvider config = new ConfigDataProvider();
			//System.setProperty("webdriver.ie.driver", config.getIEPath());
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEPath());
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void closeBrowser(WebDriver driver) {
		driver.quit();
	}
}

