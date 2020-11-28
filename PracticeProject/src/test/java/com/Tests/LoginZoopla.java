package com.Tests;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.Pages.LoginPage;
import com.Utilities.BrowserFactory;


public class LoginZoopla {
	WebDriver driver;
	@Test
	public void loginApp() throws InterruptedException, AWTException
	{
		
		BrowserFactory.StartApplication(driver,"Chrome","https://www.zoopla.co.uk/");
		Thread.sleep(3000);


Robot robot = new Robot();
robot.mouseMove(1000,760);
//robot.mousePress(buttons);
robot.mousePress(InputEvent.BUTTON1_MASK);
robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
Thread.sleep(3000);
robot.mouseMove(1300,140);
robot.mousePress(InputEvent.BUTTON1_MASK);
robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

Thread.sleep(8000);
		LoginPage loginpage=PageFactory.initElements(driver,LoginPage.class);
		//loginpage.LoginToZoopla("sasa111nasa@gmail.com","jhonny66");
		loginpage.LoginToZoopla();
		
		//BrowserFactory.quitBrowser();
	}

}
