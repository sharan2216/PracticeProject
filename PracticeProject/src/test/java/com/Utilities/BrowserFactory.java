package com.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	public static String appUrl="https://www.zoopla.co.uk/";
	public static WebDriver driver;
	
	public static WebDriver StartApplication(WebDriver driver,String browserName,String aapUrl) throws InterruptedException
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Drivers/Chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("iexplore"))
		{
			System.setProperty("webdriver.ie.driver","./Drivers/iexplore.exe");
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("we dont support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		//Thread.sleep(3000);
		driver.manage().window().maximize();
		//Thread.sleep(2000);
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		return driver;
		
	}
public static void quitBrowser()
{
	driver.close();
}
}
