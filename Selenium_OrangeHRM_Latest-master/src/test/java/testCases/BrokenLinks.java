package testCases;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utility.BaseExtentTest;

public class BrokenLinks extends BaseExtentTest{
	
	
	@Test(enabled=false)
	public static void FindBrokenLinks() throws Exception
	{
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int linkcount=links.size();
		System.out.println("Total link count is " + linkcount);
		
		for(int i=0;i<linkcount;i++)
		{
			//Returns the element at the specified position in this list.
			WebElement ele=links.get(i);
			
			//getting the attribute value with href
			String url=ele.getAttribute("href");
			
			verifyLinkActive(url);
			
		}
		
		
	}
	
	public static void verifyLinkActive(String linkurl) throws Exception
	{
		
		//Creates a URL Object for string object
		URL url=new URL(linkurl);
		
		//Creates a connection for sending the request 
		HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
		
		httpURLConnect.connect();
		
		//validating the response code. 
		if(httpURLConnect.getResponseCode()==200)
		{
			System.out.println(linkurl + "-" + httpURLConnect.getResponseMessage());
		}
		
		if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
		{
			System.out.println(linkurl + "-" + httpURLConnect.getResponseMessage() + " - " + "-" + HttpURLConnection.HTTP_NOT_FOUND );
		}
		
	}
	
	
}
