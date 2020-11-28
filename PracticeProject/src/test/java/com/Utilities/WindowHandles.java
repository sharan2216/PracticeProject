package com.Utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandles {
	static WebDriver driver;
public static void main(String []args) throws InterruptedException
{
	BrowserFactory.StartApplication(driver,"Chrome","https://www.primelocation.com/");
	Thread.sleep(5000);
	Set<String> handler=driver.getWindowHandles();
	Iterator<String> itr=handler.iterator();
	String parentwindowid=itr.next();
	System.out.println("parent window"+parentwindowid);
	
	Iterator<String> childitr=handler.iterator();
	String childwindowid=itr.next();
	System.out.println("child window"+childwindowid);
	System.out.println(driver.getTitle());
	
	driver.switchTo().window(childwindowid);
	driver.close();
	driver.switchTo().window(parentwindowid);
	
}
	
}
